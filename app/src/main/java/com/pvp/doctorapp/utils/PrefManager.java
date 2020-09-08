package com.pvp.doctorapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class PrefManager {
    // Shared Preferences
    SharedPreferences pref;
    // Editor for Shared preferences
    Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    public static int PRIVATE_MODE = 0;
    // Shared preferences file name
    public static final String PREF_NAME = "docapp";
    // All Shared Preferences Keys
    private static final String SELECTLANG = "SELECTLANG";
    private static final String USERID = "userid";


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    //
    public void setSELECTLANG(String S) {
        editor.putString(SELECTLANG, S);
        editor.commit();
    }
    public void setDoctore(String S) {
        editor.putString(USERID, S);
        editor.commit();
    }

    public String getSELECTLANG() {
        return pref.getString(SELECTLANG, null);
    }
    public String getDoctore() {
        return pref.getString(USERID, null);
    }




}