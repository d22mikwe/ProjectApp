package com.example.projectapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    TextView aboutInfo;
    ImageButton buttonBackAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutInfo = findViewById(R.id.textViewAboutInfo);
        aboutInfo.setText(getTextInfo());

        buttonBackAbout = findViewById(R.id.imageButtonAboutBack);
        buttonBackAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public String getTextInfo(){
        return "This application is targeted towards those who are looking to acquire a new best friend. You will get information about what" +
                " type of breeds that are available, their cost and what kind of purpose they were bred for. Whether you are looking for" +
                " a family friendly dog as your first pet or if you are a more experienced pet owner who wants a hunting or herding dog this center is for you!";
    }
}


