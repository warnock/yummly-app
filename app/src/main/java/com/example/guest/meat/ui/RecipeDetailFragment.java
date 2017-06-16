package com.example.guest.meat.ui;


import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.meat.Constants;
import com.example.guest.meat.models.Recipe;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

import com.example.guest.meat.R;


public class RecipeDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.recipeImageView ) ImageView mImageLabel;
    @Bind(R.id.recipeNameTextView) TextView mNameLabel;
    @Bind(R.id.ratingTextView) TextView mRatingLabel;
    @Bind(R.id.ingredientList) TextView mIngredientList;
    @Bind(R.id.saveRescipeButton) Button mSaveRecipeButton;
    @Bind(R.id.getRecipeButton) Button mGetRecipeButton;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mRecipe.getImageUrl()).into(mImageLabel);

        mNameLabel.setText(mRecipe.getRecipeName());
        mRatingLabel.setText("Rating: " + mRecipe.getRating() + "/5");
        mIngredientList.setText(android.text.TextUtils.join(", ", mRecipe.getIngredients()));

        mSaveRecipeButton.setOnClickListener(this);
        mGetRecipeButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mGetRecipeButton){
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.yummly.co/#recipe/" + mRecipe.getId()));
            startActivity(webIntent);
        } else if(v == mSaveRecipeButton) {
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String uid = user.getUid();

            DatabaseReference recipeRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_RECIPES)
                    .child(uid);

            DatabaseReference pushRef = recipeRef.push();
            String pushId = pushRef.getKey();
            mRecipe.setPushId(pushId);
            pushRef.setValue(mRecipe);

            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }

}
