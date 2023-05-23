package com.example.projectapp;

@SuppressWarnings("WeakerAccess")
public class DogItem {
    private String ID;
    private String login;
    private String popularity;
    private String name;
    private String origin;
    private String cost;
    private String info;
    private String type;
    public DogItem (String ID, String login, String name, String company, String location, String cost, String category, String auxdata) {
        this.ID = ID;
        this.login = login;
        this.name = name;
        this.popularity = company;
        this.origin = location;
        this.cost = cost;
        this.type = category;
        this.info = auxdata;
    }
    public String getName() {
        return name;
    }

    public String getID(){
        return ID;
    }

    public String getLogin(){
        return login;
    }

    public String getCost(){
        return cost;
    }
    public String getInfo(){
        return info;
    }

    public String getOrigin(){
        return origin;
    }
    public String getPopularity(){
        return popularity;
    }
    public String getType(){
        return type;
    }
}
