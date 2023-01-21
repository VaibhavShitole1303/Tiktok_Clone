package com.example.tiktok_clone;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktok_clone.databinding.ReelDgBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VideoHolder>{
    Context context;
    ArrayList<Model> modelArrayList=new ArrayList<>();

    // here we create the constructor of Adapter which having the argument context and arraylist of module
    //which we have created above
    public Adapter(Context context, ArrayList<Model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
        //
    }


    //here we create the VideoHolder class which extends recyclerview.ViewHolder
    // and in this class we initialized our ree_dg view which contain one module data
    public class VideoHolder extends RecyclerView.ViewHolder{
        ReelDgBinding binding;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            binding=ReelDgBinding.bind(itemView);

        }
    }
    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating the view in on createView Holder
        View view = LayoutInflater.from(context).inflate(R.layout.reel_dg,parent,false);
        return new VideoHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        // binding the data
       holder.binding.videoView.setVideoPath(modelArrayList.get(position).getVideoUrl());
       holder.binding.nameOfPerson.setText(modelArrayList.get(position).getName());
       holder.binding.profileImage.setImageResource(modelArrayList.get(position).getProfile());
       //to play the video we have to do this
       holder.binding.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
           @Override
           public void onPrepared(MediaPlayer mp) {
               mp.start();
           }//up to this
       });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }


}
