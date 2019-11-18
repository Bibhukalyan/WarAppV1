package com.example.warappv1.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.warappv1.R;
import com.example.warappv1.adapter.GunListAdapter;
import com.example.warappv1.adapter.HorseListAdapter;
import com.example.warappv1.model.GunModel;
import com.example.warappv1.model.HorseModel;
import com.example.warappv1.utils.AppConstants;

import java.util.ArrayList;


public class ButtonListFragment extends BaseFragment {

    //private ButtonClickListener mListener;
    private Button btnShowHorse,btnShowGuns;
    private RecyclerView rvHorseList,rvGunList;
    private ArrayList<HorseModel> horseModels;
    private ArrayList<GunModel> gunModels;

    public ButtonListFragment(ArrayList<HorseModel> horseModels, ArrayList<GunModel> gunModels) {
        // Required empty public constructor
        this.horseModels = new ArrayList<>();
        this.gunModels = new ArrayList<>();
        if (horseModels != null){
            this.horseModels.addAll(horseModels);
        }
        if (gunModels != null)
            this.gunModels.addAll(gunModels);
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
        btnShowGuns = view.findViewById(R.id.btn_show_guns);
        rvHorseList = view.findViewById(R.id.rv_horse_list);
        rvGunList = view.findViewById(R.id.rv_gun_list);

        //horseModels = new ArrayList<>();
    }


    private void initClickListener() {
        btnShowHorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(AppConstants.HORSE_SELECTED);
            }
        });
        btnShowGuns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(AppConstants.GUN_SELECTED);
            }
        });



        rvHorseList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rvHorseList.setAdapter(new HorseListAdapter(this,horseModels));

        rvGunList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rvGunList.setAdapter(new GunListAdapter(this,gunModels));
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(int buttonId) {
        if (buttonClickListener != null) {
            buttonClickListener.onButtonClick(buttonId);
        }
    }

    /*@Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }*/


    @Override
    public void onDetach() {
        super.onDetach();
        buttonClickListener = null;
    }


}
