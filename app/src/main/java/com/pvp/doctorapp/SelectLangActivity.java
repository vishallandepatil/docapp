package com.pvp.doctorapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.pvp.doctorapp.home.activities.NewHomepageActivity;
import com.pvp.doctorapp.utils.PrefManager;

import java.util.Locale;

public class SelectLangActivity extends AppCompatActivity implements View.OnClickListener {
    private static Button english, hindi,  marathi;
    private static TextView chooseText;
    private static Locale myLocale;

    //Shared Preferences Variables
    private static final String Locale_Preference = "Locale Preference";
    private static final String Locale_KeyValue = "Saved Locale";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_lang);
        prefManager=new PrefManager(SelectLangActivity.this);
       // setTitle(R.string.lang);
       // prefManager.setSELECTLANG("en");

        initViews();
        setListeners();
      //  loadLocale();
    }


    //Initiate all views
    private void initViews() {
        sharedPreferences = getSharedPreferences(Locale_Preference, Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();


        english = (Button) findViewById(R.id.english);
        hindi = (Button) findViewById(R.id.hindi);
        marathi = (Button) findViewById(R.id.marathi);
    }

    //Set Click Listener
    private void setListeners() {
        english.setOnClickListener(this);
        hindi.setOnClickListener(this);

        marathi.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String lang = "en";//Default Language
        switch (view.getId()) {
            case R.id.english:
                prefManager.setSELECTLANG("en");
                lang = "en";
                Intent i = new Intent(getApplicationContext(), NewHomepageActivity.class);
                startActivity(i);
                break;

            case R.id.marathi:
                prefManager.setSELECTLANG("mr");
                Intent i3 = new Intent(getApplicationContext(), NewHomepageActivity.class);
                startActivity(i3);
                lang = "mr";
                break;
        }


        // changeLocale(lang);//Change Locale on selection basis
    }
/*


    //Change Locale
    public void changeLocale(String lang) {
        if (lang.equalsIgnoreCase(""))
            return;
        myLocale = new Locale(lang);//Set Selected Locale
        saveLocale(lang);//Save the selected locale
        Locale.setDefault(myLocale);//set new locale as default
        Configuration config = new Configuration();//get Configuration
        config.locale = myLocale;//set config locale as selected locale
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());//Update the config
      //  updateTexts();//Update texts according to locale
    }
*/

 /*   //Save locale method in preferences
    public void saveLocale(String lang) {
        editor.putString(Locale_KeyValue, lang);
        editor.commit();
    }

    //Get locale method in preferences
    public void loadLocale() {
        String language = sharedPreferences.getString(Locale_KeyValue, "");
        changeLocale(language);
    }

    //Update text methods
    private void updateTexts() {
        chooseText.setText(R.string.About_Us);
        english.setText(R.string.Logout);
        hindi.setText(R.string.Contact_Us);
        marathi.setText(R.string.Logout);

    }
*/

}
