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
import com.pvp.doctorapp.appointment.model.AvailableTimes;
import com.pvp.doctorapp.utils.Utilities;

import java.util.ArrayList;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<AvailableTimes> imageModelArrayList;
    Activity mContext;
    String date;

    public AppointmentAdapter(Activity ctx, ArrayList<AvailableTimes> imageModelArrayList,String date){
        mContext=ctx;

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        this.date = date;
    }

    @Override
    public AppointmentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.booking_item, parent, false);
        AppointmentAdapter.MyViewHolder holder = new AppointmentAdapter.MyViewHolder(view);

        if (position % 2 == 0) {  //  is even
            holder.tv_status.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.notification_orange));

        } else {    //  is odd
            holder.tv_status.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.notification_orange));
        }


        holder.tv_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle=new Bundle();
                bundle.putString("selectedtime",imageModelArrayList.get(position).start_time+" to "+ imageModelArrayList.get(position).end_time);
                bundle.putString("selecteddate", date);
                Utilities.launchActivity(mContext, FillAppointmentDetailsActivity.class,false, bundle);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(AppointmentAdapter.MyViewHolder holder, int position) {
        holder.iv.setImageResource(R.drawable.ic_today_black_24dp);
        holder.tv_title.setText(imageModelArrayList.get(position).start_time+" to "+imageModelArrayList.get(position).end_time);
        holder.tv_date.setText(date);
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
