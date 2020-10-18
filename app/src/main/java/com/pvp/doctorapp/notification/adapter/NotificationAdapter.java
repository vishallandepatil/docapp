package com.pvp.doctorapp.notification.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.pvp.doctorapp.R;
import com.pvp.doctorapp.appointment.model.AvailableDates;
import com.pvp.doctorapp.appointment.model.AvailableTimes;
import com.pvp.doctorapp.notification.model.AllNotifications;
import com.pvp.doctorapp.notification.model.NotificationModel;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<AllNotifications> imageModelArrayList;
    Context mContext;
    int max;


    public NotificationAdapter(Context ctx, ArrayList<AllNotifications> imageModelArrayList,int max){
        mContext=ctx;
        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        this.max=max;
    }

    public NotificationAdapter(Activity ctx, ArrayList<AllNotifications> imageModelArrayList,int max){
        mContext=ctx;

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
        this.max=max;




    }

    @Override
    public NotificationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item, parent, false);
        NotificationAdapter.MyViewHolder holder = new NotificationAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.MyViewHolder holder, int position) {

       // holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.tv_title.setText(imageModelArrayList.get(position).notification_title);
        holder.tv_details.setText(imageModelArrayList.get(position).notification_message);
        holder.tv_date.setText(imageModelArrayList.get(position).created_on);
        holder.tv_status.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.notification_skyblue));
        holder.tv_status.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {

        if(max==0 ){
            return imageModelArrayList.size();
        } else {

        if(imageModelArrayList.size()<max) {
            return imageModelArrayList.size();
        } else {

            return max;


        }
        }

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title, tv_status, tv_details,tv_date;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_status = (TextView) itemView.findViewById(R.id.tv_status);
            tv_details = (TextView) itemView.findViewById(R.id.tv_details);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }

    }
}
