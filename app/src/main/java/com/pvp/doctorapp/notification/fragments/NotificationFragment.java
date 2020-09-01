package com.pvp.doctorapp.notification.fragments;

import android.app.Notification;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.databinding.FragmentAboutDoctorBinding;
import com.pvp.doctorapp.databinding.FragmentsNotificationBinding;
import com.pvp.doctorapp.notification.adapter.NotificationAdapter;
import com.pvp.doctorapp.notification.model.NotificationModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {
    FragmentsNotificationBinding binding;

    private int[] myImageListForJobAlert = new int[]{R.drawable.ic_alarm_add_black_24dp, R.drawable.ic_alarm_add_black_24dp,
            R.drawable.ic_alarm_add_black_24dp,
            R.drawable.ic_alarm_add_black_24dp,R.drawable.ic_alarm_add_black_24dp,   R.drawable.ic_alarm_add_black_24dp,R.drawable.ic_alarm_add_black_24dp};
    private String[] myImageNameListForJobAlert = new String[]{"Brain checkout","Purchase Prescription","Brain checkout","Purchase Prescription",
            "title","title","title"};

    ArrayList<NotificationModel>   imageModelYouTubeArrayList ;

    NotificationAdapter notificationAdapter;


    public NotificationFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragments_notification, container, false);

        imageModelYouTubeArrayList = arrayJobAlerts();
        notificationAdapter = new NotificationAdapter(getActivity(), imageModelYouTubeArrayList);
        binding.rvJobAlert.setAdapter(notificationAdapter);
        binding.rvJobAlert.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));


        return binding.getRoot();
    }

    private ArrayList<NotificationModel> arrayJobAlerts(){

        ArrayList<NotificationModel> list = new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            NotificationModel notificationModel = new NotificationModel();
            notificationModel.setName(myImageNameListForJobAlert[i]);
            notificationModel.setImage_drawable(myImageListForJobAlert[i]);
            list.add(notificationModel);
        }

        return list;
    }


}
