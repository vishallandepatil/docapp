package com.pvp.doctorapp.appointment.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.Toast;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.appointment.adapter.AppointmentAdapter;
import com.pvp.doctorapp.appointment.model.AppointmentModel;
import com.pvp.doctorapp.appointment.model.AvailableDates;
import com.pvp.doctorapp.appointment.model.DateResponce;
import com.pvp.doctorapp.appointment.model.TimeResponce;
import com.pvp.doctorapp.appointment.viewmodel.AppointmentViewModel;
import com.pvp.doctorapp.databinding.ActivityBookingAppointmentBinding;
import com.pvp.doctorapp.doctor.viewmodel.DoctorViewModel;
import com.pvp.doctorapp.home.activities.NewHomepageActivity;
import com.pvp.doctorapp.home.adapter.HomepageAdapter;
import com.pvp.doctorapp.home.model.HomepageModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class BookingAppointmentActivity extends AppCompatActivity {

    ActivityBookingAppointmentBinding binding;
    Date lastSelectedDate;

    AppointmentAdapter appointmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_booking_appointment);




        binding = DataBindingUtil.setContentView(this, R.layout.activity_booking_appointment);


        AppointmentViewModel appointmentViewModel = ViewModelProviders.of(this).get(AppointmentViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setAppointmentViewModel(appointmentViewModel);


        appointmentViewModel.loadData(this);

        appointmentViewModel.doctorsResponceMutableLiveData.observeForever(new Observer<DateResponce>() {
            @Override
            public void onChanged(DateResponce dateResponce) {

                if(dateResponce.status){
                    binding.calendarView.setClickable(true);

                }

            }
        });

        binding.calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {


                boolean ispresent =false;
                Calendar calendar = new GregorianCalendar( year, month, dayOfMonth );


                for(AvailableDates availableDates:appointmentViewModel.doctorsResponceMutableLiveData.getValue().availableDates)
                {

                    SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");



                    try {

                        Date date=  calendar.getTime();
                        String dates = simpleDateFormat.format(date);
                        if(availableDates.available_dates.equalsIgnoreCase(dates)){
                            ispresent=true;
                            lastSelectedDate = calendar.getTime();
                            appointmentViewModel.loadDTimes(BookingAppointmentActivity.this,availableDates.row_id);


                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if(!ispresent){
                    if(lastSelectedDate!=null) {
                        binding.calendarView.setDate(lastSelectedDate.getTime());
                    }
                    else {
                        long currentTime = System.currentTimeMillis();
                        binding.calendarView.setDate(currentTime);
                    }
                }
            }
        });
        binding.calendarView.setClickable(false);

        appointmentViewModel.timeResponceMutableLiveData.observeForever(new Observer<TimeResponce>() {
            @Override
            public void onChanged(TimeResponce timeResponce) {
                SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
                String dates = simpleDateFormat.format(lastSelectedDate);
                appointmentAdapter = new AppointmentAdapter(BookingAppointmentActivity.this, timeResponce.availableTimes,dates);
                binding.rvJobAlert.setAdapter(appointmentAdapter);
                binding.rvJobAlert.setLayoutManager(new LinearLayoutManager(BookingAppointmentActivity.this,
                        LinearLayoutManager.VERTICAL, false));
            }
        });


        long currentTime = System.currentTimeMillis();
        long maxTime = currentTime + 1000 * 60 * 60 * 24 * 7;
        binding.calendarView.setMinDate(currentTime);
        binding.calendarView.setMaxDate(maxTime);



    }



    public void changeLocale(String lang) {

        Locale locale = new Locale(lang);
        Configuration config = getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

    }



}
