package com.example.charDisplay.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_eservices_antoinebon.R;
import com.example.charDisplay.adapter.CharacterAdapter;
import com.example.charDisplay.adapter.CharacterViewItem;
import com.example.viewmodel.CharacterLinearViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import data.api.dependencyInjection.DependencyInjection;

/**
 * Fragment class, it currently support linear and grid layout
 */
public class CharListFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private int layoutType;
    private CharacterAdapter characterAdapter;

    private CharacterLinearViewModel characterLinearViewModel;

    // private constructor to force use newInstance
    private CharListFragment(int layoutType) {
        // TODO improve layout type initialization (grid or linear layout object ?)
        this.layoutType = layoutType;
    }

    // new instance is created each time we call this method
    public static CharListFragment newInstance(int layoutType) {
        return new CharListFragment(layoutType);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.fragment_char_linear, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupRecyclerView();

        // TODO check if call the data here is a good idea
        characterLinearViewModel = new ViewModelProvider(requireActivity(), DependencyInjection.getViewModelFactory()).get(CharacterLinearViewModel.class);
        characterLinearViewModel.searchCharacters();


        characterLinearViewModel.getCharacterViewItemList().observe(getViewLifecycleOwner(), new Observer<List<CharacterViewItem>>() {
                    @Override
                    public void onChanged(List<CharacterViewItem> characterViewItems) {
                        characterAdapter.bindViewModels(characterViewItems);
                    }
                });




    }

    private void setupRecyclerView() {
        recyclerView = rootView.findViewById(R.id.recycler_view);
        characterAdapter = new CharacterAdapter();
        recyclerView.setAdapter(characterAdapter);
        LinearLayoutManager l;
        if(layoutType == 0) {
            l = new LinearLayoutManager(getContext());
        } else {
            // TODO dynamic span count ?
            l = new GridLayoutManager(getContext(), 2);
        }
        l.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(l);
    }


}
