package com.pvp.doctorapp.doctor.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.pvp.doctorapp.R;
import com.pvp.doctorapp.databinding.FragmentAboutDoctorBinding;
import com.pvp.doctorapp.doctor.viewmodel.DoctorViewModel;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class DoctoreFragment extends Fragment {
    FragmentAboutDoctorBinding binding;


    public DoctoreFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_about_doctor, container, false);

//        Locale locale = new Locale("mr");
//        Locale.setDefault(locale);
//        Configuration config = getActivity().getBaseContext().getResources().getConfiguration();
//        config.locale = locale;
//        getActivity().getBaseContext().getResources().updateConfiguration(config,
//                getActivity().getBaseContext().getResources().getDisplayMetrics());


        DoctorViewModel doctorViewModel = ViewModelProviders.of(this).get(DoctorViewModel.class);
        binding.setLifecycleOwner(this);
        binding.setDoctorDetails(doctorViewModel);

        doctorViewModel.loadData(getContext());
        return binding.getRoot();
    }



}
