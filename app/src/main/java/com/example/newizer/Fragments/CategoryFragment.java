package com.example.newizer.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newizer.Adapter.AllCategoryAdpater;
import com.example.newizer.Adapter.CategoryAdapter;
import com.example.newizer.ModelClass.CategoryModel;
import com.example.newizer.R;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {
  private RecyclerView AllCAtegoryReclcyerView;
    String testURl="https://picsum.photos/400";
    String sliderimageURL="https://picsum.photos/seed/picsum/200/400";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View view= inflater.inflate(R.layout.fragment_category, container, false);
        AllCAtegoryReclcyerView=view.findViewById(R.id.AllCAtegoryReclcyerView);

        GridLayoutManager allcategoryGridlayoutManager=new GridLayoutManager(getContext(),3);
        allcategoryGridlayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        AllCAtegoryReclcyerView.setLayoutManager(allcategoryGridlayoutManager);
        List<CategoryModel> allcategoryModelList=new ArrayList<>();
        allcategoryModelList.add(new CategoryModel(1,"Technology",testURl));
        allcategoryModelList.add(new CategoryModel(2,"sports",sliderimageURL));
        allcategoryModelList.add(new CategoryModel(3,"Foods",testURl));
        allcategoryModelList.add(new CategoryModel(4,"Automobile",sliderimageURL));
        allcategoryModelList.add(new CategoryModel(5,"Politics",testURl));
        allcategoryModelList.add(new CategoryModel(6,"Entertainment",sliderimageURL));
        AllCategoryAdpater allcategoryAdapter=new AllCategoryAdpater(allcategoryModelList);
        AllCAtegoryReclcyerView.setAdapter(allcategoryAdapter);
        allcategoryAdapter.notifyDataSetChanged();

        return view;

    }
}