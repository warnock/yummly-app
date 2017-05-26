package com.example.guest.meat;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * Created by Guest on 5/26/17.
 */

public class MyRecipesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mRecipes;
    private String[] mReviews;

    public MyRecipesArrayAdapter(Context mContext, int resource, String[] mRecipes, String[] mReviews) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mRecipes = mRecipes;
        this.mReviews = mReviews;
    }

    @Override
    public Object getItem(int position) {
        String recipe = mRecipes[position];
        String review = mReviews[position];
        return String.format("%s \n people say: %s", recipe, review);
    }

    @Override
    public int getCount() {
        return mRecipes.length;
    }

}
