package data.api;

import data.SettingsConstant;
import data.api.model.CharacterRM;
import data.api.model.CharacterSearchResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterApi {

    @GET("character")
    Single<CharacterSearchResponse> getCharacterSearchResult(@Query(SettingsConstant.SEARCH_BY_NAME_TERMS) String searchByName);

    @GET("character/{id}")
    Single<CharacterRM> getCharacterById(@Path("id") String id);
}
