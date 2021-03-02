package data.api.db;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

public class CharacterLocalDataSource {

    private CharacterDatabase characterDatabase;

    public CharacterLocalDataSource(CharacterDatabase characterDatabase) {
        this.characterDatabase = characterDatabase;
    }

    public CharacterEntity getCharacterById(String id) {
        return characterDatabase.characterDao().getCharacterById(id);
    }

    public List<CharacterEntity> loadCharacters() {
        return characterDatabase.characterDao().loadCharacters();
    }

    public Completable addCharacter(CharacterEntity characterEntity) {
        return characterDatabase.characterDao().addCharacter(characterEntity);
    }

    public Completable deleteCharacter(String id) {
        return characterDatabase.characterDao().deleteCharacter(id);
    }
}
