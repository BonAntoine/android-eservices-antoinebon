package com.example.charDisplay.adapter;

/**
 * Class that describe the object used to show information
 * of the character on different list
 */
public class CharacterViewItem {

    private int id;
    private String name;
    private String species;
    private String gender;
    private String charImageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCharImageUrl(String charImageUrl) {
        this.charImageUrl = charImageUrl;
    }

    public String getSpecies() {
        return species;
    }

    public String getGender() {
        return gender;
    }

    public String getCharImageUrl() {
        return charImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
