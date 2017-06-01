package com.example.guest.meat;


import java.util.ArrayList;

public class Recipe {
    private String mRecipeName;
    private ArrayList<String> mIngredients = new ArrayList<>();
    private String mImageUrl;
    private String mRating;
    private String mSource;


    public Recipe(String recipeName, ArrayList<String> ingredients, String imageUrl, String rating, String source) {
        this.mRecipeName = recipeName;
        this.mIngredients = ingredients;
        this.mImageUrl = imageUrl;
        this.mRating = rating;
        this.mSource = source;

    }

    public String getRecipeName() {
        return mRecipeName;
    }

    public ArrayList<String> getIngredients() {
        return mIngredients;
    }

    public String getImageUrl() {
        return  mImageUrl;
    }

    public String getRating() {
        return mRating;
    }

    public String getSource() {
        return mSource;
    }


}
