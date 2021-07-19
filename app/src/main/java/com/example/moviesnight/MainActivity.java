package com.example.moviesnight;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.bottom_navigation);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , new HomeFragment()).commit();

        navView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment SelectedFragment = null ;

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        SelectedFragment = new HomeFragment();
                        break;
                    case R.id.navigation_favour:
                        SelectedFragment = new FaviouratFragment();
                        break;case R.id.navigation_account:
                        SelectedFragment = new AccountFragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , SelectedFragment).commit();
            }
        });


    }


}