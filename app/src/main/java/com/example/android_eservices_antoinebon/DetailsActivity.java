package com.example.android_eservices_antoinebon;

import android.os.Bundle;

import com.example.charDisplay.adapter.CharacterDetailsView;
import com.example.viewmodel.CharacterLinearViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import data.SettingsConstant;
import data.api.model.CharacterRM;
import data.repository.CharacterDataRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import static com.example.charDisplay.mapper.CharacterMapper.charToViewItem;

public class DetailsActivity extends AppCompatActivity {

    CharacterDataRepository characterDataRepository;
    CharacterDetailsView characterDetailsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.details);

        setTitle(R.string.title_detail);

        characterDataRepository = new CharacterDataRepository();
        characterDetailsView = new CharacterDetailsView(findViewById(android.R.id.content));

System.out.println("bbbbb " + getIntent().getStringExtra(SettingsConstant.ID_EXTRA_NAME));
        DisposableSingleObserver<CharacterRM> characterApi = characterDataRepository.getById(Integer.parseInt(getIntent().getStringExtra(SettingsConstant.ID_EXTRA_NAME)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<CharacterRM>() {
                    @Override
                    public void onSuccess(@NonNull CharacterRM characterRM) {
                        System.out.println("aaaa" + charToViewItem(characterRM).getName());
                        characterDetailsView.bind(charToViewItem(characterRM));
                    }
                    @Override
                    public void onError(Throwable e) {
                        // handle the error case
                        //Yet, do not do nothing in this app
                        System.out.println(e.toString());
                    }
                });


    }

}
