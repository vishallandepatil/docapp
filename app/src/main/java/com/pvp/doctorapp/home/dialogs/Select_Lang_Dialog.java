package com.pvp.doctorapp.home.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.home.activities.NewHomepageActivity;
import com.pvp.doctorapp.utils.PrefManager;

public class Select_Lang_Dialog extends Dialog implements View.OnClickListener {

    public Activity activity;


    TextView  txt_submit, txt_cancel;

    RadioGroup radiotype;
    RadioButton radioButton;

    ProgressDialog progressDialog;
    PrefManager prefManager;
    ImageView img1;
    RadioButton radioMarathi;
    RadioButton radioEnglish;
    public Select_Lang_Dialog(Activity activity)  {
        super(activity);
        this.activity = activity;

      }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.select_lang_dialog);
        bindView();
        btnlistener();

        String lang=new PrefManager(activity).getSELECTLANG();
        Log.e( "chkLang: ",  lang);
        if(lang!=null && lang.equalsIgnoreCase("mr"))
        {
            radioMarathi.setChecked(true);
        }
        else {
            radioEnglish.setChecked(true);
        }

    }

    @Override
    public void onClick(View v) {

        Log.e("onClick", "Clicked");

        switch (v.getId()) {

            case R.id.txt_submit:


                int selectedID = radiotype.getCheckedRadioButtonId();
                radioButton = findViewById(selectedID);


                if(radioButton.getText().equals("मराठी"))
                {
                     Toast.makeText(activity, "मराठी",Toast.LENGTH_SHORT).show();
                    prefManager.setSELECTLANG("mr");
                    Intent i3 = new Intent(activity, NewHomepageActivity.class);
                    activity.startActivity(i3);
                    activity.finish();
                }
                else  if(radioButton.getText().equals("English")){
                     Toast.makeText(activity, "English",Toast.LENGTH_SHORT).show();
                    prefManager.setSELECTLANG("en");
                    Intent i = new Intent(activity, NewHomepageActivity.class);
                    activity.startActivity(i);
                    activity.finish();

                }

                break;

            case R.id.txt_cancel:
                dismiss();

                break;
              case R.id.img1:
                dismiss();

                break;


        }
    }


    private void btnlistener() {
        txt_submit.setOnClickListener(this);
        txt_cancel.setOnClickListener(this);
        img1.setOnClickListener(this);
    }
    private void bindView() {
        txt_submit=findViewById(R.id.txt_submit);
        txt_cancel=findViewById(R.id.txt_cancel);
        progressDialog=new ProgressDialog(activity);
        prefManager=new PrefManager(activity);
        radiotype = findViewById(R.id.radiotype);
        img1 = findViewById(R.id.img1);
        radioMarathi = findViewById(R.id.radioMarathi);
        radioEnglish = findViewById(R.id.radioEnglish);

    }

}
