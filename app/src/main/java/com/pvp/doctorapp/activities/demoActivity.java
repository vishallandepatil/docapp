package com.pvp.doctorapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.pvp.doctorapp.R;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class demoActivity extends AppCompatActivity implements View.OnClickListener,
        BaseSliderView.OnSliderClickListener, ViewPagerEx.OnPageChangeListener {


    Activity activity;
    private ImageView imgOpenDrawer;
    /**
     * Doctor App
     */
    private TextView txtTitleBar;
    private ImageView imgWhatsapp;
    private ImageView imgCall;
    private RelativeLayout originalToolbar;
    private SliderLayout slider;
    private PagerIndicator customIndicator;
    private LinearLayout sliderlayout;
    private CardView cvSlider;
    private CardView cvAttendance;
    private CardView cvViewLeave;
    private CardView cvProfile;
    private CardView cvContact;
    private CardView layoutt1;
    private CircleImageView ibTwitter;
    private CircleImageView ibFacebook;
    private CircleImageView ibInstagram;
    private CircleImageView ibWhatsapp;
    private CircleImageView ibLinkedin;
    private CircleImageView ibTelegram;
    private LinearLayout llSocialMedia;
    private ScrollView ScrollView011;
    private RelativeLayout rlSlider;
    private RelativeLayout rlHeaderprofile;
    private ImageView ivFeed;
    /**
     * Home
     */
    private TextView txtHome;
    private RelativeLayout rlHome;
    private ImageView ivProfile;
    /**
     * Hospital
     */
    private TextView tvAboutHospital;
    private RelativeLayout rlProfile;
    private ImageView ivPayment;
    /**
     * Doctor
     */
    private TextView tvPayment;
    private RelativeLayout rlPaymentHist;
    private ImageView ivTodaysCount;
    /**
     * Appointment
     */
    private TextView tvTodaysCount;
    private RelativeLayout rlEnrolledstudent;
    private ImageView ivDailyServiceRequest;
    /**
     * Demo Lectures
     */
    private TextView tvDailyServiceRequest;
    private RelativeLayout rlDemoLecture;
    /**
     * Rate Us
     */
    private TextView txtRateus;
    /**
     * Contact (Suggestion)
     */
    private TextView txtContact;
    /**
     * About Us
     */
    private TextView txtAboutus;
    /**
     * Feedback (FAQs)
     */
    private TextView txtFeedback;
    /**
     * Share App
     */
    private TextView tvShareApp;
    /**
     * Sign Out
     */
    private TextView txtLogout;
    /**
     * Powered by Mandroid
     */
    private TextView tvPoweredBy;
    private ScrollView ScrllDrawer;
    private DrawerLayout drlOpener;
    private RelativeLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        initView();
        activity = demoActivity.this;
        slider();
    }
    public void slider() {
        HashMap<String, Integer> url_maps = new HashMap<String, Integer>();
        url_maps.put("The pick staff is properly trained, well mannered,", R.drawable.sample_logo);
        url_maps.put("We use advance-accurate digital .",  R.drawable.sample_logo);
        url_maps.put("We are an ethical company operating ..",  R.drawable.sample_logo);


        for (String name : url_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(demoActivity.this);
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(url_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .setOnSliderClickListener(this);

            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            slider.addSlider(textSliderView);
        }
        slider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        slider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        slider.setCustomAnimation(new DescriptionAnimation());
        slider.setDuration(4000);
        slider.addOnPageChangeListener(this);

    }



    @Override
    public void onClick(View view) {

    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void initView() {
        imgOpenDrawer = (ImageView) findViewById(R.id.img_openDrawer);
        imgOpenDrawer.setOnClickListener(this);
        txtTitleBar = (TextView) findViewById(R.id.txtTitleBar);
        txtTitleBar.setOnClickListener(this);
        imgWhatsapp = (ImageView) findViewById(R.id.img_whatsapp);
        imgWhatsapp.setOnClickListener(this);
        imgCall = (ImageView) findViewById(R.id.img_call);
        imgCall.setOnClickListener(this);
        originalToolbar = (RelativeLayout) findViewById(R.id.originalToolbar);
        originalToolbar.setOnClickListener(this);
        slider = (SliderLayout) findViewById(R.id.slider);
        slider.setOnClickListener(this);
        customIndicator = (PagerIndicator) findViewById(R.id.custom_indicator);
        customIndicator.setOnClickListener(this);
        sliderlayout = (LinearLayout) findViewById(R.id.sliderlayout);
        sliderlayout.setOnClickListener(this);
        cvSlider = (CardView) findViewById(R.id.cv_slider);
        cvSlider.setOnClickListener(this);
        cvAttendance = (CardView) findViewById(R.id.cv_attendance);
        cvAttendance.setOnClickListener(this);
        cvViewLeave = (CardView) findViewById(R.id.cv_ViewLeave);
        cvViewLeave.setOnClickListener(this);
        cvProfile = (CardView) findViewById(R.id.cv_profile);
        cvProfile.setOnClickListener(this);
        cvContact = (CardView) findViewById(R.id.cv_contact);
        cvContact.setOnClickListener(this);
        layoutt1 = (CardView) findViewById(R.id.layoutt1);
        layoutt1.setOnClickListener(this);
        ibTwitter = (CircleImageView) findViewById(R.id.ib_twitter);
        ibTwitter.setOnClickListener(this);
        ibFacebook = (CircleImageView) findViewById(R.id.ib_facebook);
        ibFacebook.setOnClickListener(this);
        ibInstagram = (CircleImageView) findViewById(R.id.ib_instagram);
        ibInstagram.setOnClickListener(this);
        ibWhatsapp = (CircleImageView) findViewById(R.id.ib_whatsapp);
        ibWhatsapp.setOnClickListener(this);
        ibLinkedin = (CircleImageView) findViewById(R.id.ib_linkedin);
        ibLinkedin.setOnClickListener(this);
        ibTelegram = (CircleImageView) findViewById(R.id.ib_telegram);
        ibTelegram.setOnClickListener(this);
        llSocialMedia = (LinearLayout) findViewById(R.id.ll_socialMedia);
        llSocialMedia.setOnClickListener(this);
        ScrollView011 = (ScrollView) findViewById(R.id.ScrollView011);
        ScrollView011.setOnClickListener(this);
        rlSlider = (RelativeLayout) findViewById(R.id.rl_slider);
        rlSlider.setOnClickListener(this);
        rlHeaderprofile = (RelativeLayout) findViewById(R.id.rl_headerprofile);
        rlHeaderprofile.setOnClickListener(this);
        ivFeed = (ImageView) findViewById(R.id.iv_feed);
        ivFeed.setOnClickListener(this);
        txtHome = (TextView) findViewById(R.id.txt_home);
        txtHome.setOnClickListener(this);
        rlHome = (RelativeLayout) findViewById(R.id.rl_home);
        rlHome.setOnClickListener(this);
        ivProfile = (ImageView) findViewById(R.id.iv_profile);
        ivProfile.setOnClickListener(this);
        tvAboutHospital = (TextView) findViewById(R.id.tv_about_hospital);
        tvAboutHospital.setOnClickListener(this);
        rlProfile = (RelativeLayout) findViewById(R.id.rl_profile);
        rlProfile.setOnClickListener(this);
        ivPayment = (ImageView) findViewById(R.id.iv_payment);
        ivPayment.setOnClickListener(this);
        tvPayment = (TextView) findViewById(R.id.tv_payment);
        tvPayment.setOnClickListener(this);
        rlPaymentHist = (RelativeLayout) findViewById(R.id.rl_paymentHist);
        rlPaymentHist.setOnClickListener(this);
        ivTodaysCount = (ImageView) findViewById(R.id.iv_todays_count);
        ivTodaysCount.setOnClickListener(this);
        tvTodaysCount = (TextView) findViewById(R.id.tv_todays_count);
        tvTodaysCount.setOnClickListener(this);
        rlEnrolledstudent = (RelativeLayout) findViewById(R.id.rl_enrolledstudent);
        rlEnrolledstudent.setOnClickListener(this);
        ivDailyServiceRequest = (ImageView) findViewById(R.id.iv_daily_service_request);
        ivDailyServiceRequest.setOnClickListener(this);
        tvDailyServiceRequest = (TextView) findViewById(R.id.tv_daily_service_request);
        tvDailyServiceRequest.setOnClickListener(this);
        rlDemoLecture = (RelativeLayout) findViewById(R.id.rl_demo_lecture);
        rlDemoLecture.setOnClickListener(this);
        txtRateus = (TextView) findViewById(R.id.txt_rateus);
        txtRateus.setOnClickListener(this);
        txtContact = (TextView) findViewById(R.id.txt_contact);
        txtContact.setOnClickListener(this);
        txtAboutus = (TextView) findViewById(R.id.txt_aboutus);
        txtAboutus.setOnClickListener(this);
        txtFeedback = (TextView) findViewById(R.id.txt_feedback);
        txtFeedback.setOnClickListener(this);
        tvShareApp = (TextView) findViewById(R.id.tv_share_app);
        tvShareApp.setOnClickListener(this);
        txtLogout = (TextView) findViewById(R.id.txt_logout);
        txtLogout.setOnClickListener(this);
        tvPoweredBy = (TextView) findViewById(R.id.tv_poweredBy);
        tvPoweredBy.setOnClickListener(this);
        ScrllDrawer = (ScrollView) findViewById(R.id.Scrll_Drawer);
        ScrllDrawer.setOnClickListener(this);
        drlOpener = (DrawerLayout) findViewById(R.id.drl_Opener);
        drlOpener.setOnClickListener(this);
        swipeContainer = (RelativeLayout) findViewById(R.id.swipe_container);
        swipeContainer.setOnClickListener(this);
    }
}