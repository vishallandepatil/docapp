package com.pvp.doctorapp.appointment.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.appointment.viewmodel.AppointmentViewModel;
import com.pvp.doctorapp.databinding.ActivityBookingAppointmentBinding;
import com.pvp.doctorapp.databinding.ActivityFillAppointmentDetailsBinding;
import com.pvp.doctorapp.home.activities.NewHomepageActivity;
import com.pvp.doctorapp.utils.PrefManager;
import com.pvp.doctorapp.utils.Utilities;

import java.util.Locale;

public class FillAppointmentDetailsActivity extends AppCompatActivity {

    ActivityFillAppointmentDetailsBinding binding;
    String row_id, time_row_id;
    PrefManager prefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_appointment_details);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fill_appointment_details);

        prefManager=new PrefManager(FillAppointmentDetailsActivity.this);
        Locale locale = new Locale(prefManager.getSELECTLANG());
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

        AppointmentViewModel appointmentViewModel = ViewModelProviders.of(this).get(AppointmentViewModel.class);
        binding.setAppointmentViewModel(appointmentViewModel);
        appointmentViewModel.bookingUIVisible.setValue(false);
        binding.setLifecycleOwner(this);


        row_id=getIntent().getStringExtra("row_id");
        time_row_id=getIntent().getStringExtra("time_row_id");

        appointmentViewModel.date.postValue(getIntent().getStringExtra("date"));
        appointmentViewModel.timeSlot.postValue(getIntent().getStringExtra("timeslot"));


        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean status =true;
                //if(!Utilities.emailValidate(binding.etEmail.getText().toString()) ) {
                if(binding.etEmail.getText().toString().length()<4 ) {
                    status=false;
                    Toast.makeText(FillAppointmentDetailsActivity.this, "Enter proper name", Toast.LENGTH_SHORT).show();
                }
                else {
                    if( binding.etMobileno.getText().toString().length()>=10) {
                        appointmentViewModel.bookAppointment(FillAppointmentDetailsActivity.this,
                                row_id, time_row_id);
                    }
                    else {
                        Toast.makeText(FillAppointmentDetailsActivity.this, "Enter proper mobile number", Toast.LENGTH_SHORT).show();
                        status=false;

                    }



                }
            }
        });


        binding.backAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.backAbout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });

        binding.btnSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilities.launchActivity(FillAppointmentDetailsActivity.this, NewHomepageActivity.class,true);
            }
        });

    }
}
