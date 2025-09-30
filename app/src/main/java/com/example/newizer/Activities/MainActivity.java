package com.example.newizer.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.newizer.Fragments.CategoryFragment;
import com.example.newizer.Fragments.HomeFragment;
import com.example.newizer.Fragments.NotificationFragment;
import com.example.newizer.Fragments.VideoFragment;
import com.example.newizer.R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
 private BottomNavigationView bottomNavigationView;
 FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        frameLayout=findViewById(R.id.frameLayout);
        setNotificationBadge(5);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if (id==R.id.navhome)
                {
                    loadFragement(new HomeFragment());
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    return true;
                }
                if (id==R.id.navvideo)
                {
                    loadFragement(new VideoFragment());
                    Toast.makeText(MainActivity.this, "Video", Toast.LENGTH_SHORT).show();
                    return true;
                } if (id==R.id.navcategory)
                {
                    loadFragement(new CategoryFragment());
                    Toast.makeText(MainActivity.this, "Category", Toast.LENGTH_SHORT).show();
                    return true;
                }
               // Toast.makeText(MainActivity.this, "Error"+ , Toast.LENGTH_SHORT).show();
                try {
                    if (id==R.id.navnotification)
                    {
                        loadFragement(new NotificationFragment());
                        Toast.makeText(MainActivity.this, "Notificaion", Toast.LENGTH_SHORT).show();
                        clearNotificationBadge();
                        return true;
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Error"+ e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                return false;
            }

        });
        loadFragement(new HomeFragment());

    }
    private  void loadFragement(Fragment fragment)
    {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();

    }

    public void setNotificationBadge(int count) {
        if (count > 0) {
            BadgeDrawable badge = bottomNavigationView.getOrCreateBadge(R.id.navnotification);
            badge.setVisible(true);
            badge.setNumber(count);         // “+23” style numbers automatically
            badge.setMaxCharacterCount(3);  // will show 99+ if >99
        } else {
            bottomNavigationView.removeBadge(R.id.navnotification);
        }
    }

    public void clearNotificationBadge() {
        bottomNavigationView.removeBadge(R.id.navnotification);
    }

    public void incrementNotificationBadge() {
        int current = 0;
        BadgeDrawable badge = bottomNavigationView.getBadge(R.id.navnotification);
        if (badge != null) current = badge.getNumber();
        setNotificationBadge(current + 1);
    }
}