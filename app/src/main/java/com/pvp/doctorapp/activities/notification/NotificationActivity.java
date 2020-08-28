package com.pvp.doctorapp.activities.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.pvp.doctorapp.R;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {


    //job alert
    private int[] myImageListForJobAlert = new int[]{R.drawable.ic_pause, R.drawable.ic_pause,
            R.drawable.ic_pause,
            R.drawable.ic_pause,R.drawable.ic_pause,   R.drawable.ic_pause,R.drawable.ic_pause};
    private String[] myImageNameListForJobAlert = new String[]{"title","title","title","title",
            "title","title","title"};

    ArrayList<NotificationModel> imageModelArrayList,  imageModelYouTubeArrayList ;

    NotificationAdapter notificationAdapter;

    RecyclerView rv_job_alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_notification);
        rv_job_alert=findViewById(R.id.rv_job_alert);
//job alerts
        imageModelYouTubeArrayList = arrayJobAlerts();
        notificationAdapter = new NotificationAdapter(NotificationActivity.this, imageModelYouTubeArrayList);
        rv_job_alert.setAdapter(notificationAdapter);
        rv_job_alert.setLayoutManager(new LinearLayoutManager(NotificationActivity.this,
                LinearLayoutManager.VERTICAL, false));



    }

    private ArrayList<NotificationModel> arrayJobAlerts(){

        ArrayList<NotificationModel> list = new ArrayList<>();

        for(int i = 0; i < 7; i++){
            NotificationModel notificationModel = new NotificationModel();
            notificationModel.setName(myImageNameListForJobAlert[i]);
            notificationModel.setImage_drawable(myImageListForJobAlert[i]);
            list.add(notificationModel);
        }

        return list;
    }

}
