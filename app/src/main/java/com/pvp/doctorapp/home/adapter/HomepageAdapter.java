package com.pvp.doctorapp.home.adapter;

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

    public HomepageAdapter(Context ctx, ArrayList<HomepageModel> imageModelArrayList){

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
    }

    @Override
    public int getItemCount() {
        return imageModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title;
        ImageView iv;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }

    }
}
