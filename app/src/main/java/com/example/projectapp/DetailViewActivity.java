package com.example.projectapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class DetailViewActivity extends AppCompatActivity
{
    ImageButton buttonBack;
    TextView tvBreed;
    TextView tvCost;
    TextView tvType;
    TextView tvPopularity;
    TextView tvInfo;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailview);


        buttonBack = findViewById(R.id.imageButton);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    protected void onResume() {
        super.onResume();

        intent = getIntent();
        Bundle extras = intent.getExtras();

        tvBreed = findViewById(R.id.textViewBreed);
        tvType = findViewById(R.id.textViewTypeInput);
        tvPopularity = findViewById(R.id.textViewPopularityInput);
        tvInfo = findViewById(R.id.textViewInfo);
        tvCost = findViewById(R.id.textViewCostInput);

        String info = extras.getString("info");
        tvBreed.setText(extras.getString("name"));
        tvCost.setText(extras.getString("cost"));
        tvType.setText(extras.getString("dogtype"));
        tvPopularity.setText(extras.getString("popularity"));
        tvInfo.setText(info);
    }


}
