package com.example.sammie.coreteccontacts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//After imecreatiwa app inakuja hapa
public class ContactsAppFragmentOne extends Fragment {

    private OnFragmentInteractionListenerOne mListener;
   DatabaseReference mDatabaseReference = FirebaseDatabase.getInstance().getReference();

    //creating list view.....
    private ListView contactList;
    private LinearLayout ln;
    private ArrayAdapter<String> listAdapter;
    String saccoName, saccoLocation, saccoDescription, saccoNumber;
    FloatingActionButton fab;
    String sName, sLocation, sDescription;

    public ContactsAppFragmentOne() {
        // Required empty public constructor
    }

//Then hii onCreateView ndo iko na method ya kucreate listview

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_contacts_app_fragment_one, container, false);

        //Hii ni floating action button, iko kwa corner ya bottom right ukitaka kuadd contact mpya
        //Btw ukiadd hizo lines zinaongezeka sijui mbona haiget content
        fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment addContact = new AddContact();
                addContact.show(getFragmentManager(), "AddContacts");
            }
        });
//Hapa unaconnect na fire
        //DatabaseReference a = mDatabaseReference.child("coretec-contacts");
        final FirebaseListAdapter<Sacco> adapter = new FirebaseListAdapter<Sacco>(
                getActivity(),
                Sacco.class,
                android.R.layout.two_line_list_item,
                mDatabaseReference
        ) {
            @Override
            protected void populateView(View view, Sacco sacco, int i) {
                Log.i("POPULATE", "Break");
                ((TextView)view.findViewById(android.R.id.text1)).setText(sacco.getName());
                ((TextView)view.findViewById(android.R.id.text2)).setText(sacco.getNumber());
            }


        };
        contactList = (ListView) view.findViewById(R.id.listview_contacts);
        ln = (LinearLayout)view.findViewById(R.id.linImages);

        contactList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                ln.setVisibility(View.VISIBLE);
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                ln.setVisibility(View.GONE);
            }
        });



        contactList.setAdapter(adapter);
        //contactList.setOnItemClickListener();
        contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sacco sacco = (Sacco) parent.getItemAtPosition(position);
                saccoName = sacco.getName();
                saccoLocation = sacco.getLocation();
                saccoDescription = sacco.getDescription();
                saccoNumber = sacco.getNumber();
                //Store the name of the sacco that was clicked in variable saccoName

                //pass the value on saccoName to the onFragmentInteractionListenerOne
                mListener.onFragmentInteractionOne(saccoName, saccoLocation, saccoDescription, saccoNumber);

            }
        });


        return view;
    }



    // TODO: Rename method, update argument and hook method into UI event
   /* public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListenerOne) {
            mListener = (OnFragmentInteractionListenerOne) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListenerOne {
        void onFragmentInteractionOne(String name, String location, String description, String number);
    }




}

