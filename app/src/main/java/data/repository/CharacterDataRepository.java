package data.repository;

import java.util.concurrent.Executors;

import data.api.CharacterApi;
import data.api.db.CharacterDatabase;
import data.api.db.CharacterEntity;
import data.api.db.CharacterLocalDataSource;
import data.api.dependencyInjection.DependencyInjection;
import data.api.model.CharacterRM;
import data.api.model.CharacterSearchResponse;
import io.reactivex.Flowable;
import io.reactivex.Single;


public class CharacterDataRepository {

    CharacterLocalDataSource characterLocalDataSource;

    public CharacterDataRepository(CharacterLocalDataSource characterLocalDataSource) {
        this.characterLocalDataSource = characterLocalDataSource;
    }

    public Single<CharacterSearchResponse> getResponse() {
        // TODO merge with the local data

        return DependencyInjection.getRetrofit().create(CharacterApi.class).getCharacterSearchResult("rick");
    }

    public Single<CharacterRM> getById(int id) {
        // if the data is already stored in db then return it, call api and store it otherwise
        final CharacterEntity[] localCharacter = new CharacterEntity[1];

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                localCharacter[0] = characterLocalDataSource.getCharacterById(String.valueOf(id));
            }
        });


        if(localCharacter[0] != null) {
            System.out.println("Congratulation, loading from db" + localCharacter[0].getName());
            Single<CharacterRM> characterRMSingle = Single.just(localCharacter[0].getCharacterRM());
            return characterRMSingle;
        }


        return DependencyInjection.getRetrofit().create(CharacterApi.class).getCharacterById(String.valueOf(id));
    }
}
