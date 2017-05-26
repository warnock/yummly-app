package com.example.guest.meat;

import android.content.Intent;
import android.support.constraint.solver.SolverVariable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.findRecipeButton) Button mFindRecipeButton;
    @Bind(R.id.typeOfMeat) EditText mTypeOfMeat;
    @Bind(R.id.meatLogo) TextView mMeatLogo;
    @Bind(R.id.userIcon) TextView mUserIcon;
    @Bind(R.id.aboutIcon) TextView mAboutIcon;
    @Bind(R.id.contactIcon) TextView mContactIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface logoFont = Typeface.createFromAsset(getAssets(), "fonts/EricaOne-Regular.ttf");
        mMeatLogo.setTypeface(logoFont);

        Typeface userIcon = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        mUserIcon.setTypeface(userIcon);

        Typeface aboutIcon = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        mAboutIcon.setTypeface(aboutIcon);

        Typeface contactIcon = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        mContactIcon.setTypeface(contactIcon);

        mFindRecipeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mFindRecipeButton) {
            if(mTypeOfMeat.getText().toString().trim().length() == 0 ) {
                mTypeOfMeat.setError("Give me some MEAT!");
            } else {
                String typeOfMeat = mTypeOfMeat.getText().toString();
                Intent intent = new Intent(MainActivity.this, Recipes.class);
                intent.putExtra("typeOfMeat", typeOfMeat);
                startActivity(intent);
            }
        }
    }
}
