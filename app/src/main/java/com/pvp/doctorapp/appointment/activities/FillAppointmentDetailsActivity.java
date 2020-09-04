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
    String row_id, time_row_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_appointment_details);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_fill_appointment_details);

        AppointmentViewModel appointmentViewModel = ViewModelProviders.of(this).get(AppointmentViewModel.class);
        binding.setAppointmentViewModel(appointmentViewModel);
        appointmentViewModel.bookingUIVisible.setValue(false);
        binding.setLifecycleOwner(this);


        row_id=getIntent().getStringExtra("row_id");
        time_row_id=getIntent().getStringExtra("time_row_id");

        appointmentViewModel.date.setValue(getIntent().getStringExtra("date"));
        appointmentViewModel.timeSlot.setValue(getIntent().getStringExtra("timeslot"));

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if( binding.etMobileno.getText().toString().length()<10 ) {
                    Toast.makeText(FillAppointmentDetailsActivity.this, "Enter proper mobile number", Toast.LENGTH_SHORT).show();
                }

                else {

                        if(Utilities.emailValidate(binding.etEmail.getText().toString()))
                        {

                            appointmentViewModel.bookAppointment(FillAppointmentDetailsActivity.this,row_id,time_row_id);


                           // binding.tvPatientName.setText("Name: "+binding.etEmail.getText().toString());
                           // binding.tvPatientContact.setText("Contact: "+binding.etMobileno.getText().toString());
                           // binding.tvDate.setText("Date: "+selecteddate);
                          //  binding.tvSlot.setText("Slot :"+selectedtime);
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
