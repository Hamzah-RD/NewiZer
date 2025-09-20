package com.example.newizer.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.newizer.Adapter.CategoryAdapter;
import com.example.newizer.ModelClass.CategoryModel;
import com.example.newizer.R;

import java.util.ArrayList;
import java.util.List;


public class  HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView CategoryRecyclerView;
    private  String testURl="https://picsum.photos/200";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        CategoryRecyclerView=view.findViewById(R.id.Category_RecyclerView);

        LinearLayoutManager categorylinearLayoutManager=new LinearLayoutManager(getContext());
        categorylinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        CategoryRecyclerView.setLayoutManager(categorylinearLayoutManager);
        List<CategoryModel> categoryModelList=new ArrayList<>();
        categoryModelList.add(new CategoryModel(1,"Technology",testURl));
        categoryModelList.add(new CategoryModel(2,"sports",testURl));
        categoryModelList.add(new CategoryModel(3,"Foods",testURl));
        categoryModelList.add(new CategoryModel(4,"Automobile",testURl));
        categoryModelList.add(new CategoryModel(5,"Politics",testURl));
        categoryModelList.add(new CategoryModel(6,"Entertainment",testURl));
        CategoryAdapter categoryAdapter=new CategoryAdapter(categoryModelList);
        CategoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
        return view;

    }
}