package com.pvp.doctorapp.home.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.pvp.doctorapp.R;
import com.pvp.doctorapp.databinding.FragmentHomeBinding;
import com.pvp.doctorapp.home.adapter.HomepageAdapter;
import com.pvp.doctorapp.home.model.HomepageModel;
import com.pvp.doctorapp.notification.adapter.NotificationAdapter;
import com.pvp.doctorapp.notification.model.NotificationModel;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;

    private int[] myImageListForJobAlert = new int[]{R.drawable.ic_alarm_add_black_24dp, R.drawable.ic_alarm_add_black_24dp,
            R.drawable.ic_alarm_add_black_24dp,
            R.drawable.ic_alarm_add_black_24dp,R.drawable.ic_alarm_add_black_24dp,   R.drawable.ic_alarm_add_black_24dp,R.drawable.ic_alarm_add_black_24dp};
    private String[] myImageNameListForJobAlert = new String[]{"title","title","title","title",
            "title","title","title"};

    ArrayList<HomepageModel> imageModelYouTubeArrayList ;

    HomepageAdapter homepageAdapter;


    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
//
        slider();

        imageModelYouTubeArrayList = arrayJobAlerts();
        homepageAdapter = new HomepageAdapter(getActivity(), imageModelYouTubeArrayList);
        binding.rvJobAlert.setAdapter(homepageAdapter);
        binding.rvJobAlert.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));

        return binding.getRoot();
    }

    public void slider() {
        HashMap<String, Integer> url_maps = new HashMap<String, Integer>();
        url_maps.put("", R.drawable.sample_logo);
        url_maps.put("",  R.drawable.sample_logo);
        url_maps.put("",  R.drawable.sample_logo);


        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            binding.slider.addSlider(textSliderView);
        }
        binding.slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        binding.slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        binding.slider.setCustomAnimation(new DescriptionAnimation());
        binding.slider.setDuration(4000);

    }
    private ArrayList<HomepageModel> arrayJobAlerts(){

        ArrayList<HomepageModel> list = new ArrayList<>();

        for(int i = 0; i < 7; i++) {
            HomepageModel homepageModel = new HomepageModel();
            homepageModel.setName(myImageNameListForJobAlert[i]);
            homepageModel.setImage_drawable(myImageListForJobAlert[i]);
            list.add(homepageModel);
        }

        return list;
    }


}
