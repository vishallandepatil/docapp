package com.pvp.doctorapp.appointment.adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.appointment.activities.FillAppointmentDetailsActivity;
import com.pvp.doctorapp.appointment.model.AppointmentModel;
import com.pvp.doctorapp.appointment.model.AvailableDates;
import com.pvp.doctorapp.appointment.model.AvailableTimes;
import com.pvp.doctorapp.utils.PrefManager;
import com.pvp.doctorapp.utils.Utilities;

import java.util.ArrayList;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<AvailableTimes> imageModelArrayList;
    Activity mContext;
    AvailableDates availableDates;
    String date;

    public AppointmentAdapter(Activity ctx, ArrayList<AvailableTimes> imageModelArrayList, String date, AvailableDates availableDates){
        mContext=ctx;

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        this.date = date;
        this.availableDates = availableDates;
    }

    @Override
    public AppointmentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.booking_item, parent, false);
        AppointmentAdapter.MyViewHolder holder = new AppointmentAdapter.MyViewHolder(view);





        return holder;
    }

    @Override
    public void onBindViewHolder(AppointmentAdapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource(R.drawable.ic_today_black_24dp);

        String lang=new PrefManager(mContext).getSELECTLANG();
        String to ="To";
        if(lang!=null && lang.equalsIgnoreCase("mr"))
        {
            lang= " ते ";
        }
        else {
            lang= " To ";
        }

        holder.tv_title.setText(imageModelArrayList.get(position).start_time+" "+lang+" "+imageModelArrayList.get(position).end_time);
        holder.tv_date.setText(date);
        if (position % 2 == 0) {  //  is even
            holder.tv_status.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.notification_skyblue));

        } else {    //  is odd
            holder.tv_status.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.notification_skyblue));
        }

        String finalLang = lang;
        holder.tv_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("time_row_id",imageModelArrayList.get(position).time_row_id);
                bundle.putString("row_id", availableDates.row_id);
                bundle.putString("date", date);

                bundle.putString("timeslot", imageModelArrayList.get(position).start_time+" "+ finalLang +"  "+imageModelArrayList.get(position).end_time);
                Utilities.launchActivity(mContext, FillAppointmentDetailsActivity.class,false, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title, tv_status,tv_date;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_status = (TextView) itemView.findViewById(R.id.tv_status);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }

    }
}
