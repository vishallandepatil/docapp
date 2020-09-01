package com.pvp.doctorapp.appointment.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.appointment.activities.FillAppointmentDetailsActivity;
import com.pvp.doctorapp.appointment.model.AppointmentModel;
import com.pvp.doctorapp.utils.Utilities;

import java.util.ArrayList;

public class AppointmentAdapter extends RecyclerView.Adapter<AppointmentAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<AppointmentModel> imageModelArrayList;
    Activity mContext;

    public AppointmentAdapter(Activity ctx, ArrayList<AppointmentModel> imageModelArrayList){
        mContext=ctx;

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
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
                Utilities.launchActivity(mContext, FillAppointmentDetailsActivity.class,false);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(AppointmentAdapter.MyViewHolder holder, int position) {

        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.tv_title.setText(imageModelArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title, tv_status;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_status = (TextView) itemView.findViewById(R.id.tv_status);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }

    }
}
