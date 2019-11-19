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
import com.example.warappv1.adapter.AmuListAdapter;
import com.example.warappv1.adapter.GunListAdapter;
import com.example.warappv1.adapter.HorseListAdapter;
import com.example.warappv1.model.AmmunationModel;
import com.example.warappv1.model.GunModel;
import com.example.warappv1.model.HorseModel;
import com.example.warappv1.utils.AppConstants;

import java.util.ArrayList;

public class ButtonListFragment extends BaseFragment {

    //private ButtonClickListener mListener;
    private Button btnShowHorse,btnShowGuns,btnCapureNewLife,btnAmunation;
    private RecyclerView rvHorseList,rvGunList,rvAmmunationList;
    private ArrayList<HorseModel> horseModels;
    private ArrayList<GunModel> gunModels;
    private ArrayList<AmmunationModel> ammunationModels;

    public ButtonListFragment(ArrayList<HorseModel> horseModels, ArrayList<GunModel> gunModels,ArrayList<AmmunationModel> ammunationModels) {
        // Required empty public constructor
        this.horseModels = new ArrayList<>();
        this.gunModels = new ArrayList<>();
        this.ammunationModels = new ArrayList<>();
        if (horseModels != null){
            this.horseModels.addAll(horseModels);
        }
        if (gunModels != null)
            this.gunModels.addAll(gunModels);
        if (ammunationModels != null)
            this.ammunationModels.addAll(ammunationModels);
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
        btnAmunation = view.findViewById(R.id.btn_show_amu);
        btnCapureNewLife = view.findViewById(R.id.btn_capture_image);
        rvHorseList = view.findViewById(R.id.rv_horse_list);
        rvGunList = view.findViewById(R.id.rv_gun_list);
        rvAmmunationList = view.findViewById(R.id.rv_amu_list);
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

        btnCapureNewLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(AppConstants.CAPTURE_NEW_LIFE_SELECTED);
            }
        });

        btnAmunation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonPressed(AppConstants.AMMUNATION_SELECTED);
            }
        });



        rvHorseList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rvHorseList.setAdapter(new HorseListAdapter(this,horseModels));

        rvGunList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rvGunList.setAdapter(new GunListAdapter(this,gunModels));

        rvAmmunationList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        rvAmmunationList.setAdapter(new AmuListAdapter(this,ammunationModels));
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
