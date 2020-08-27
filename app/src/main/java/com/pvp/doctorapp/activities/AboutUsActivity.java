package com.pvp.doctorapp.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.pvp.doctorapp.R;


public class AboutUsActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView back_about;
    RelativeLayout rl_phone, rl_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);

        bindViews();
        btnListeners();
    }

    private void bindViews() {
        back_about = findViewById(R.id.back_about);
        rl_phone = findViewById(R.id.rl_phone);
        rl_address = findViewById(R.id.rl_address);
    }

    private void btnListeners() {
        back_about.setOnClickListener(this);
        rl_phone.setOnClickListener(this);
        rl_address.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_about:
                onBackPressed();
                break;

            case R.id.rl_address:

                String uri = "https://www.google.com/maps/place/Kesari+Wada/@18.5163596,73.8492001,19z/data=!4m12!1m6!3m5!1s0x0:0xf8b4534a688aa0eb!2sKesari+Wada!8m2!3d18.516272!4d73.84948!3m4!1s0x0:0xf8b4534a688aa0eb!8m2!3d18.516272!4d73.84948";
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);

                break;

            case R.id.rl_phone:
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:7276568803"));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    Activity#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for Activity#requestPermissions for more details.
                        return;
                    }
                }
                startActivity(callIntent);

                break;
        }
    }
}
