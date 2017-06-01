package com.example.guest.meat;


import java.util.ArrayList;

public class Recipe {
    private String mRecipeName;
    private ArrayList<String> mIngredients = new ArrayList<>();
    private String mImageUrl;
    private int mRating;
    private String mSource;
    private String mCuisine;

    public Recipe(String recipeName, ArrayList<String> ingredients, String imageUrl, int rating, String source, String cuisine) {
        this.mRecipeName = recipeName;
        this.mIngredients = ingredients;
        this.mImageUrl = imageUrl;
        this.mRating = rating;
        this.mSource = source;
        this.mCuisine = cuisine;
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

    public int getRating() {
        return mRating;
    }

    public String getSource() {
        return mSource;
    }

    public String getCuisine() {
        return mCuisine;
    }

}
