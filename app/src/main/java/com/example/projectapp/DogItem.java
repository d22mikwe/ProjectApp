package com.example.projectapp;

import android.util.Log;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("WeakerAccess")
public class DogItem {
    protected String ID;
    protected String name;

    @SerializedName(value = "type", alternate = "login")
    protected String login;
    @SerializedName(value = "company", alternate = "popularity")
    protected String popularity;
    @SerializedName(value = "location", alternate = "origin")
    protected String origin;

    @SerializedName(value = "category", alternate = "dogtype")
    protected String dogtype;
    @SerializedName(value = "size", alternate = "weight")
    protected String weight;
    protected String cost;
    protected String auxdata;


    public String getName() {
        return name;
    }

    public String getID(){
        return ID;
    }

    public String getLogin(){
        return login;
    }
    public String getPopularity(){
        return popularity;
    }
    public String getOrigin(){
        return origin;
    }
    public String getDogtype(){
        return dogtype;
    }
    public String getCost(){
        return cost;
    }

    public String getWeight(){
        return weight;
    }

    public String getAuxdata(){
        return auxdata;
    }

}
