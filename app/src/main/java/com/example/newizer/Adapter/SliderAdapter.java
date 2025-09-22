package com.example.newizer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.newizer.ModelClass.SliderModel;
import com.example.newizer.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.ViewHolder> {


    public SliderAdapter(List<SliderModel> sliderModels) {
        this.sliderModelsList = sliderModels;
    }

    List<SliderModel> sliderModelsList;



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        int sliderID=sliderModelsList.get(position).getSliderId();
        String SliderIamge=sliderModelsList.get(position).getImageURL();
        viewHolder.setData(sliderID,SliderIamge);
    }

    @Override
    public int getCount() {
        return sliderModelsList.size();
    }
    public  class ViewHolder extends SliderViewAdapter.ViewHolder
    {
            ImageView silderImage;
        public ViewHolder(View itemView) {
            super(itemView);
            silderImage = itemView.findViewById(R.id.sliderimageView);
        }

            public   void setData (int id,String imageURL)
            {
            Glide
                    .with(itemView.getContext())
                    .load(imageURL)
                    .centerCrop()
                    .placeholder(R.drawable.logo)
                    .into(silderImage);
            }
        }

    }


