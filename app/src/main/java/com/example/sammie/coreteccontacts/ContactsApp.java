package com.example.sammie.coreteccontacts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
//Hapa ndo inaanza
public class ContactsApp extends AppCompatActivity implements
        ContactsAppFragmentOne.OnFragmentInteractionListenerOne,
        ContactAppFragmentTwo.OnFragmentInteractionListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_app);
        //Hapa unacreate fragment one, hiyo ndo iko na ile list view
        ContactsAppFragmentOne contactsAppFragmentOne = new ContactsAppFragmentOne();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_fragment, contactsAppFragmentOne);
        ft.addToBackStack(null);
        ft.commit();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contacts_app, menu);
        return true;
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    //Use this method to get sacco name from ContactsAppFragmentOne
    @Override
    public void onFragmentInteractionOne(String saccoName, String saccoLocation, String saccoDescription, String saccoNumber) {
        //Log.e("HelloListView", "You clicked Item: "  + " at position:" + saccoName);
        //Create an object of the second fragment
        ContactAppFragmentTwo contactAppFragmentTwo = new ContactAppFragmentTwo();
        Bundle args = new Bundle();
        //pass the value of saccoName to the second fragment
        args.putString("SaccoName", saccoName);
        args.putString("SaccoLocation", saccoLocation);
        args.putString("SaccoDescription", saccoDescription);
        args.putString("SaccoNumber", saccoNumber);
        contactAppFragmentTwo.setArguments(args);
        // Then you start the ContactsAppFragmentTwo
        //Use Fragment transaction to transition to the second fragment
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //Add the fragment to the ContactsApp Activity - takes two parameters:
        //1. The XML fragment layout
        //2. The object of the fragment you are adding
        fragmentTransaction.replace(R.id.layout_fragment, contactAppFragmentTwo);
        //Add to back stack to enable up navigation
        fragmentTransaction.addToBackStack(null);
        //Commit
        fragmentTransaction.commit();


    }
}
