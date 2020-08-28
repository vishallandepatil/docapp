package com.pvp.doctorapp.activities.home;

import android.Manifest;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.pvp.doctorapp.R;
import com.pvp.doctorapp.activities.navigation.CustomBottomNavigationView1;
import com.pvp.doctorapp.activities.doctor.AboutDocorActivity;
import com.pvp.doctorapp.fragments.HomeFragment;
import com.pvp.doctorapp.utils.Utilities;

import java.util.List;


public class NewHomepageActivity extends AppCompatActivity implements View.OnClickListener
        {
            Fragment fragment;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_newhomepage);
                // bindView();
              /*  BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
                navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
                loadFragment(new HomeFragment());*/
                //  requestPermission();
                CustomBottomNavigationView1 customBottomNavigationView1 = findViewById(R.id.customBottomBar);
                customBottomNavigationView1.inflateMenu(R.menu.bottom_menu);
               loadFragment(new HomeFragment());
            }



            private void loadFragment(Fragment fragment) {
                // load fragment
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                //  transaction.addToBackStack(null);
                transaction.commit();
            }

            @Override
            public void onClick(View view) {

            }

            private CustomBottomNavigationView1.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                    = new CustomBottomNavigationView1.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {

                        case R.id.navigation_home:
                            fragment = new HomeFragment();
                            loadFragment(fragment);
                            return true;

                        case R.id.navigation_bl:
                            Toast.makeText(NewHomepageActivity.this, "testing", Toast.LENGTH_SHORT).show();
                            Utilities.launchActivity(NewHomepageActivity.this,
                                    AboutDocorActivity.class,false);
                    /* fragment = new HomeSetupFragment();
                    loadFragment(fragment);*/
                            return true;


                        case R.id.navigation_add:

                            return true;
                        case R.id.navigation_list:

                            return true;

                    }
                    return false;
                }
            };


        }
