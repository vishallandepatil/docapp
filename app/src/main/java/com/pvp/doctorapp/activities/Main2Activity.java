package com.pvp.doctorapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.activities.navigation.CustomBottomNavigationView1;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        CustomBottomNavigationView1 customBottomNavigationView1 = findViewById(R.id.customBottomBar);
        customBottomNavigationView1.inflateMenu(R.menu.bottom_menu);
    }
}
