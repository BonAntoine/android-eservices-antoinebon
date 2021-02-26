package data.api.dependencyInjection;

import com.example.viewmodel.ViewModelFactory;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;

import androidx.lifecycle.ViewModel;
import data.SettingsConstant;
import data.repository.CharacterDataRepository;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DependencyInjection {

    private static Retrofit retrofit;
    private static Gson gson;
    private static ViewModelFactory viewModelFactory;
    private static CharacterDataRepository characterDataRepository;

    /**
     *
     * @return retrofit instance wuth the given URL in the setting constant file
     */
    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(new StethoInterceptor())
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(SettingsConstant.DEFAULT_API_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(getGson()))
                    .build();
        }
        return retrofit;
    }

    /**
     * If null, create a new instance
     * @return an instance of Gson
     */
    public static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    public static ViewModelFactory getViewModelFactory() {
        if(characterDataRepository == null) {
            characterDataRepository = new CharacterDataRepository();
        }
        if (viewModelFactory == null) {
            viewModelFactory = new ViewModelFactory(characterDataRepository);
        }
        return viewModelFactory;
    }

}
