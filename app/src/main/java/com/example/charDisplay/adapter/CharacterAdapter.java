package com.example.charDisplay.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_eservices_antoinebon.R;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterViewHolder>{

    private List<CharacterViewItem> characterViewItemList;
    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_char, parent, false);
        CharacterViewHolder characterViewHolder = new CharacterViewHolder(v);
        return characterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.bind(characterViewItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
