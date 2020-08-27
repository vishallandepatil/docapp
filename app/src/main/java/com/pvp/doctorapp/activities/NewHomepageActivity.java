package com.pvp.doctorapp.activities;

import android.Manifest;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.pvp.doctorapp.R;
import com.teammandroid.dairyapplication.fragments.HomeFragment;

import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewHomepageActivity extends AppCompatActivity implements View.OnClickListener
        {
            Fragment fragment;


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_newhomepage);

                // bindView();
                BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
                navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
                loadFragment(new HomeFragment());
                //  requestPermission();

            }

            private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                    = new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {

                        default:
                            break;
                        case R.id.navigation_home:
                            //  toolbar.setTitle("Shop");
                            fragment = new HomeFragment();
                            loadFragment(fragment);
                            return true;

                        case R.id.navigation_bl:
                    /* fragment = new HomeSetupFragment();
                    loadFragment(fragment);*/
                            return true;


                        case R.id.navigation_add:
                            // toolbar.setTitle("Profile");
                  /*  fragment = new FillDetailsFragment();
                    loadFragment(fragment);
                  */
                            return true;

                        // Utility.launchActivity(AdminHomeActivity.this, BluetoothActivity.class,false);


                        case R.id.navigation_list:
                    /*fragment = new DetailsListFragment();
                    loadFragment(fragment);
                    return true;*/
                            return true;

                    }
                    return false;
                }
            };
            private void loadFragment(Fragment fragment) {
                // load fragment
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                //  transaction.addToBackStack(null);
                transaction.commit();
            }


            //  Runtime permission
            private void requestPermission() {
                Dexter.withActivity(this)
                        .withPermissions(
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .withListener(new MultiplePermissionsListener() {
                            @Override
                            public void onPermissionsChecked(MultiplePermissionsReport report) {
                                // check if all permissions are granted
                                if (report.areAllPermissionsGranted()) {
                                    //Toast.makeText(getApplicationContext(), "All permissions are granted!", Toast.LENGTH_SHORT).show();
                                }

                                // check for permanent denial of any permission
                                if (report.isAnyPermissionPermanentlyDenied()) {
                                    // show alert dialog navigating to Settings
                                    // showSettingsDialog();
                                }
                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                                token.continuePermissionRequest();
                            }


                        }).
                        withErrorListener(new PermissionRequestErrorListener() {
                            @Override
                            public void onError(DexterError error) {
                                Toast.makeText(getApplicationContext(), "Error occurred! "+error, Toast.LENGTH_SHORT).show();
                            }
                        })
                        .onSameThread()
                        .check();
            }


            @Override
            public void onClick(View view) {

            }
        }
