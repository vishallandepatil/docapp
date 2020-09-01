package com.pvp.doctorapp.home.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.pvp.doctorapp.R;
import com.pvp.doctorapp.home.model.HomepageModel;
import com.pvp.doctorapp.notification.model.NotificationModel;

import java.util.ArrayList;

public class HomepageAdapter extends RecyclerView.Adapter<HomepageAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private ArrayList<HomepageModel> imageModelArrayList;
    Context mContext;

    public HomepageAdapter(Context ctx, ArrayList<HomepageModel> imageModelArrayList){

        mContext=ctx;
        inflater = LayoutInflater.from(ctx);
        this.imageModelArrayList = imageModelArrayList;
    }

    @Override
    public HomepageAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.home_item, parent, false);
        HomepageAdapter.MyViewHolder holder = new HomepageAdapter.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(HomepageAdapter.MyViewHolder holder, int position) {

        holder.iv.setImageResource(imageModelArrayList.get(position).getImage_drawable());
        holder.tv_title.setText(imageModelArrayList.get(position).getName());

        if (position % 2 == 0) {  //  is even
            holder.tv_status.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.notification_skyblue));

        } else {    //  is odd
            holder.tv_status.setBackgroundDrawable(mContext.getResources().getDrawable(R.drawable.notification_orange));
        }

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
