package com.example.guest.meat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Recipes extends AppCompatActivity {
    @Bind(R.id.meatText) TextView mMeatText;
    @Bind(R.id.listView) ListView mListView;

    private String[] recipes = new String[] {"Beef chow fun", "Tarragon Chicken",
            "Lamb", "Best Steak evvvver", "Chicken Chicken", "Duck, Duck. Goose",
            "Spicy pork", "Yum Yum beef", "Cheeseburger Meatloaf", "Best Steak evvvver", "Chicken Chicken", "Duck, Duck. Goose",
            "Spicy pork", "Yum Yum beef", "Cheeseburger Meatloaf"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, recipes);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String recipe = ((TextView)view).getText().toString();
                Toast.makeText(Recipes.this, "Recipe coming soon!", Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String typeOfMeat = intent.getStringExtra("typeOfMeat");
        mMeatText.setText(typeOfMeat + ", it's whats for dinner.");
    }
}
