package com.example.sammie.coreteccontacts;

import com.google.firebase.database.DataSnapshot;

import java.util.HashMap;
import java.util.Map;

//Class Contact used to create contacts objects
public class Contact {
    public String saccoName;
    public String saccoLocation;
    public String saccoDescription;
    public String saccoNumber;

    public Contact() {
        //Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Contact(String name, String location, String description, String number) {
        this.saccoName = name;
        this.saccoLocation = location;
        this.saccoDescription = description;
        this.saccoNumber = number;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", saccoName);
        result.put("location", saccoLocation);
        result.put("description", saccoDescription);
        result.put("number", saccoNumber);
        return result;
    }



}
