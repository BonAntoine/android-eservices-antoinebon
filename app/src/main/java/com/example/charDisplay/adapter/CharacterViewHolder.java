package com.example.charDisplay.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import data.SettingsConstant;

import com.example.android_eservices_antoinebon.DetailsActivity;
import com.example.android_eservices_antoinebon.MainActivity;
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
     * set all view object to their corresponding layout id
     * @param itemView
     */
    public CharacterViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        this.nameTextView = this.itemView.findViewById(R.id.char_name_textview);
        this.speciesTextView = this.itemView.findViewById(R.id.char_species_textview);
        this.genderTextView = this.itemView.findViewById(R.id.char_gender_textview);
        this.charImageView = this.itemView.findViewById(R.id.char_icon_imageview);
        // Set on click listener
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(), DetailsActivity.class);
                intent.putExtra(SettingsConstant.ID_EXTRA_NAME, String.valueOf(characterViewItem.getId()));
                itemView.getContext().startActivity(intent);
            }
        });
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
                .into(charImageView);

    }
}
