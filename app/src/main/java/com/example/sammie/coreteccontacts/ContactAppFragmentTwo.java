package com.example.sammie.coreteccontacts;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactAppFragmentTwo extends Fragment {

    private OnFragmentInteractionListener mListener;
    TextView tvSaccoName, tvSaccoLocation, tvSaccoDescription, tvSaccoNumber;


    public ContactAppFragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_app_fragment_two, container, false);
        tvSaccoName = (TextView) view.findViewById(R.id.sacco_name);
        tvSaccoLocation = (TextView) view.findViewById(R.id.sacco_location);
        tvSaccoDescription = (TextView) view.findViewById(R.id.sacco_description);
        tvSaccoNumber = (TextView) view.findViewById(R.id.sacco_number_display);

        Bundle args = getArguments();
        String saccoName = args.getString("SaccoName");
        String saccoLocation = args.getString("SaccoLocation");
        String saccoDescription = args.getString("SaccoDescription");
        String saccoNumber = args.getString("SaccoNumber");
        tvSaccoName.setText(saccoName);
        tvSaccoLocation.setText(saccoLocation);
        tvSaccoDescription.setText(saccoDescription);
        tvSaccoNumber.setText(saccoNumber);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListenerOne");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
