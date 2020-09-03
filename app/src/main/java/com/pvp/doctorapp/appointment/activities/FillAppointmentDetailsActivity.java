package com.pvp.doctorapp.appointment.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.appointment.viewmodel.AppointmentViewModel;
import com.pvp.doctorapp.databinding.ActivityBookingAppointmentBinding;
import com.pvp.doctorapp.databinding.ActivityFillAppointmentDetailsBinding;
import com.pvp.doctorapp.home.activities.NewHomepageActivity;
import com.pvp.doctorapp.utils.Utilities;

public class FillAppointmentDetailsActivity extends AppCompatActivity {

    ActivityFillAppointmentDetailsBinding binding;
    String selecteddate, selectedtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_appointment_details);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fill_appointment_details);

        AppointmentViewModel appointmentViewModel = ViewModelProviders.of(this).get(AppointmentViewModel.class);

        selecteddate=getIntent().getStringExtra("selecteddate");
        selectedtime=getIntent().getStringExtra("selectedtime");

        Log.e( "onCreate: ", selecteddate+selectedtime);
        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( binding.etMobileno.getText().toString().length()<10 ) {
                    Toast.makeText(FillAppointmentDetailsActivity.this, "Enter proper mobile number", Toast.LENGTH_SHORT).show();
                }

                else {

                        if(Utilities.emailValidate(binding.etEmail.getText().toString()))
                        {

                            appointmentViewModel.bookAppointment(FillAppointmentDetailsActivity.this,
                                    1,selecteddate,selectedtime,binding.etEmail.getText().toString(),
                                    binding.etMobileno.getText().toString());

                            binding.layout1.setVisibility(View.GONE);
                            binding.layout2.setVisibility(View.VISIBLE);
                            binding.tvPatientName.setText("Name: "+binding.etEmail.getText().toString());
                            binding.tvPatientContact.setText("Contact: "+binding.etMobileno.getText().toString());
                            binding.tvDate.setText("Date: "+selecteddate);
                            binding.tvSlot.setText("Slot :"+selectedtime);
                        }

                        else {
                            Toast.makeText(FillAppointmentDetailsActivity.this, "Enter proper email id", Toast.LENGTH_SHORT).show();
                        }

                }
            }
        });


        binding.backAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilities.launchActivity(FillAppointmentDetailsActivity.this, BookingAppointmentActivity.class,true);
            }
        });

        binding.backAbout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilities.launchActivity(FillAppointmentDetailsActivity.this, BookingAppointmentActivity.class,true);
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
