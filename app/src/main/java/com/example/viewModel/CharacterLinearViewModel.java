package com.example.viewModel;

import androidx.annotation.NonNull;

import com.example.charDisplay.adapter.CharacterViewItem;
import com.example.charDisplay.mapper.CharacterMapper;

import java.util.ArrayList;
import java.util.List;

import data.api.CharacterApi;
import data.api.dependencyInjection.DependencyInjection;
import data.api.model.CharacterSearchResponse;
import data.repository.CharacterDataRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CharacterLinearViewModel {

    private CompositeDisposable compositeDisposable;
    private CharacterDataRepository characterDataRepository;

    private List<CharacterViewItem> characterViewItemList = new ArrayList<CharacterViewItem>();


    public void searchCharacters() {
        // TODO handle data loading
        compositeDisposable.clear();
        compositeDisposable.add(characterDataRepository.getResponse().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<CharacterSearchResponse>() {

                    @Override
                    public void onSuccess(@NonNull CharacterSearchResponse characterSearchResponse) {
                        System.out.println(characterSearchResponse.getCharacterRmList().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Just print the error, maybe handling it
                        // would be good
                        System.out.println(e.toString());
                    }
                }));
    }

}
