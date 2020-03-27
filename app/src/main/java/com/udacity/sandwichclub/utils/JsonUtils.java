package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        String mainName = null;
        List<String> alsoKnownAs = new ArrayList<>();
        String placeOfOrigin = null;
        String description = null;
        String image = null;
        List<String> ingredients = new ArrayList<>();
        try {
            JSONObject jsonSandwitch = new JSONObject(json);
            JSONObject name = jsonSandwitch.getJSONObject("name");
            mainName = name.getString("mainName");
            JSONArray sandwichNames = name.getJSONArray("alsoKnownAs");
            for ( int i =0; i< sandwichNames.length();i++){
                 alsoKnownAs.add(sandwichNames.getString(i));
                }
            placeOfOrigin= jsonSandwitch.getString("placeOfOrigin");
            description = jsonSandwitch.getString("description");
            image = jsonSandwitch.getString("image");
            JSONArray sandwichIngredients = jsonSandwitch.getJSONArray("ingredients");
            for ( int i =0; i< sandwichIngredients.length();i++){

                ingredients.add(sandwichIngredients.getString(i));
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }




}
