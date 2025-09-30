package com.example.newizer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newizer.ModelClass.CategoryModel;
import com.example.newizer.R;

import java.util.List;

public class AllCategoryAdpater extends RecyclerView.Adapter<AllCategoryAdpater.ViewHolder> {

    List<CategoryModel> categoryModelList;

    public AllCategoryAdpater(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public AllCategoryAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.all_category_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCategoryAdpater.ViewHolder holder, int position) {
        int catid=categoryModelList.get(position).getCategoryid();
        String cattext=categoryModelList.get(position).getCategoryname();
        String catimage=categoryModelList.get(position).getImageurl();
        holder.setData(catid,cattext,catimage);


    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryimage;
        TextView categorytext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryimage=itemView.findViewById(R.id.allcategory_image);
            categorytext=itemView.findViewById(R.id.allcategory_textView);
        }
        private  void setData(int categoryid,String categoryname,String categoryURL)
        {
            categorytext.setText(categoryname);
            Glide
                    .with(itemView.getContext())
                    .load(categoryURL)
                    .centerCrop()
                    .placeholder(R.drawable.logo)
                    .into(categoryimage);
        }
    }
}
