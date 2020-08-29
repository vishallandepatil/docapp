package com.pvp.doctorapp.activities.notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.pvp.doctorapp.R;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<NotificationModel> imageModelArrayList;

    public NotificationAdapter(Context ctx, ArrayList<NotificationModel> imageModelArrayList){

        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public NotificationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item, parent, false);
        NotificationAdapter.MyViewHolder holder = new NotificationAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.MyViewHolder holder, int position) {

        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.tv_title.setText(imageModelArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title, tv_quiz, tv_exam;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_exam = (TextView) itemView.findViewById(R.id.tv_exam);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }

    }
}