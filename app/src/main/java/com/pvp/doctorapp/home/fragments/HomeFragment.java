package com.pvp.doctorapp.home.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.pvp.doctorapp.R;
import com.pvp.doctorapp.appointment.activities.BookingAppointmentActivity;
import com.pvp.doctorapp.databinding.FragmentHomeBinding;
import com.pvp.doctorapp.doctor.fragments.DoctoreFragment;
import com.pvp.doctorapp.doctor.viewmodel.DoctorViewModel;
import com.pvp.doctorapp.home.activities.NewHomepageActivity;
import com.pvp.doctorapp.home.adapter.HomepageAdapter;
import com.pvp.doctorapp.home.api.NotificationApi;
import com.pvp.doctorapp.home.model.HomepageModel;
import com.pvp.doctorapp.home.model.NotificationResult;
import com.pvp.doctorapp.hospital.fragments.HospitalFragment;
import com.pvp.doctorapp.hospital.viewmodel.HospitalViewModel;
import com.pvp.doctorapp.notification.adapter.NotificationAdapter;
import com.pvp.doctorapp.notification.model.NotificationModel;
import com.pvp.doctorapp.retrofit.RetrofitClientInstance;
import com.pvp.doctorapp.utils.PrefManager;
import com.pvp.doctorapp.utils.Utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    ArrayList<HomepageModel> imageModelYouTubeArrayList;
    HomepageAdapter homepageAdapter;
    PrefManager prefManager;
    private int[] myImageListForJobAlert = new int[]{R.drawable.ic_alarm_add_black_24dp, R.drawable.ic_alarm_add_black_24dp,
            R.drawable.ic_alarm_add_black_24dp,
            R.drawable.ic_alarm_add_black_24dp, R.drawable.ic_alarm_add_black_24dp, R.drawable.ic_alarm_add_black_24dp, R.drawable.ic_alarm_add_black_24dp};
    private String[] myImageNameListForJobAlert = new String[]{"Brain checkout", "Purchase Prescription", "Brain checkout", "Purchase Prescription",
            "title", "title", "title"};


    public HomeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        prefManager = new PrefManager(getActivity());


        binding.cvSlider.setBackgroundDrawable(getResources().getDrawable(R.drawable.slider_background));

        imageModelYouTubeArrayList = arrayJobAlerts();
        homepageAdapter = new HomepageAdapter(getActivity(), imageModelYouTubeArrayList);
        binding.rvJobAlert.setAdapter(homepageAdapter);
        binding.rvJobAlert.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));

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
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = ((AppCompatActivity) getActivity()).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, new HospitalFragment()).addToBackStack(null).commit();
                ;
                ((NewHomepageActivity) getActivity()).binding.customBottomBar.setVisibility(View.GONE);
                ((NewHomepageActivity) getActivity()).binding.fab.setVisibility(View.GONE);

            }
        });


        return binding.getRoot();
    }


    private ArrayList<HomepageModel> arrayJobAlerts() {

        ArrayList<HomepageModel> list = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            HomepageModel homepageModel = new HomepageModel();
            homepageModel.setName(myImageNameListForJobAlert[i]);
            homepageModel.setImage_drawable(myImageListForJobAlert[i]);
            list.add(homepageModel);
        }

        return list;
    }


}

