package com.example.sammie.coreteccontacts;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class AddContact extends DialogFragment {
    EditText saccoName, saccoLocation, saccoDescription, saccoNumber;
    String sacco_name, sacco_location, sacco_description, sacco_number;
    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_add_contact, null);
        saccoName = (EditText) view.findViewById(R.id.sacco_name);
        saccoDescription = (EditText) view.findViewById(R.id.sacco_description);
        saccoLocation = (EditText) view.findViewById(R.id.sacco_location);
        saccoNumber = (EditText) view.findViewById(R.id.sacco_number);
        builder.setView(view);
        builder.setMessage("Add new contact")
                .setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                        sacco_name = saccoName.getText().toString();
                        sacco_description = saccoDescription.getText().toString();
                        sacco_location = saccoLocation.getText().toString();
                        sacco_number = saccoNumber.getText().toString();
                        String key = mDatabase.child("CoretecContacts").push().getKey();
                        Contact contact= new Contact(sacco_name, sacco_location, sacco_description, sacco_number);
                        Map<String, Object> postValues = contact.toMap();
                        Map<String, Object> childUpdates = new HashMap<>();
                        childUpdates.put(key,postValues);
                        mDatabase.updateChildren(childUpdates);


                    }
                })
                .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });


        return builder.create();
    }

}