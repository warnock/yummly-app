package com.example.guest.meat.services;


import android.util.Log;

import com.example.guest.meat.Constants;
import com.example.guest.meat.models.Recipe;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Callback;
import okhttp3.Call;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class YummlyService {

    public static void findRecipes(String typeOfMeat, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YUMMLY_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.SEARCH_QUERY_INGREDIENT, typeOfMeat);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .header(Constants.API_ID_QUERY_PARAMETER, Constants.YUMMLY_APP_ID)
                .header(Constants.API_KEY_QUERY_PARAMETER, Constants.YUMMLY_API_KEY)
                .build();

        Log.d("url", url);

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Recipe> processResults(Response response) {
        ArrayList<Recipe> recipes = new ArrayList<>();

        try {
            if (response.isSuccessful()) {
                String jsonData = response.body().string();

                Log.d("jsonData", jsonData);
                JSONObject yummlyJSON = new JSONObject(jsonData);
                JSONArray matchesJSON = yummlyJSON.getJSONArray("matches");
                for (int i = 0; i < matchesJSON.length(); i++) {
                    JSONObject recipeJSON = matchesJSON.getJSONObject(i);
                    String recipeName = recipeJSON.getString("recipeName");

                    ArrayList<String> ingredients = new ArrayList<>();
                    JSONArray ingredientsJSON = recipeJSON.getJSONArray("ingredients");

                    for (int y = 0; y < ingredientsJSON.length(); y++) {
                        ingredients.add(ingredientsJSON.get(y).toString());
                    }

                    String imageUrl = recipeJSON.getJSONObject("imageUrlsBySize").getString("90");
                    String rating = recipeJSON.getString("rating");
                    String source = recipeJSON.getString("sourceDisplayName");
                    String id = recipeJSON.getString("id");

//                    ArrayList<String> cuisine = new ArrayList<>();
//                    JSONArray cuisineJSON = recipeJSON.getJSONObject("attributes").getJSONArray("cuisine");
//                    for (int c = 0; c < cuisineJSON.length(); c++) {
//                            cuisine.add(cuisineJSON.get(c).toString());
//                    }

                    Recipe recipe = new Recipe(recipeName, ingredients, imageUrl, rating, source, id);
                        recipes.add(recipe);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return recipes;
    }

}
