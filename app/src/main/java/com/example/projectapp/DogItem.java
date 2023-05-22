package com.example.projectapp;

@SuppressWarnings("WeakerAccess")
public class DogItem {
    private String ID;
    private String login;
    private String name;
    private String origin;
    private String cost;
    private String info;
    public DogItem (String ID, String login, String name, String location, String cost, String auxData) {
        this.ID = ID;
        this.login = login;
        this.name = name;
        this.origin = location;
        this.cost = cost;
        this.info = auxData;
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
}
