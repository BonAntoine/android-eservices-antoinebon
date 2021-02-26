package com.example.charDisplay.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_eservices_antoinebon.R;

public class CharacterViewHolder extends RecyclerView.ViewHolder {

    private View itemView;
    private TextView nameTextView;

    private CharacterViewItem characterViewItem;

    /**
     * set all
     * @param itemView
     */
    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        this.nameTextView = this.itemView.findViewById(R.id.char_name_textview);

        // TODO Set on click listener
    }

    public void bind(CharacterViewItem characterViewItem) {
        this.characterViewItem = characterViewItem;
        this.nameTextView.setText(characterViewItem.getName());
        // TODO set image
    }
}
