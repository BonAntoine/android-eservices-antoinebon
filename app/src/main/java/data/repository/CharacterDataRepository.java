package data.repository;

import data.api.CharacterApi;
import data.api.dependencyInjection.DependencyInjection;
import data.api.model.CharacterSearchResponse;
import io.reactivex.Single;


public class CharacterDataRepository {

    public Single<CharacterSearchResponse> getResponse() {
        // TODO merge with the local data

        return DependencyInjection.getRetrofit().create(CharacterApi.class).getBookSearchResult("rick");
    }
}
