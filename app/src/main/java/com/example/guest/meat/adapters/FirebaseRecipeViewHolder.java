package com.example.guest.meat.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.meat.Constants;
import com.example.guest.meat.R;
import com.example.guest.meat.models.Recipe;
import com.example.guest.meat.ui.RecipeDetailActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;


public class FirebaseRecipeViewHolder extends RecyclerView.ViewHolder  {
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    private ChildEventListener mChildEventListener;
    private ArrayList<Recipe> mRecipe = new ArrayList<>();

    public ImageView mRecipeImageView;
    View mView;
    Context mContext;

    public FirebaseRecipeViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
//        itemView.setOnClickListener(this);
    }

    public void bindRecipe(Recipe recipe) {
        mRecipeImageView = (ImageView) mView.findViewById(R.id.recipeImageView);
        ImageView mRecipeImageView = (ImageView) mView.findViewById(R.id.recipeImageView);
        TextView mRecipeNameTextView = (TextView) mView.findViewById(R.id.recipeNameTextView);
        TextView mSourceTextView = (TextView) mView.findViewById(R.id.sourceTextView);


        Picasso.with(mContext)
                .load(recipe.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
                .centerCrop()
                .into(mRecipeImageView);

        mRecipeNameTextView.setText(recipe.getRecipeName());
        mSourceTextView.setText("Posted By: " + recipe.getSource());

    }

//    @Override
//    public void onClick(View view) {
//        final ArrayList<Recipe> recipes = new ArrayList<>();
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RECIPES).child(FirebaseAuth.getInstance().getCurrentUser().getUid());
//        ref.addListenerForSingleValueEvent(new ValueEventListener() {
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    recipes.add(snapshot.getValue(Recipe.class));
//                }
//                int itemPosition = getLayoutPosition();
//
//                Intent intent = new Intent(mContext, RecipeDetailActivity.class);
//                intent.putExtra("position", itemPosition + "");
//                intent.putExtra("recipes", Parcels.wrap(recipes));
//
//                mContext.startActivity(intent);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//    }
}
