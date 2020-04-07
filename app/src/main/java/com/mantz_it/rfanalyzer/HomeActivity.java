package com.mantz_it.rfanalyzer;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TextView;

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
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.addComm:
                        startActivity(new Intent(getApplicationContext(), AddComm.class));
                        overridePendingTransition(0,0);
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

        Intent i = getIntent();

        if (i.getBundleExtra("NewComm")!=null)
        {
            Bundle b = i.getBundleExtra("NewComm");
            String newComm = b.getString("name");

            LinearLayout mainLinearLayout = findViewById(R.id.mainLinearLayout);

            CardView newCard = new CardView(getApplicationContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            newCard.setLayoutParams(layoutParams);
            newCard.setCardBackgroundColor(getResources().getColor(R.color.redPrimary));
            newCard.setContentPadding(getResources().getDimensionPixelSize(R.dimen.cardPadding), getResources().getDimensionPixelSize(R.dimen.cardPadding), getResources().getDimensionPixelSize(R.dimen.cardPadding), getResources().getDimensionPixelSize(R.dimen.cardPadding));
            newCard.setRadius(getResources().getDimensionPixelSize(R.dimen.cardRadius));

            LinearLayout textWrap = new LinearLayout(getApplicationContext());
            textWrap.setGravity(Gravity.CENTER_VERTICAL);

            TextView newText = new TextView(getApplicationContext());
            newText.setText(newComm);
            newText.setTextColor(Color.WHITE);

            textWrap.addView(newText);
            newCard.addView(textWrap);

            LinearLayout wrapper = new LinearLayout(getApplicationContext());
            wrapper.setGravity(Gravity.RIGHT);

            ImageButton newButton = new ImageButton(getApplicationContext());
            LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            buttonLayoutParams.gravity = Gravity.TOP;
            newButton.setLayoutParams(buttonLayoutParams);
            newButton.setImageResource(R.drawable.ic_keyboard_arrow_right_black_24dp);
            newButton.setBackground(null);
            newButton.setScaleType(ImageView.ScaleType.FIT_END);

            wrapper.addView(newButton);
            newCard.addView(wrapper);

            Space space = new Space(getApplicationContext());
            LinearLayout.LayoutParams spaceLayout = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getResources().getDimensionPixelSize(R.dimen.space));

            mainLinearLayout.addView(space, spaceLayout);

            mainLinearLayout.addView(newCard);
        }
    }

    public void goToMap(View view) {
        ImageButton AMLoc = (ImageButton)findViewById(R.id.AM_loc);
        AMLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
            }
        });
        ImageButton FMLoc = findViewById(R.id.narrow_FM_loc);
        FMLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
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
