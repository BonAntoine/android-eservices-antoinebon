package data.api.model;

import data.api.db.CharacterEntity;

// This model will be use in the data part on the application
// RM mean Rick and Morty, to avoid confusion with existing Character classes
public class CharacterRM {

    private String id;
    private String name;
    private String status;
    private String species;
    private String gender;
    private String image;

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
    public CharacterEntity getCharacterEntity() {
        CharacterEntity characterentity = new CharacterEntity();
        characterentity.setGender(this.gender);
        characterentity.setId(this.id);
        characterentity.setImgUrl(this.image);
        characterentity.setName(this.name);
        characterentity.setSpecies(this.species);
        characterentity.setStatus(this.status);
        return characterentity;
    }
}
