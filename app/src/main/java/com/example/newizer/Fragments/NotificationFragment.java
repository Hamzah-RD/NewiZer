package com.example.newizer.Fragments;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.newizer.Activities.MainActivity;
import com.example.newizer.Adapter.TrendingAdapter;
import com.example.newizer.ModelClass.NewsArticle;
import com.example.newizer.ModelClass.NewsResponse;
import com.example.newizer.ModelClass.TrendingModel;
import com.example.newizer.Network.NewsApiInterface;
import com.example.newizer.Network.RetrofitClient;
import com.example.newizer.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NotificationFragment extends Fragment {
    private RecyclerView NoticationReclcyerView;
    private    TrendingAdapter trendingAdapter;
    private List<TrendingModel> trendingModelList=new ArrayList<>();
    private static final String API_KEY = "b23768ca2a3a4c8a8a621d3ab5cc4d42";
    String testURl="https://picsum.photos/400";
    String sliderimageURL="https://picsum.photos/seed/picsum/200/400";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_notification, container, false);
        NoticationReclcyerView=view.findViewById(R.id.Notification_RecyclerView);

        LinearLayoutManager TreadingLinrLayoutManager=new LinearLayoutManager(getContext());
        TreadingLinrLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        NoticationReclcyerView.setLayoutManager(TreadingLinrLayoutManager);
        trendingAdapter=new TrendingAdapter(trendingModelList);
        NoticationReclcyerView.setAdapter(trendingAdapter);
        loadNews();
        return view;
    }
    private void loadNews() {
        NewsApiInterface api = RetrofitClient.getClient().create(NewsApiInterface.class);

        api.getTopHeadlines("us", null, API_KEY)
                .enqueue(new retrofit2.Callback<NewsResponse>() {
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
                                article.getPublishedAt(),
                                article.getContent(),
                                article.getUrl()

                        ));
                    }
                    // show notification for the first article
                    if (!response.body().getArticles().isEmpty()) {
                        NewsArticle first = response.body().getArticles().get(0);
                        showNotification(first.getSource().getName(), first.getTitle());
                    }

                    // <— move this OUTSIDE of the if above
                    trendingAdapter.notifyDataSetChanged();

                } else {

                    Toast.makeText(getContext(),
                            "Error: " + response.message(),
                            Toast.LENGTH_SHORT).show();
                }}

                    @Override
                    public void onFailure(Call<NewsResponse> call, Throwable t) {
                        Toast.makeText(getContext(),
                                "Failed to load news: " + t.getMessage(),
                                Toast.LENGTH_SHORT).show();

                    }
                });
    }
    private void showNotification(String title, String message) {
        // Create channel once for Android 8+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    "news_channel",
                    "News Channel",
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager manager = requireContext().getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }

        // Permission check for Android 13+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(
                        requireActivity(),
                        new String[]{Manifest.permission.POST_NOTIFICATIONS},
                        101);
                return;
            }
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(requireContext(), "news_channel")
                .setSmallIcon(R.drawable.notification) // your icon
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManagerCompat.from(requireContext())
                .notify(new Random().nextInt(), builder.build());
    }


}