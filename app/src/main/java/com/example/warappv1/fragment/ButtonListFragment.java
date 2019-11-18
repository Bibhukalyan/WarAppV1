package com.example.warappv1.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.warappv1.R;
import com.example.warappv1.utils.AppConstants;


public class ButtonListFragment extends Fragment {

    private ButtonClickListener mListener;
    private Button btnShowHorse;

    public ButtonListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_button_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initViews(view);
        initClickListener();

    }


    private void initViews(View view) {
        btnShowHorse = view.findViewById(R.id.btn_show_horses);

    }


    private void initClickListener() {
        btnShowHorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(AppConstants.HORSE_SELECTED);
            }
        });

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int buttonId) {
        if (mListener != null) {
            mListener.onButtonClick(buttonId);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ButtonClickListener) {
            mListener = (ButtonClickListener) context;
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

    public interface ButtonClickListener {
        // TODO: Update argument type and name
        void onButtonClick(int buttonId);
    }
}
