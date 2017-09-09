package com.example.besant.besant;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sai Naveen Kumar on 9/5/2017.
 */

public class Sharedpreference {
    public static final String PREFS_NAME = "com.example.besant.besant";
    public static final String PREFS_KEY = "Besant";

    public Sharedpreference() {
        super();
    }

    public void save(Context context, String text) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences("com.example.besant.besant", Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        editor.putString("Besant", text); //3

        editor.commit(); //4
    }

    public String getValue(Context context) {
        SharedPreferences settings;
        String text;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences("com.example.besant.besant", Context.MODE_PRIVATE);
        text = settings.getString("Besant", null);
        return text;
    }

    public void clearSharedPreference(Context context) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        //settings = PreferenceManager.getDefaultSharedPreferences(context);
        settings = context.getSharedPreferences("com.example.besant.besant", Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.clear();
        editor.commit();
    }

    public void removeValue(Context context) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences("com.example.besant.besant", Context.MODE_PRIVATE);
        editor = settings.edit();

        editor.remove("Besant");
        editor.commit();
    }
}

