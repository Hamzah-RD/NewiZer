package com.example.newizer.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newizer.Adapter.CategoryAdapter;
import com.example.newizer.Adapter.SliderAdapter;
import com.example.newizer.Adapter.TechnologyCatAdapter;
import com.example.newizer.Adapter.TrendingAdapter;
import com.example.newizer.ModelClass.NewsArticle;
import com.example.newizer.ModelClass.NewsResponse;
import com.example.newizer.Network.NewsApiInterface;
import com.example.newizer.ModelClass.CategoryModel;
import com.example.newizer.Network.RetrofitClient;
import com.example.newizer.ModelClass.SliderModel;
import com.example.newizer.ModelClass.TechnolgyCategoryModel;
import com.example.newizer.ModelClass.TrendingModel;
import com.example.newizer.R;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class  HomeFragment extends Fragment {
    public HomeFragment() {
    }

    //Lists
    private List<TrendingModel> trendingModelList = new ArrayList<>();
    private List<CategoryModel> categoryModelList = new ArrayList<>();
    private List<SliderModel> sliderModels = new ArrayList<>();
    private List<TechnolgyCategoryModel> teccategoryModelList = new ArrayList<>();
    //RecyclerView
    private RecyclerView TrendrecyclerView, CategoryRecyclerView, TecReclcyerView;
    private TrendingAdapter trendingAdapter;
    private TechnologyCatAdapter technologyCatAdapter;
    private  SliderAdapter sliderAdapter;

    //SliderView
    private SliderView sliderView;

    private CategoryAdapter categoryAdapter;
    private static final String API_KEY = "b23768ca2a3a4c8a8a621d3ab5cc4d42";

    String testURl = "https://picsum.photos/400";
    String sliderimageURL = "https://picsum.photos/seed/picsum/200/400";

    String[] categories = {"business", "technology", "sports", "health"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        CategoryRecyclerView = view.findViewById(R.id.Category_RecyclerView);
        TrendrecyclerView = view.findViewById(R.id.trendingRecyclerView);
        TecReclcyerView = view.findViewById(R.id.TechloguRecyclerView);
        sliderView = view.findViewById(R.id.imageSlider);

// category RecyclerView
        LinearLayoutManager categorylinearLayoutManager = new LinearLayoutManager(getContext());
        categorylinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        CategoryRecyclerView.setLayoutManager(categorylinearLayoutManager);
//        categoryModelList.add(new CategoryModel(1,"Food",sliderimageURL));
//        categoryModelList.add(new CategoryModel(2,"Automoble",testURl));
//        categoryModelList.add(new CategoryModel(3,"Entertenment",sliderimageURL));
//        categoryModelList.add(new CategoryModel(4,"Technology",testURl));
//        categoryModelList.add(new CategoryModel(5,"Politics",sliderimageURL));
//        categoryModelList.add(new CategoryModel(6,"War",testURl));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        CategoryRecyclerView.setAdapter(categoryAdapter);
        loadCategories();


//Trending Slider  News RecyclerView

//        sliderModels.add(new SliderModel(1, sliderimageURL));
//        sliderModels.add(new SliderModel(2, testURl));
//        sliderModels.add(new SliderModel(3, sliderimageURL));
//        sliderModels.add(new SliderModel(4, testURl));
//        sliderModels.add(new SliderModel(5, sliderimageURL));
//        sliderModels.add(new SliderModel(6, testURl));

        sliderAdapter = new SliderAdapter(sliderModels);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
        loadTopNewsForSlider();

//Trending News RecyclerView
//        LinearLayoutManager TreadingLinrLayoutManager=new LinearLayoutManager(getContext());
//        TreadingLinrLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        TrendrecyclerView.setLayoutManager(TreadingLinrLayoutManager);
//        List<TrendingModel> trendingModelList=new ArrayList<>();
//
//        trendingModelList.add(new TrendingModel(1,"edu","Pakistan's # 01 uni",testURl,"15/06/2022"));
//        trendingModelList.add(new TrendingModel(2,"sport","india win the Match aganist the pakistan"
//                ,sliderimageURL,"14/06/2022"));
//        trendingModelList.add(new TrendingModel(3,"Mucis","arjit new songs is trending no.1"
//                ,testURl,"10/06/2022"));
//        trendingModelList.add(new TrendingModel(4,"technology","it sectec is top on the world"
//                ,sliderimageURL,"25/06/2022"));
//        trendingModelList.add(new TrendingModel(5,"Politics","Pakistan's # 01 uni ",
//                testURl,"5/06/2022"));
//        trendingModelList.add(new TrendingModel(6,"Autombile","Pdasdasdasd asdasd"
//                ,sliderimageURL,"23/06/2022"));
//        trendingModelList.add(new TrendingModel(7,"Entertrements","Pakistan's # 01 un asdasd i"
//                ,testURl,"15/06/2022"));
//        trendingModelList.add(new TrendingModel(8,"nature","Pakistan's # 01 un   asdasdi asdasd eqwe rtyrt qeqw"
//                ,sliderimageURL,"15/06/2022"));
//        TrendingAdapter trendingAdapter=new TrendingAdapter(trendingModelList);
//        TrendrecyclerView.setAdapter(trendingAdapter);
//        trendingAdapter.notifyDataSetChanged();

        //Trending Technology Category Neews ReclcyerView


        TrendrecyclerView = view.findViewById(R.id.trendingRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        TrendrecyclerView.setLayoutManager(layoutManager);

        trendingAdapter = new TrendingAdapter(trendingModelList);
        TrendrecyclerView.setAdapter(trendingAdapter);

        loadNews();

//Technolgy
        GridLayoutManager tecgridLayoutManager = new GridLayoutManager(getContext(), 2);
        tecgridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        TecReclcyerView.setLayoutManager(tecgridLayoutManager);
//
//        teccategoryModelList.add(new TechnolgyCategoryModel(1, testURl, "Technology"));
//        teccategoryModelList.add(new TechnolgyCategoryModel(2, sliderimageURL, "sports"));
//        teccategoryModelList.add(new TechnolgyCategoryModel(3, testURl, "Foods"));
//        teccategoryModelList.add(new TechnolgyCategoryModel(4, sliderimageURL, "Automobile"));
//        teccategoryModelList.add(new TechnolgyCategoryModel(5, testURl, "Politics"));
//        teccategoryModelList.add(new TechnolgyCategoryModel(6, sliderimageURL, "Entertainment"));
         technologyCatAdapter = new TechnologyCatAdapter(teccategoryModelList);
        TecReclcyerView.setAdapter(technologyCatAdapter);
        loadTechnologyNews();


        return view;

    }

    private void loadNews() {
        NewsApiInterface api = RetrofitClient.getClient().create(NewsApiInterface.class);

        api.getTopHeadlines("us", null, API_KEY).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    trendingModelList.clear();

                    // Loop through the list of NewsArticle objects
                    for (NewsArticle article : response.body().getArticles()) {
                        trendingModelList.add(new TrendingModel(
                                0,                                 // dummy id
                                article.getSource().getName(),     // category/source name
                                article.getTitle(),                // title
                                article.getUrlToImage(),           // image URL
                                article.getPublishedAt()     ,
                                article.getContent(),
                                article.getUrl()// date
                        ));
                    }

                    trendingAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getContext(),
                            "Error: " + response.message(),
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Toast.makeText(getContext(),
                        "Failed to load news: " + t.getMessage(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadCategories() {
        NewsApiInterface api = RetrofitClient.getClient().create(NewsApiInterface.class);

        for (String cat : categories) {
            // Make API call for each category
            api.getTopHeadlines("us", cat, API_KEY)
                    .enqueue(new Callback<NewsResponse>() {
                        @Override
                        public void onResponse(Call<NewsResponse> call,
                                               Response<NewsResponse> response) {
                            if (response.isSuccessful() && response.body() != null
                                    && !response.body().getArticles().isEmpty()) {

                                // Take the first article’s image as category image
                                NewsArticle firstArticle = response.body().getArticles().get(0);
                                String imageUrl = firstArticle.getUrlToImage();

                                CategoryModel model = new CategoryModel(
                                        0, // id if you have one
                                        cat.substring(0, 1).toUpperCase() + cat.substring(1), // Capitalise
                                        imageUrl
                                );
                                categoryModelList.add(model);
                                categoryAdapter.notifyDataSetChanged();
                            }
                        }

                        @Override
                        public void onFailure(Call<NewsResponse> call, Throwable t) {
                            Toast.makeText(getContext(), "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }

    private void loadTopNewsForSlider() {
        NewsApiInterface api = RetrofitClient.getClient().create(NewsApiInterface.class);

        api.getTopHeadlines("us",null, API_KEY) // no category -> just top headlines
                .enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call,
                                           Response<NewsResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            sliderModels.clear();

                            // take, for example, first 5 articles for slider
                            int count = Math.min(5, response.body().getArticles().size());
                            for (int i = 0; i < count; i++) {
                                NewsArticle article = response.body().getArticles().get(i);

                                sliderModels.add(new SliderModel(
                                        i, // id
                                        article.getUrlToImage() // image URL for slider
                                ));
                            }

                            sliderAdapter.notifyDataSetChanged(); // refresh slider
                        } else {
                            Toast.makeText(getContext(),
                                    "Error: " + response.message(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {
                        Toast.makeText(getContext(),
                                "Failed to load slider news: " + t.getMessage(),
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void loadTechnologyNews() {
        NewsApiInterface api = RetrofitClient.getClient().create(NewsApiInterface.class);

        api.getTopHeadlines("us", "technology", API_KEY)
                .enqueue(new Callback<NewsResponse>() {
                    @Override
                    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                        if (response.isSuccessful() && response.body() != null
                                && !response.body().getArticles().isEmpty()) {

                            // Clear old list first
                            teccategoryModelList.clear();

                            for (NewsArticle article : response.body().getArticles()) {
                                teccategoryModelList.add(
                                        new TechnolgyCategoryModel(
                                                0, // or use position index
                                                article.getUrlToImage(),
                                                article.getTitle() // or article.getDescription()
                                        )
                                );
                            }

                            technologyCatAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {
                        Toast.makeText(getContext(), "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
