package com.example.projectapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;



import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=d22mikwe";
    ArrayList<DogItem> items;
    Button saveButton;
    ImageButton buttonAbout;
    Switch switchFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new JsonTask(this).execute(JSON_URL);

        buttonAbout = findViewById(R.id.imageButtonAbout);
        buttonAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbout = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intentAbout);
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences("saveFilter", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        saveButton = findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!switchFilter.isChecked()){
                    editor.putString("saveFilter", "yes").apply();
                }
                if(!switchFilter.isChecked()){
                    editor.putString("saveFilter", "no").apply();
                }
            }
        });

    }

    @Override
    public void onPostExecute(String json) {
        Log.d("MainActivity", json);
        Gson newGson = new Gson();
        Type newType = new TypeToken<List<DogItem>>() {}.getType();
        items = newGson.fromJson(json, newType);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(DogItem item) {
                Intent intent = new Intent(MainActivity.this, DetailViewActivity.class);
                String ID = item.getID();
                String login = item.getLogin();
                String name = item.getName();
                String cost = item.getCost();
                String info = item.getAuxdata();
                String origin = item.getOrigin();
                String weight = item.getWeight();
                String type = item.getDogtype();
                String popularity = item.getPopularity();

                Bundle extras = new Bundle();
                extras.putString("ID", ID);
                extras.putString("login", login);
                extras.putString("name", name);
                extras.putString("cost", cost);
                extras.putString("info", info);
                extras.putString("origin", origin);
                extras.putString("dogtype", type);
                extras.putString("weight", weight);
                extras.putString("popularity", popularity);

                intent.putExtras(extras);

                startActivity(intent);
            }
        });

        switchFilter = findViewById(R.id.switchFilter);
        switchFilter.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                boolean checked = switchFilter.isChecked();
                if (checked){
                    adapter.filterDogItemList();
                    adapter.notifyDataSetChanged();

                }
                if(!checked){
                    adapter.unFilterDogItemList();
                    adapter.notifyDataSetChanged();
                }
            }
        });

        RecyclerView view = findViewById(R.id.itemlist);
        view.setAdapter(adapter);
        view.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences sharedPreferences = getSharedPreferences("saveFilter", MODE_PRIVATE);

        if(sharedPreferences.getString("saveFilter", "no").equals("yes")){
            switchFilter.setChecked(true);
            adapter.filterDogItemList();
            adapter.notifyDataSetChanged();
        }

    }



}