package com.pvp.doctorapp.hospital.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.appointment.activities.BookingAppointmentActivity;
import com.pvp.doctorapp.databinding.FragmentAboutDoctorBinding;
import com.pvp.doctorapp.databinding.FragmentHomeBinding;
import com.pvp.doctorapp.databinding.FragmentsAboutHospitalBinding;
import com.pvp.doctorapp.doctor.viewmodel.DoctorViewModel;
import com.pvp.doctorapp.home.activities.NewHomepageActivity;
import com.pvp.doctorapp.hospital.viewmodel.HospitalViewModel;
import com.pvp.doctorapp.utils.PrefManager;
import com.pvp.doctorapp.utils.Utilities;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalFragment extends Fragment {
    FragmentsAboutHospitalBinding binding;


    PrefManager prefManager;
    public HospitalFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragments_about_hospital, container, false);
        prefManager =new PrefManager(getActivity());
        // language
        Locale locale = new Locale(prefManager.getSELECTLANG());
        Configuration config = getActivity().getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config,
                getActivity().getBaseContext().getResources().getDisplayMetrics());



        HospitalViewModel hospitalViewModel = ViewModelProviders.of(this).get(HospitalViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setHospitalViewModel(hospitalViewModel);

        hospitalViewModel.loadData(getContext());

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utilities.launchActivity(getActivity(), BookingAppointmentActivity.class,false);
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
