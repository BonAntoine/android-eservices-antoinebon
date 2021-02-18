package com.example.android_eservices_antoinebon;

import androidx.appcompat.app.AppCompatActivity;
import data.api.CharacterApi;
import data.api.dependencyInjection.DependencyInjection;
import data.api.model.CharacterSearchResponse;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DisposableSingleObserver<CharacterSearchResponse> characterApi = DependencyInjection.getRetrofit().create(CharacterApi.class).getBookSearchResult("rick")
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<CharacterSearchResponse>() {

                            @Override
                            public void onSuccess(@NonNull CharacterSearchResponse characterSearchResponse) {
                                System.out.println(characterSearchResponse.getCharacterRmList().get(0));
                            }

                            @Override
                            public void onError(Throwable e) {
                                // handle the error case
                                //Yet, do not do nothing in this app
                                System.out.println(e.toString());
                            }
                        });

            }
        });

    }
}