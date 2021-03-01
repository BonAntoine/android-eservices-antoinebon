package com.example.charDisplay.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android_eservices_antoinebon.R;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class CharacterViewHolder extends RecyclerView.ViewHolder {

    private View itemView;
    private TextView nameTextView;
    private TextView speciesTextView;
    private TextView genderTextView;
    private ImageView charImageView;

    private CharacterViewItem characterViewItem;

    /**
     * set all
     * @param itemView
     */
    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        this.nameTextView = this.itemView.findViewById(R.id.char_name_textview);
        this.speciesTextView = this.itemView.findViewById(R.id.char_species_textview);
        this.genderTextView = this.itemView.findViewById(R.id.char_gender_textview);
        this.charImageView = this.itemView.findViewById(R.id.char_icon_imageview);
        // TODO Set on click listener
    }

    public void bind(CharacterViewItem characterViewItem) {
        this.characterViewItem = characterViewItem;
        this.nameTextView.setText(characterViewItem.getName());
        this.speciesTextView.setText(characterViewItem.getSpecies());
        this.genderTextView.setText(characterViewItem.getGender());
        // set image

        Glide.with(this.itemView)
                .load(characterViewItem.getCharImageUrl())
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .circleCrop()
                .into(charImageView);

    }
}
