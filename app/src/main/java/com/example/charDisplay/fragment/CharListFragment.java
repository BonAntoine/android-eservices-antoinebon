package com.example.charDisplay.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android_eservices_antoinebon.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Fragment class, it currently support linear and grid layout
 */
public class CharListFragment extends Fragment {

    private View rootView;
    private RecyclerView recyclerView;
    private int layoutType;

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

    private void setupRecyclerView() {
        recyclerView = rootView.findViewById(R.id.recycler_view);
        // recyclerView.setAdapter(bookAdapter);
        LinearLayoutManager l;
        if(layoutType == 0) {
            l = new LinearLayoutManager(getContext());
        } else {
            // TODO dynamic span count ?
            l = new GridLayoutManager(getContext(), 3);
        }
        recyclerView.setLayoutManager(l);
    }


}