package com.mantz_it.rfanalyzer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
                        break;
                    case R.id.settings:
                        break;
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
