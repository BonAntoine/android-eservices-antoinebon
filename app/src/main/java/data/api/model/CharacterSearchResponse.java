package data.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

// This class is for getting multiple characters (a list of characters)
public class CharacterSearchResponse {
    @SerializedName("results")
    List<CharacterRM> characterRmList;

    public List<CharacterRM> getCharacterRmList() { return characterRmList; }
}
