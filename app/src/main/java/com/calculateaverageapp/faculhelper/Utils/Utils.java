package com.calculateaverageapp.faculhelper.Utils;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;

import com.calculateaverageapp.faculhelper.Domain.Discipline;
import com.calculateaverageapp.faculhelper.Repository.Repository;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

public class Utils {
    private final Repository repository;

    public Utils() {
        repository = Repository.getInstance();
    }

    public void saveData(Context base) {
        ContextWrapper cw = new ContextWrapper(base);
        SharedPreferences sharedPreferences = cw.getSharedPreferences("shared preferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(repository.getDisciplines());

        editor.putString("disciplines", json);
        editor.apply();
    }

    public void loadData(Context base){
        ContextWrapper cw = new ContextWrapper(base);
        SharedPreferences sharedPreferences = cw.getSharedPreferences("shared preferences", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("disciplines", null);
        Type type = new TypeToken<HashMap<String, Discipline>>() {}.getType();
        repository.setDisciplines(gson.fromJson(json, type));

        if (repository.getDisciplines() == null) repository.initializeList();
    }
}
