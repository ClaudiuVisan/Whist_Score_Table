package com.example.whistscoretable;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Converters implements Serializable {

    @TypeConverter // note this annotation
    public String fromPlayersList(ArrayList<Player> playersList) {
        if (playersList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Player>>() {
        }.getType();
        String json = gson.toJson(playersList, type);
        return json;
    }

    @TypeConverter // note this annotation
    public ArrayList<Player> toPlayersList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Player>>() {
        }.getType();
        ArrayList<Player> productCategoriesList = gson.fromJson(optionValuesString, type);
        return productCategoriesList;
    }

}