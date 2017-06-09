package com.example.guest.meat.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Typeface;

import com.example.guest.meat.Constants;
import com.example.guest.meat.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.findRecipeButton) Button mFindRecipeButton;
    @Bind(R.id.typeOfMeat) EditText mTypeOfMeat;
    @Bind(R.id.meatLogo) TextView mMeatLogo;
    @Bind(R.id.userIcon) TextView mUserIcon;
    @Bind(R.id.aboutIcon) TextView mAboutIcon;
    @Bind(R.id.contactIcon) TextView mContactIcon;

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        Typeface logoFont = Typeface.createFromAsset(getAssets(), "fonts/EricaOne-Regular.ttf");
        mMeatLogo.setTypeface(logoFont);

        Typeface userIcon = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        mUserIcon.setTypeface(userIcon);

        Typeface aboutIcon = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        mAboutIcon.setTypeface(aboutIcon);

        Typeface contactIcon = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
        mContactIcon.setTypeface(contactIcon);

        mFindRecipeButton.setOnClickListener(this);
        mAboutIcon.setOnClickListener(this);
        mContactIcon.setOnClickListener(this);
        mUserIcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mFindRecipeButton) {
                String typeOfMeat = mTypeOfMeat.getText().toString().toLowerCase();
            if(!(typeOfMeat).equals("")) {
                addToSharedPreferences(typeOfMeat);
            }
                Intent intent = new Intent(MainActivity.this, RecipeListActivity.class);
                intent.putExtra("typeOfMeat", typeOfMeat);
                startActivity(intent);
        } else if (v == mAboutIcon) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        } else if (v == mContactIcon) {
            Intent intent = new Intent(MainActivity.this, ContactActivity.class);
            startActivity(intent);
        } else if (v == mUserIcon) {
            Intent intent = new Intent(MainActivity.this, UserLoginActivity.class);
            startActivity(intent);
        }
    }

    private void addToSharedPreferences(String typeOfMeat) {
        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, typeOfMeat).apply();
    }
}
