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
import com.example.newizer.Adapter.SliderAdapter;
import com.example.newizer.Adapter.TrendingAdapter;
import com.example.newizer.ModelClass.CategoryModel;
import com.example.newizer.ModelClass.SliderModel;
import com.example.newizer.ModelClass.TrendingModel;
import com.example.newizer.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class  HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView CategoryRecyclerView;

    private  RecyclerView TrendrecyclerView;
    private SliderView sliderView;
      String testURl="https://picsum.photos/400";
    String sliderimageURL="https://picsum.photos/seed/picsum/200/400";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        CategoryRecyclerView=view.findViewById(R.id.Category_RecyclerView);
        sliderView=view.findViewById(R.id.imageSlider);
        TrendrecyclerView=view.findViewById(R.id.trendingRecyclerView);

        LinearLayoutManager categorylinearLayoutManager=new LinearLayoutManager(getContext());
        categorylinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        CategoryRecyclerView.setLayoutManager(categorylinearLayoutManager);
        List<CategoryModel> categoryModelList=new ArrayList<>();
        categoryModelList.add(new CategoryModel(1,"Technology",testURl));
        categoryModelList.add(new CategoryModel(2,"sports",sliderimageURL));
        categoryModelList.add(new CategoryModel(3,"Foods",testURl));
        categoryModelList.add(new CategoryModel(4,"Automobile",sliderimageURL));
        categoryModelList.add(new CategoryModel(5,"Politics",testURl));
        categoryModelList.add(new CategoryModel(6,"Entertainment",sliderimageURL));
        CategoryAdapter categoryAdapter=new CategoryAdapter(categoryModelList);
        CategoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


        List<SliderModel> sliderModels=new ArrayList<>();
        sliderModels.add(new SliderModel(1,sliderimageURL));
        sliderModels.add(new SliderModel(2,testURl));
        sliderModels.add(new SliderModel(3,sliderimageURL));
        sliderModels.add(new SliderModel(4,testURl));
        sliderModels.add(new SliderModel(5,sliderimageURL));
        sliderModels.add(new SliderModel(6,testURl));

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModels);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();


        LinearLayoutManager TreadingLinrLayoutManager=new LinearLayoutManager(getContext());
        TreadingLinrLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        TrendrecyclerView.setLayoutManager(TreadingLinrLayoutManager);
        List<TrendingModel> trendingModelList=new ArrayList<>();

        trendingModelList.add(new TrendingModel(1,"edu","Pakistan's # 01 uni",testURl,"15/06/2022"));
        trendingModelList.add(new TrendingModel(2,"sport","india win the Match aganist the pakistan"
                ,sliderimageURL,"14/06/2022"));
        trendingModelList.add(new TrendingModel(3,"Mucis","arjit new songs is trending no.1"
                ,testURl,"10/06/2022"));
        trendingModelList.add(new TrendingModel(4,"technology","it sectec is top on the world"
                ,sliderimageURL,"25/06/2022"));
        trendingModelList.add(new TrendingModel(5,"Politics","Pakistan's # 01 uni ",
                testURl,"5/06/2022"));
        trendingModelList.add(new TrendingModel(6,"Autombile","Pdasdasdasd asdasd"
                ,sliderimageURL,"23/06/2022"));
        trendingModelList.add(new TrendingModel(7,"Entertrements","Pakistan's # 01 un asdasd i"
                ,testURl,"15/06/2022"));
        trendingModelList.add(new TrendingModel(8,"nature","Pakistan's # 01 un   asdasdi asdasd eqwe rtyrt qeqw"
                ,sliderimageURL,"15/06/2022"));
        TrendingAdapter trendingAdapter=new TrendingAdapter(trendingModelList);
        TrendrecyclerView.setAdapter(trendingAdapter);
        trendingAdapter.notifyDataSetChanged();
        return view;

    }
}