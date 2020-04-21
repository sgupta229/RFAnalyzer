package com.mantz_it.rfanalyzer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import java.util.*;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private List<ExampleItem> exampleList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        createExampleList();
        buildRecyclerView();

        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.edittext_insert);
        editTextRemove = findViewById(R.id.edittext_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });

        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
    }

    public void insertItem(int position) {
        exampleList.add(position, new ExampleItem("new freq"));
        adapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        exampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(HomeActivity.this, MainActivity.class));
    }

//    public void sendMessage(View view) {
//        ImageButton AMBtn = (ImageButton)findViewById(R.id.AM_btn);
//        ImageButton wideFMBtn = (ImageButton)findViewById(R.id.wide_FM_btn);
//        ImageButton narrowFMBtn = (ImageButton)findViewById(R.id.narrow_FM_btn);
//        AMBtn.setOnClickListener(this);
//        wideFMBtn.setOnClickListener(this);
//        narrowFMBtn.setOnClickListener(this);
//    }

    public void createExampleList() {
        exampleList = new ArrayList<>();
        exampleList.add(new ExampleItem("AM Frequency"));
    }

    public void buildRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
