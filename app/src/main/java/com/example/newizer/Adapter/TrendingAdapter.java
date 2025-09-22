package com.example.newizer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newizer.ModelClass.TrendingModel;
import com.example.newizer.R;

import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.Viewholder> {
  List<TrendingModel> trendingModelList;

    public TrendingAdapter(List<TrendingModel> trendingModelList) {
        this.trendingModelList = trendingModelList;
    }

    @NonNull
    @Override
    public TrendingAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.trending_item,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingAdapter.Viewholder holder, int position) {
        int trendingID=trendingModelList.get(position).getId();
        String trendingTitle=trendingModelList.get(position).getTrendingTitle();
        String trendingImageURL=trendingModelList.get(position).getTrendingImageURL();
        String trendingCategory=trendingModelList.get(position).getTrendingCategory();
        String trendingDate=trendingModelList.get(position).getTrendingDate();
        holder.setData(trendingID,trendingTitle,trendingCategory,trendingDate,trendingImageURL);

    }

    @Override
    public int getItemCount() {
        return trendingModelList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
       private ImageView TrendingImage;
        private TextView trendingTitle,trendingDate,trendingCategory;

        public Viewholder(View itemView) {
            super(itemView);
            TrendingImage=itemView.findViewById(R.id.article_view_image);
            trendingTitle=itemView.findViewById(R.id.trendingTitle);
            trendingDate=itemView.findViewById(R.id.trendingDate);
            trendingCategory=itemView.findViewById(R.id.trendingCategory);
        }
        public  void setData(int id,String Title,String Category,String Date,String ImageURL)
        {
            trendingTitle.setText(Title);
            trendingDate.setText(Date);
            trendingCategory.setText(Category);

            Glide
                    .with(itemView.getContext())
                    .load(ImageURL)
                    .centerCrop()
                    .placeholder(R.drawable.logo)
                    .into(TrendingImage);

        }
    }
}
