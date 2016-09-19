package com.example.sammie.coreteccontacts;

public class Sacco {

    String description;
    String location;
    String name;
    String number;

    public Sacco() {
    }

    public Sacco(String description, String location, String name, String number) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public  String getName() {

        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {

        return location;
    }
    public String getNumber(){
        return number;
    }
}