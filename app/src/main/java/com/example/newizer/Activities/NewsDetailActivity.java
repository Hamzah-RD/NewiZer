package com.example.newizer.Activities;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.newizer.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class NewsDetailActivity extends AppCompatActivity {
    ImageView imageView;
    TextView titleView, dateView, contentView,categoryview;
    WebView webView;
    YouTubePlayerView youTubePlayerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_detail2);

        imageView = findViewById(R.id.NewsIamge);
        titleView = findViewById(R.id.Newstitle);
        dateView = findViewById(R.id.tvdate);
        contentView = findViewById(R.id.tvDetail);
        categoryview=findViewById(R.id.tvCategory);
        webView = findViewById(R.id.webViewplayer);
        youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);


        String title = getIntent().getStringExtra("title");
        String image = getIntent().getStringExtra("image");
        String date = getIntent().getStringExtra("date");
        String category = getIntent().getStringExtra("category");
        String content = getIntent().getStringExtra("content");
        String url = getIntent().getStringExtra("url");


        if (title != null) titleView.setText(title);
        if (date != null) dateView.setText(date);
        if (content != null) contentView.setText(content);
        if (category != null) categoryview.setText(category);

        if (image != null && !image.isEmpty()) {
            Glide.with(this).load(image).into(imageView);
        }

        // Decide: YouTube video or normal web page
        String ytId = extractYouTubeId(url);
        if (ytId != null) {
            // play with YouTubePlayerView
            webView.setVisibility(View.GONE);
            youTubePlayerView.setVisibility(View.VISIBLE);

            youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
                @Override
                public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                    if (ytId != null && !ytId.isEmpty()) {
                        // load video instead of cue to actually start playing
                        youTubePlayer.loadVideo(ytId, 0);
                    }
                }
            });
        } else {
            // show article page in webview
            youTubePlayerView.setVisibility(View.GONE);
            webView.setVisibility(View.VISIBLE);
            webView.getSettings().setJavaScriptEnabled(true);
            if (url != null && !url.isEmpty()) webView.loadUrl(url);
        }
    }

    // crude extractor for YouTube IDs (works for typical URLs)
    private String extractYouTubeId(String url) {
        if (url == null) return null;
        try {
            if (url.contains("youtu.be/")) {
                return url.substring(url.lastIndexOf("/") + 1);
            } else if (url.contains("v=")) {
                String afterV = url.split("v=")[1];
                int amp = afterV.indexOf('&');
                return amp == -1 ? afterV : afterV.substring(0, amp);
            } else if (url.contains("embed/")) {
                return url.substring(url.lastIndexOf("/") + 1);
            }
        } catch (Exception ignored) {}
        return null;
    }
}
