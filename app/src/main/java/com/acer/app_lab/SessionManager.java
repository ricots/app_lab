package com.acer.app_lab;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by ACER on 2016-02-16.
 */

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;
    public static final String PREF_NAME 	= "TestPref";
    public static final String IS_LOGIN 	= "IsLoggedIn";
    public static final String DefaultUnameValue = "";
    public String UnameValue;

    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Create login session
     */
    public void createLoginSession(String npm){
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(config.KEY_USER, npm);

        editor.commit();
    }

    /**
     * Get Stored session data
     */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(config.KEY_USER, pref.getString(config.KEY_USER, null));

        return user;
    }

    /**
     * Check login method - direct user to login activity if fail to sign in
     */
    public void checkLogin(){
        if(!this.isLoggedIn()){
            Intent i = new Intent(_context, MainActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            _context.startActivity(i);
        }
    }

    /**
     * clear session
     */
    public void logoutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(_context, login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        _context.startActivity(i);
    }


    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }
}
