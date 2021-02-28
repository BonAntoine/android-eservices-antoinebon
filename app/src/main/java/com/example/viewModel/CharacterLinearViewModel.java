package com.example.viewmodel;

import androidx.annotation.NonNull;

import com.example.charDisplay.adapter.CharacterViewItem;
import com.example.charDisplay.mapper.CharacterMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import androidx.lifecycle.ViewModel;
import data.api.CharacterApi;
import data.api.dependencyInjection.DependencyInjection;
import data.api.model.CharacterSearchResponse;
import data.repository.CharacterDataRepository;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class CharacterLinearViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable;
    private CharacterDataRepository characterDataRepository;

    private List<CharacterViewItem> characterViewItemList = new ArrayList<CharacterViewItem>();

    public CharacterLinearViewModel(CharacterDataRepository characterDataRepository) {
        this.compositeDisposable = new CompositeDisposable();
        this.characterDataRepository = characterDataRepository;
    }

    public void searchCharacters() {
        // TODO handle data loading
        compositeDisposable.clear();
        compositeDisposable.add(characterDataRepository.getResponse().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<CharacterSearchResponse>() {

                    @Override
                    public void onSuccess(@NonNull CharacterSearchResponse characterSearchResponse) {

                        // System.out.println(characterSearchResponse.getCharacterRmList().get(0));
                        characterViewItemList.addAll(CharacterMapper.charResponseToList(characterSearchResponse));
                    }

                    @Override
                    public void onError(Throwable e) {
                        // Just print the error, maybe handling it
                        // would be good
                        System.out.println(e.toString());
                    }
                }));
    }

    public List<CharacterViewItem> getCharacterViewItemList() {
        return characterViewItemList;
    }
}
