package com.pvp.doctorapp.hospital.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.databinding.FragmentAboutDoctorBinding;
import com.pvp.doctorapp.databinding.FragmentHomeBinding;
import com.pvp.doctorapp.databinding.FragmentsAboutHospitalBinding;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HospitalFragment extends Fragment {
    FragmentsAboutHospitalBinding binding;


    public HospitalFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragments_about_hospital, container, false);
        return binding.getRoot();
    }



}
