package com.example.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {

    // the attributes for the Friend class
    private String name, bio;
    private int drawableId;
    private float rating;

    // a constructor
    public Friend(String aName, String aBio, int aDrawableId) {
        this.name = aName;
        this.bio = aBio;
        this.drawableId = aDrawableId;
    }

    // getter methods for the class
    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }

    public float getRating() {
        return rating;
    }

    // a setter for the rating field
    public void setRating(float rating) {
        this.rating = rating;
    }
}
