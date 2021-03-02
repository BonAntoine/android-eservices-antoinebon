package data.api.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import data.api.model.CharacterRM;

@Entity(tableName = "characterentity")
public class CharacterEntity {

    @NonNull
    @PrimaryKey
    private String id;
    private String name;
    private String status;
    private String species;
    private String gender;

    public void setImage(String image) {
        this.image = image;
    }

    private String image;

    public String getImage() {
        return image;
    }


    public String getImgUrl() {
        return image;
    }

    public void setImgUrl(String imgUrl) {
        this.image = imgUrl;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    /**
     * Link from the original object and the local database object
     * @return characterRm
     */
    public CharacterRM getCharacterRM() {
        CharacterRM characterRM = new CharacterRM();
        characterRM.setGender(this.gender);
        characterRM.setId(this.id);
        characterRM.setImgUrl(this.image);
        characterRM.setName(this.name);
        characterRM.setSpecies(this.species);
        characterRM.setStatus(this.status);
        return characterRM;
    }
}