package com.mantz_it.rfanalyzer;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddComm extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_comm);

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

        Button buttonAddComm = findViewById(R.id.buttonAddComm);

        buttonAddComm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText editText = findViewById(R.id.customNameText);

                Bundle bundle = new Bundle();
                bundle.putString("name", editText.getText().toString());

                Intent i = new Intent(AddComm.this, HomeActivity.class);
                i.putExtra("NewComm", bundle);

                startActivity(i);
            }
        });

    }
}
