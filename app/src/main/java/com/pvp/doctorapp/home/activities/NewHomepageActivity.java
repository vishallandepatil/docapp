package com.pvp.doctorapp.home.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.pvp.doctorapp.databinding.ActivityNewhomepageBinding;
import com.pvp.doctorapp.home.fragments.HomeFragment;
import com.pvp.doctorapp.R;
import com.pvp.doctorapp.activities.navigation.CustomBottomNavigationView1;


public class NewHomepageActivity extends AppCompatActivity
        {
            Fragment fragment;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

             ActivityNewhomepageBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_newhomepage);
             binding.customBottomBar.inflateMenu(R.menu.bottom_menu);
             loadFragment(new HomeFragment());

                binding.customBottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                        switch (menuItem.getItemId()){

                            case R.id.navigation_home:

                                Toast.makeText(getBaseContext(),"Home",Toast.LENGTH_LONG).show();
                                break;
                            case R.id.navigation_bl:

                                Toast.makeText(getBaseContext(),"2nd",Toast.LENGTH_LONG).show();
                            break;




                        }


                        return true;
                    }
                });
            }





            private void loadFragment(Fragment fragment) {
                // load fragment
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.commit();
            }






        }
