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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.viewHolder> {

    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    List<CategoryModel> categoryModelList;

    @NonNull
    @Override
    public CategoryAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item_layout,parent,false);
        return  new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.viewHolder holder, int position) {
        int catid=categoryModelList.get(position).getCategoryid();
        String cattext=categoryModelList.get(position).getCategoryname();
        String catimage=categoryModelList.get(position).getImageurl();
        holder.setDate(catid,cattext,catimage);

    }

    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

     ImageView categoryimage;
     TextView categorytext;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            categoryimage=itemView.findViewById(R.id.category_image);
            categorytext=itemView.findViewById(R.id.category_textView);
        }
        private  void setDate(int categoryid,String categoryname,String categoryURL)
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
