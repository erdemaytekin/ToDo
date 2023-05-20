package com.example.noteapp;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSessionManager {
    private static final String userID = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public UserSessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("USER_ID", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveUserId(int userId) {
        editor.putInt("USER_ID", userId);
        editor.commit();
    }


    public int getUserId() {
        return sharedPreferences.getInt("USER_ID", -1); // -1: Varsayılan değer, kullanıcı ID'si kaydedilmemişse
    }


    public void logout() {
        editor.remove("USER_ID");
        editor.commit();
    }

}
