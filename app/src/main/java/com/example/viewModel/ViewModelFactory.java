package com.example.viewmodel;

import com.example.charDisplay.adapter.CharacterViewItem;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import data.repository.CharacterDataRepository;

import com.example.viewModel.CharacterLinearViewModel;

// on init le repo qu'on va utiliser pour créer les view model
// Android crée pour nous les vieux model
public class ViewModelFactory implements ViewModelProvider.Factory {

    private final CharacterDataRepository characterDataRepository;

    public ViewModelFactory(CharacterDataRepository characterDataRepository) {
        this.characterDataRepository = characterDataRepository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CharacterLinearViewModel.class)) {
            return (T) new CharacterLinearViewModel(characterDataRepository);
        }

        throw new IllegalArgumentException("Unknown ViewModel class");

    }
}