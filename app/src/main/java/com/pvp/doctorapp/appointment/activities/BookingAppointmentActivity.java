package com.pvp.doctorapp.appointment.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.appointment.adapter.AppointmentAdapter;
import com.pvp.doctorapp.appointment.model.AppointmentModel;
import com.pvp.doctorapp.databinding.ActivityBookingAppointmentBinding;
import com.pvp.doctorapp.home.adapter.HomepageAdapter;
import com.pvp.doctorapp.home.model.HomepageModel;

import java.util.ArrayList;

public class BookingAppointmentActivity extends AppCompatActivity {

    ActivityBookingAppointmentBinding binding;

    private int[] myImageListForJobAlert = new int[]{R.drawable.ic_today_black_24dp, R.drawable.ic_today_black_24dp,
            R.drawable.ic_today_black_24dp,
            R.drawable.ic_today_black_24dp,R.drawable.ic_today_black_24dp,   R.drawable.ic_today_black_24dp,R.drawable.ic_today_black_24dp};
    private String[] myImageNameListForJobAlert = new String[]{"Slot 09.00 AM to 01.00 PM","Slot 09.00 AM to 01.00 PM",
            "Slot 09.00 AM to 01.00 PM","Slot 09.00 AM to 01.00 PM",
            "Slot 09.00 AM to 01.00 PM","Slot 09.00 AM to 01.00 PM","Slot 09.00 AM to 01.00 PM"};

    ArrayList<AppointmentModel> imageModelYouTubeArrayList ;
    AppointmentAdapter appointmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_appointment);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_booking_appointment);

        imageModelYouTubeArrayList = arrayJobAlerts();
        appointmentAdapter = new AppointmentAdapter(BookingAppointmentActivity.this, imageModelYouTubeArrayList);
        binding.rvJobAlert.setAdapter(appointmentAdapter);
        binding.rvJobAlert.setLayoutManager(new LinearLayoutManager(BookingAppointmentActivity.this,
                LinearLayoutManager.VERTICAL, false));


    }

    private ArrayList<AppointmentModel> arrayJobAlerts(){

        ArrayList<AppointmentModel> list = new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            AppointmentModel appointmentModel = new AppointmentModel();
            appointmentModel.setName(myImageNameListForJobAlert[i]);
            appointmentModel.setImage_drawable(myImageListForJobAlert[i]);
            list.add(appointmentModel);
        }

        return list;
    }

}
