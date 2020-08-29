package com.pvp.doctorapp.home.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.pvp.doctorapp.databinding.ActivityNewhomepageBinding;
import com.pvp.doctorapp.doctor.fragments.DoctoreFragment;
import com.pvp.doctorapp.home.fragments.HomeFragment;
import com.pvp.doctorapp.R;
import com.pvp.doctorapp.hospital.fragments.HospitalFragment;
import com.pvp.doctorapp.notification.fragments.NotificationFragment;

import java.util.List;


public class NewHomepageActivity extends AppCompatActivity
        {
            Fragment fragment;

            ActivityNewhomepageBinding binding;
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

              binding = DataBindingUtil.setContentView(this, R.layout.activity_newhomepage);
             binding.customBottomBar.inflateMenu(R.menu.bottom_menu);
             binding.customBottomBar.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HomeFragment()).commit();;

                binding.customBottomBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                        switch (menuItem.getItemId()){

                            case R.id.navigation_home:
                                transaction.replace(R.id.frame_container, new HomeFragment()).addToBackStack(null).commit();;
                                binding.customBottomBar.setVisibility(View.VISIBLE);
                                binding.fab.setVisibility(View.VISIBLE);
                                break;
                            case R.id.navigation_doctor:
                                transaction.replace(R.id.frame_container, new DoctoreFragment()).addToBackStack(null).commit();;
                                binding.customBottomBar.setVisibility(View.GONE);
                                binding.fab.setVisibility(View.GONE);
                            break;
                            case R.id.navigation_hospital:
                                transaction.replace(R.id.frame_container, new HospitalFragment()).addToBackStack(null).commit();;
                                binding.customBottomBar.setVisibility(View.GONE);
                                binding.fab.setVisibility(View.GONE);
                            break;

                            case R.id.navigation_notificatin:
                                transaction.replace(R.id.frame_container, new NotificationFragment()).addToBackStack(null).commit();;
                                binding.customBottomBar.setVisibility(View.GONE);
                                binding.fab.setVisibility(View.GONE);
                            break;




                        }


                        return true;
                    }
                });
            }



            @SuppressLint("RestrictedApi")
            @Override
            public void onBackPressed() {
                super.onBackPressed();
                    if (getCurrentFragment() instanceof HomeFragment) {

                        binding.customBottomBar.setVisibility(View.VISIBLE);
                        binding.fab.setVisibility(View.VISIBLE);
                        binding.customBottomBar.setSelectedItemId(R.id.navigation_home);
                    }

            }

            private Fragment getCurrentFragment(){
                FragmentManager fragmentManager = getSupportFragmentManager();
                List<Fragment> list = fragmentManager.getFragments();
                //get last one
                Fragment currentFragment = list.get(list.size() - 1);
                return currentFragment;
            }

        }
