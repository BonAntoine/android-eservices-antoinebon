package com.example.charDisplay.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.android_eservices_antoinebon.DetailsActivity;
import com.example.android_eservices_antoinebon.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import data.SettingsConstant;

public class CharacterDetailsView {

    private View itemView;
    private TextView nameTextView;
    private TextView speciesTextView;
    private TextView genderTextView;
    private ImageView charImageView;
    private TextView statusTextView;

    private CharacterViewItem characterViewItem;

    /**
     * set all xView objects to their
     * id from the layout
     */
    public CharacterDetailsView(View v) {
        this.itemView = v;
        this.nameTextView = this.itemView.findViewById(R.id.char_details_name_textview);
        this.speciesTextView = this.itemView.findViewById(R.id.char_details_species_textview);
        this.genderTextView = this.itemView.findViewById(R.id.char_details_gender_textview);
        this.charImageView = this.itemView.findViewById(R.id.char_details_icon_imageview);
        this.statusTextView = this.itemView.findViewById(R.id.char_details_status_textview);
    }

    public void bind(CharacterViewItem characterViewItem) {
        this.characterViewItem = characterViewItem;
        this.nameTextView.setText(characterViewItem.getName());
        this.speciesTextView.setText(characterViewItem.getSpecies());
        this.genderTextView.setText(characterViewItem.getGender());
        this.statusTextView.setText(characterViewItem.getStatus());
        // set image

        Glide.with(this.itemView)
                .load(characterViewItem.getCharImageUrl())
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(charImageView);

    }
}
