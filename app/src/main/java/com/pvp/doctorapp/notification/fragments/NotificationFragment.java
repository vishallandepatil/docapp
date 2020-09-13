package com.pvp.doctorapp.notification.fragments;

import android.app.Notification;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.appointment.activities.BookingAppointmentActivity;
import com.pvp.doctorapp.appointment.adapter.AppointmentAdapter;
import com.pvp.doctorapp.appointment.model.TimeResponce;
import com.pvp.doctorapp.appointment.viewmodel.AppointmentViewModel;
import com.pvp.doctorapp.databinding.FragmentAboutDoctorBinding;
import com.pvp.doctorapp.databinding.FragmentsNotificationBinding;
import com.pvp.doctorapp.home.activities.NewHomepageActivity;
import com.pvp.doctorapp.notification.adapter.NotificationAdapter;
import com.pvp.doctorapp.notification.model.NotificationModel;
import com.pvp.doctorapp.notification.model.NotificationsResponce;
import com.pvp.doctorapp.notification.viewmodel.NotificationsViewModel;
import com.pvp.doctorapp.utils.PrefManager;
import com.pvp.doctorapp.utils.Utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {
    FragmentsNotificationBinding binding;




    public NotificationFragment() {
    }
    PrefManager prefManager;

    NotificationsViewModel notificationsViewModel;
    NotificationAdapter appointmentAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        prefManager=new PrefManager(getActivity());
        Locale locale = new Locale(prefManager.getSELECTLANG());
        Configuration config = getActivity().getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config,
                getActivity().getBaseContext().getResources().getDisplayMetrics());
        binding = DataBindingUtil.inflate(inflater, R.layout.fragments_notification, container, false);


        // language


        notificationsViewModel = ViewModelProviders.of(this).get(NotificationsViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setNotificationsViewModel(notificationsViewModel);

        notificationsViewModel.loadData(getActivity());


        notificationsViewModel.notificationResponceMutableLiveData.observeForever(new Observer<NotificationsResponce>() {
            @Override
            public void onChanged(NotificationsResponce notificationsResponce) {
                if(notificationsResponce.status) {

                    appointmentAdapter = new NotificationAdapter(getActivity(),
                            notificationsResponce.allNotifications);
                    binding.rvJobAlert.setAdapter(appointmentAdapter);
                    binding.rvJobAlert.setLayoutManager(new LinearLayoutManager(getActivity(),
                            LinearLayoutManager.VERTICAL, false));
                    if(notificationsResponce.allNotifications.size()==0){
                        binding.rvJobAlert.setVisibility(View.GONE);
                        binding.data.setVisibility(View.GONE);
                        binding.error.setVisibility(View.VISIBLE);

                        binding.errormessge.setText(getString(R.string.nonotification));
                    }





                } else {
                    binding.rvJobAlert.setVisibility(View.GONE);
                    binding.data.setVisibility(View.GONE);
                    binding.error.setVisibility(View.VISIBLE);

                    binding.errormessge.setText(notificationsResponce.message);
                }
            }
        });




        binding.backAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });




        return binding.getRoot();
    }




}
