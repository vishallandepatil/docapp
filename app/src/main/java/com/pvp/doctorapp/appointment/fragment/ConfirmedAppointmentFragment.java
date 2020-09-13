package com.pvp.doctorapp.appointment.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.databinding.FragmentAboutDoctorBinding;
import com.pvp.doctorapp.utils.PrefManager;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConfirmedAppointmentFragment extends Fragment {
    FragmentAboutDoctorBinding binding;


    public ConfirmedAppointmentFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        PrefManager prefManager =new PrefManager(getActivity());
        // language
        Locale locale = new Locale(prefManager.getSELECTLANG());
        Configuration config = getActivity().getBaseContext().getResources().getConfiguration();
        config.locale = locale;
        getActivity().getBaseContext().getResources().updateConfiguration(config,
                getActivity().getBaseContext().getResources().getDisplayMetrics());
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_confirmed_appointment, container, false);
        return binding.getRoot();
    }



}
