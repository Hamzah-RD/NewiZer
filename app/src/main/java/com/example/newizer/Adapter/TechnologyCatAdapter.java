package com.example.newizer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newizer.ModelClass.TechnolgyCategoryModel;
import com.example.newizer.R;

import java.util.List;

public class TechnologyCatAdapter extends RecyclerView.Adapter<TechnologyCatAdapter.ViewHolder> {

    List<TechnolgyCategoryModel> technolgyCategoryModelList;

    public TechnologyCatAdapter(List<TechnolgyCategoryModel> technolgyCategoryModelList) {
        this.technolgyCategoryModelList = technolgyCategoryModelList;
    }

    @NonNull
    @Override
    public TechnologyCatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.technology_category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TechnologyCatAdapter.ViewHolder holder, int position) {
        int TecId=technolgyCategoryModelList.get(position).getTecCatID();
        String TecTitile=technolgyCategoryModelList.get(position).getTecCatTitle();
        String TecImageURL=technolgyCategoryModelList.get(position).getTecCatImageURL();
        holder.setData(TecId,TecImageURL,TecTitile);


    }

    @Override
    public int getItemCount() {
        return technolgyCategoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView TecImage;
        TextView TecTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            TecImage = itemView.findViewById(R.id.Techmology_view_image);
            TecTitle = itemView.findViewById(R.id.trendingTechnologyTitle);
        }

        public void setData(int id, String ImageURL, String Title) {
            TecTitle.setText(Title);
            if (ImageURL == null || ImageURL.trim().isEmpty()) {
                TecImage.setImageResource(R.drawable.ic_image); // your placeholder drawable
            } else {
                Glide.with(itemView.getContext())
                        .load(ImageURL)
                        .centerCrop()
                        .placeholder(R.drawable.ic_image) // shown while loading
                        .error(R.drawable.ic_image)       // shown if load fails
                        .into(TecImage);
            }
        }
    }
}
