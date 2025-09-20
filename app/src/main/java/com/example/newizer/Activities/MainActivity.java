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
                } if (id==R.id.navnotification)
                {
                    loadFragement(new NotificationFragment());
                    Toast.makeText(MainActivity.this, "Notificaion", Toast.LENGTH_SHORT).show();
                    return true;
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
}