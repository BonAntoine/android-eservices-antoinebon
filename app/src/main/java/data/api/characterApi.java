package data.api;

import data.api.model.CharacterSearchResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface characterApi {

    @GET("character")
    Single<CharacterSearchResponse> getBookSearchResult(@Query("name") String searchByName, @Query("key") String apiKey);
}
