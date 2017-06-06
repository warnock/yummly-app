package com.example.guest.meat.ui;


import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.meat.models.Recipe;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.example.guest.meat.R;


public class RecipeDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.recipeImageView ) ImageView mImageLabel;
    @Bind(R.id.recipeNameTextView) TextView mNameLabel;
    @Bind(R.id.ratingTextView) TextView mRatingLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.ingredientList) TextView mIngredientList;



    private Recipe mRecipe;

    public static RecipeDetailFragment newInstance(Recipe recipe) {
       RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
       Bundle args = new Bundle();
       args.putParcelable("recipe", Parcels.wrap(recipe));
       recipeDetailFragment.setArguments(args);
       return recipeDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));


    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yummly.co/#recipe/" + mRecipe.getId()));
            startActivity(webIntent);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);

        mWebsiteLabel.setOnClickListener(this);

        Picasso.with(view.getContext()).load(mRecipe.getImageUrl()).into(mImageLabel);

        mNameLabel.setText(mRecipe.getRecipeName());
        mRatingLabel.setText("Rating: " + mRecipe.getRating() + "/5");
        mIngredientList.setText(android.text.TextUtils.join(", ", mRecipe.getIngredients()));
        mWebsiteLabel.setText("http://www.yummly.co/#recipe/" + mRecipe.getId());

        return view;
    }

}
