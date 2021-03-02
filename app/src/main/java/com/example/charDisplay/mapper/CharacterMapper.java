package com.example.charDisplay.mapper;

import com.example.charDisplay.adapter.CharacterViewItem;

import java.util.ArrayList;
import java.util.List;

import data.api.model.CharacterRM;
import data.api.model.CharacterSearchResponse;

public class CharacterMapper {
    /**
     * I made this method static because I don't need an instanciation of it
     * No new is needed, more testable
     * It convert character response into list of object that are adapted to
     * be displayed
     * @return
     */
    public static List<CharacterViewItem> charResponseToList(CharacterSearchResponse characterSearchResponse){

        List<CharacterViewItem> characterViewItemList = new ArrayList<>();

        for (CharacterRM characterrm : characterSearchResponse.getCharacterRmList()) {
            // Transform here
            characterViewItemList.add(characterRmToCharacterViewItem(characterrm));
        }
        return characterViewItemList;

    }

    /**
     * Convert a single character response into a single character view Item
     * @param characterRM
     * @return
     */
    public static CharacterViewItem charToViewItem(CharacterRM characterRM) {

        return characterRmToCharacterViewItem(characterRM);

    }

    /**
     * convert a character to a view item character
     * @param characterRm
     * @return
     */
    private static CharacterViewItem characterRmToCharacterViewItem(CharacterRM characterRm) {
        // TODO check if more transformation is needed for the view object
        // aka : when no name available, name = N.A.
        CharacterViewItem characterViewItem = new CharacterViewItem();
        characterViewItem.setName(characterRm.getName());
        characterViewItem.setGender(characterRm.getGender());
        characterViewItem.setSpecies(characterRm.getSpecies());
        characterViewItem.setCharImageUrl(characterRm.getImgUrl());
        characterViewItem.setId(Integer.parseInt(characterRm.getId()));
        return characterViewItem;
    }
}
