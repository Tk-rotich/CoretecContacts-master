package com.example.sammie.coreteccontacts;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import android.R;


public class SecondActivity extends AppCompatActivity {
    String sPosition = "true";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        setTitle("com.example.sammie.coreteccontacts.Sacco Details");

        Bundle b = getIntent().getExtras();
        b.putString("position", sPosition);

        sPosition = this.getIntent().getStringExtra("position");

        Toast.makeText(getApplicationContext(), sPosition, Toast.LENGTH_SHORT).show();

    }
}



