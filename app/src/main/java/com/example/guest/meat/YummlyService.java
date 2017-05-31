package com.example.guest.meat;


import android.util.Log;

import okhttp3.Callback;
import okhttp3.Call;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class YummlyService {

    public static void findRecipes(String typeOfMeat, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YUMMLY_BASE_URL).newBuilder();
//        urlBuilder.addQueryParameter(Constants.API_ID_QUERY_PARAMETER, Constants.YUMMLY_APP_ID);
//        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.YUMMLY_API_KEY);
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

}
