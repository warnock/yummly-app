package com.example.guest.meat.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.meat.R;
import com.example.guest.meat.models.Recipe;
import com.example.guest.meat.services.YummlyService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Recipes extends AppCompatActivity {
    public static final String TAG = Recipes.class.getSimpleName();

    @Bind(R.id.meatText) TextView mMeatText;
    @Bind(R.id.listView) ListView mListView;

//    private String[] recipes = new String[] {"Beef chow fun", "Tarragon Chicken",
//            "Lamb", "Best Steak evvvver", "Chicken Chicken", "Duck, Duck. Goose",
//            "Spicy pork", "Yum Yum beef", "Cheeseburger Meatloaf", "Best Steak evvvver", "Chicken Chicken", "Duck, Duck. Goose",
//            "Spicy pork", "Yum Yum beef", "Cheeseburger Meatloaf"};
//
//    private String[] reviews = new String[] {"Great", "5 freaking stars!",
//            "It's okay", "really is the best Steak evvvver", "so gross", "What a clever name and dish!",
//            "Spicy!", "So good, two thumbs up!", "Sounds gross but it's really good", "really is the best Steak evvvver", "so gross", "What a clever name and dish!", "Spicy!", "So good, two thumbs up!", "Sounds gross but it's really good" };

    public ArrayList<Recipe> mRecipes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

//        MyRecipesArrayAdapter adapter = new MyRecipesArrayAdapter(this, android.R.layout.simple_list_item_1, recipes, reviews);
//        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String recipe = ((TextView)view).getText().toString();
//                Toast.makeText(Recipes.this, "Recipe coming soon!", Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String typeOfMeat = intent.getStringExtra("typeOfMeat");
        mMeatText.setText(typeOfMeat + ", it's whats for dinner.");

        getRecipes(typeOfMeat);
    }

    private void getRecipes(String typeOfMeat) {
        final YummlyService yummlyService = new YummlyService();
        yummlyService.findRecipes(typeOfMeat, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response)  {
                mRecipes = yummlyService.processResults(response);

                Recipes.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] recipeNames = new String[mRecipes.size()];
                        for (int i = 0; i < recipeNames.length; i++) {
                            recipeNames[i] = mRecipes.get(i).getRecipeName();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(Recipes.this, android.R.layout.simple_list_item_1, recipeNames);
                        mListView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
