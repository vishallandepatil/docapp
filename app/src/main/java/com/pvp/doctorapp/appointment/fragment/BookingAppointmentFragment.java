package com.pvp.doctorapp.appointment.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.databinding.FragmentAboutDoctorBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookingAppointmentFragment extends Fragment {
    FragmentAboutDoctorBinding binding;


    public BookingAppointmentFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_book_appointment, container, false);
        return binding.getRoot();
    }



}
