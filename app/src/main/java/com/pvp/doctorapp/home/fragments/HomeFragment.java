package com.pvp.doctorapp.home.fragments;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.appointment.activities.BookingAppointmentActivity;
import com.pvp.doctorapp.databinding.FragmentHomeBinding;
import com.pvp.doctorapp.doctor.fragments.DoctoreFragment;
import com.pvp.doctorapp.doctor.viewmodel.DoctorViewModel;
import com.pvp.doctorapp.home.activities.NewHomepageActivity;
import com.pvp.doctorapp.home.adapter.HomepageAdapter;
import com.pvp.doctorapp.home.dialogs.Select_Lang_Dialog;
import com.pvp.doctorapp.home.model.HomepageModel;
import com.pvp.doctorapp.hospital.fragments.HospitalFragment;
import com.pvp.doctorapp.hospital.viewmodel.HospitalViewModel;
import com.pvp.doctorapp.notification.adapter.NotificationAdapter;
import com.pvp.doctorapp.notification.model.NotificationsResponce;
import com.pvp.doctorapp.notification.viewmodel.NotificationsViewModel;
import com.pvp.doctorapp.utils.PrefManager;
import com.pvp.doctorapp.utils.Utilities;

import java.util.ArrayList;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;

    PrefManager prefManager;


    public HomeFragment() {

    }


    NotificationsViewModel notificationsViewModel;
    NotificationAdapter appointmentAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        prefManager = new PrefManager(getActivity());
        Locale locale = new Locale(prefManager.getSELECTLANG());
        Configuration config = getActivity().getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config,
                getActivity().getBaseContext().getResources().getDisplayMetrics());
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);



        // language




        binding.cvSlider.setBackgroundDrawable(getResources().getDrawable(R.drawable.slider_background));


        DoctorViewModel doctorViewModel = ViewModelProviders.of(this).get(DoctorViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setDoctorDetails(doctorViewModel);
        doctorViewModel.loadData(getContext());


        HospitalViewModel hospitalViewModel = ViewModelProviders.of(this).get(HospitalViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setHospitalViewModel(hospitalViewModel);
        hospitalViewModel.loadData(getContext());



        binding.tvAboutDr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction transaction = ((AppCompatActivity) getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new DoctoreFragment()).addToBackStack(null).commit();
                ;
                ((NewHomepageActivity) getActivity()).binding.customBottomBar.setVisibility(View.GONE);
                ((NewHomepageActivity) getActivity()).binding.fab.setVisibility(View.GONE);

            }
        });

        binding.tvBookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Utilities.launchActivity(getActivity(), BookingAppointmentActivity.class, false);
            }
        });
        binding.title3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = ((AppCompatActivity) getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HospitalFragment()).addToBackStack(null).commit();
                ;
                ((NewHomepageActivity) getActivity()).binding.customBottomBar.setVisibility(View.GONE);
                ((NewHomepageActivity) getActivity()).binding.fab.setVisibility(View.GONE);

            }
        });
        binding.title2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = ((AppCompatActivity) getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HospitalFragment()).addToBackStack(null).commit();

                ((NewHomepageActivity) getActivity()).binding.customBottomBar.setVisibility(View.GONE);
                ((NewHomepageActivity) getActivity()).binding.fab.setVisibility(View.GONE);

            }
        });
        binding.imgOpenDrawer.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onClick(View v) {
                        DisplayMetrics metrics = getResources().getDisplayMetrics();
                        int width = metrics.widthPixels;
                        int height = metrics.heightPixels;
                        final Select_Lang_Dialog dialog = new Select_Lang_Dialog(getActivity());
                        dialog.show();
                        dialog.getWindow().setLayout((6 * width)/7, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        dialog.setCanceledOnTouchOutside(false);

                    }
                });



        // for notification

        notificationsViewModel = ViewModelProviders.of(this).get(NotificationsViewModel.class);
      /*  binding.setLifecycleOwner(this);
        binding.setNotificationsViewModel(notificationsViewModel);
      */
        notificationsViewModel.loadData(getActivity());
        notificationsViewModel.notificationResponceMutableLiveData.observeForever(new Observer<NotificationsResponce>() {
            @Override
            public void onChanged(NotificationsResponce notificationsResponce) {
                if(notificationsResponce.status) {
                    binding.erornotification.setVisibility(View.GONE);
                    appointmentAdapter = new NotificationAdapter(getActivity(),
                            notificationsResponce.allNotifications);
                    binding.rvJobAlert.setAdapter(appointmentAdapter);
                    binding.rvJobAlert.setLayoutManager(new LinearLayoutManager(getActivity(),
                            LinearLayoutManager.VERTICAL, false));

                    if(notificationsResponce.allNotifications.size()==0){
                        binding.rvJobAlert.setVisibility(View.GONE);
                        binding.erornotification.setVisibility(View.VISIBLE);

                        binding.erornotification.setText(getString(R.string.nonotification));
                    }

                } else {

                }
            }
        });


        return binding.getRoot();
    }



}

