package com.pvp.doctorapp.activities.appointment;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.activities.notification.NotificationActivity;
import com.pvp.doctorapp.activities.notification.NotificationAdapter;
import com.pvp.doctorapp.activities.notification.NotificationModel;

import java.util.ArrayList;


public class AppointmentBookingActivity extends AppCompatActivity implements View.OnClickListener {


    private int[] myImageListForJobAlert = new int[]{R.drawable.ic_pause, R.drawable.ic_pause,
            R.drawable.ic_pause,
            R.drawable.ic_pause,R.drawable.ic_pause,   R.drawable.ic_pause,R.drawable.ic_pause};
    private String[] myImageNameListForJobAlert = new String[]{"title","title","title","title",
            "title","title","title"};

    ArrayList<AppointmentModel>  imageModelYouTubeArrayList ;

    AppointmentAdapter appointmentAdapter;

    RecyclerView rv_job_alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_appointment_booking);

        rv_job_alert=findViewById(R.id.rv_job_alert);
//job alerts
       /* imageModelYouTubeArrayList = arrayJobAlerts();
        appointmentAdapter = new AppointmentAdapter(AppointmentBookingActivity.this,
                imageModelYouTubeArrayList);
        rv_job_alert.setAdapter(appointmentAdapter);
        rv_job_alert.setLayoutManager(new LinearLayoutManager(AppointmentBookingActivity.this,
                LinearLayoutManager.VERTICAL, false));
*/


    }

    private ArrayList<AppointmentModel> arrayJobAlerts(){

        ArrayList<AppointmentModel> list = new ArrayList<>();

        for(int i = 0; i < 7; i++){
            AppointmentModel notificationModel = new AppointmentModel();
            notificationModel.setName(myImageNameListForJobAlert[i]);
            notificationModel.setImage_drawable(myImageListForJobAlert[i]);
            list.add(notificationModel);
        }

        return list;
    }

    @Override
    public void onClick(View view) {

    }
}
