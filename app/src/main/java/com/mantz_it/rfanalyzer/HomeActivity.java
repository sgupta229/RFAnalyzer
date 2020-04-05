package com.mantz_it.rfanalyzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
