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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.home.activities.NewHomepageActivity;
import com.pvp.doctorapp.utils.PrefManager;

public class Select_Lang_Dialog extends Dialog implements View.OnClickListener {

    public Activity activity;


    static Button btn_start_exam;

    RadioGroup radiotype;
    RadioButton radioButton;

    ProgressDialog progressDialog;
    PrefManager prefManager;
    public Select_Lang_Dialog() {
        super(null);
    }
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


    }



    @Override
    public void onClick(View v) {

        Log.e("onClick", "Clicked");

        switch (v.getId()) {

            case R.id.btn_start_exam:


                int selectedID = radiotype.getCheckedRadioButtonId();
                radioButton = findViewById(selectedID);


                if(radioButton.getText().equals("Marathi"))
                {
                     Toast.makeText(activity, "Marathi",Toast.LENGTH_SHORT).show();
                    prefManager.setSELECTLANG("mr");
                    Intent i3 = new Intent(activity, NewHomepageActivity.class);
                    activity.startActivity(i3);
                }
                else  if(radioButton.getText().equals("English")){
                     Toast.makeText(activity, "English",Toast.LENGTH_SHORT).show();
                    prefManager.setSELECTLANG("en");
                    Intent i = new Intent(activity, NewHomepageActivity.class);
                    activity.startActivity(i);

                }

                break;


        }
    }


    private void btnlistener() {
        btn_start_exam.setOnClickListener(this);
    }
    private void bindView() {
        btn_start_exam=findViewById(R.id.btn_start_exam);
        progressDialog=new ProgressDialog(activity);
        prefManager=new PrefManager(activity);
        radiotype = findViewById(R.id.radiotype);

    }

}
