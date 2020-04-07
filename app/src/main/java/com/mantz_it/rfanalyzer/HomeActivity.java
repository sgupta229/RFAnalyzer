package com.mantz_it.rfanalyzer;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        //overridePendingTransition(0,0);
                        return true;
                    case R.id.addComm:
                        startActivity(new Intent(getApplicationContext(), AddComm.class));
                        break;
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(HomeActivity.this, MainActivity.class));
    }

    public void sendMessage(View view) {
        ImageButton AMBtn = (ImageButton)findViewById(R.id.AM_btn);
        ImageButton wideFMBtn = (ImageButton)findViewById(R.id.wide_FM_btn);
        ImageButton narrowFMBtn = (ImageButton)findViewById(R.id.narrow_FM_btn);
        AMBtn.setOnClickListener(this);
        wideFMBtn.setOnClickListener(this);
        narrowFMBtn.setOnClickListener(this);
    }
}
