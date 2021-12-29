package com.example.burgermunch.Helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.example.burgermunch.Domain.OrderDetails;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;


public class TinyDB {

    private SharedPreferences preferences;

    public TinyDB(Context appContext) {
        preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    public ArrayList<String> getListString(String key) {
        return new ArrayList<String>(Arrays.asList(TextUtils.split(preferences.getString(key, ""), "‚‗‚")));
    }

    public ArrayList<OrderDetails> getListObject(String key){
        Gson gson = new Gson();

        ArrayList<String> objStrings = getListString(key);
        ArrayList<OrderDetails> playerList =  new ArrayList<OrderDetails>();

        for(String jObjString : objStrings){
            OrderDetails player  = gson.fromJson(jObjString,  OrderDetails.class);
            playerList.add(player);
        }
        return playerList;
    }

    public void putListString(String key, ArrayList<String> stringList) {
        checkForNullKey(key);
        String[] myStringList = stringList.toArray(new String[stringList.size()]);
        preferences.edit().putString(key, TextUtils.join("‚‗‚", myStringList)).apply();
    }

    public void putListObject(String key, ArrayList<OrderDetails> playerList){
        checkForNullKey(key);
        Gson gson = new Gson();
        ArrayList<String> objStrings = new ArrayList<String>();
        for(OrderDetails player: playerList){
            objStrings.add(gson.toJson(player));
        }
        putListString(key, objStrings);
    }

    private void checkForNullKey(String key){
        if (key == null){
            throw new NullPointerException();
        }
    }
}