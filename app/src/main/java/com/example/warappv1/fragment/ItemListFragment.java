package com.example.warappv1.fragment;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.warappv1.R;
import com.example.warappv1.adapter.GunListAdapter;
import com.example.warappv1.adapter.HorseListAdapter;
import com.example.warappv1.model.GunModel;
import com.example.warappv1.model.HorseModel;
import com.example.warappv1.utils.AppConstants;

import java.util.ArrayList;

public class ItemListFragment extends BaseFragment {

    //private OnItemSelectedListener mListener;
    private RecyclerView rvItemsList;
    private ArrayList<HorseModel> horseModels;
    private ArrayList<GunModel> gunModels;

    public ItemListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initView(view);
        initComponent();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        switch (getArguments().getInt(AppConstants.TYPE_KEY_FOR_FRAGMENT_ARG)){

            case AppConstants.HORSE_TYPE : {
                rvItemsList.setAdapter(new HorseListAdapter(this, getArguments().<HorseModel>getParcelableArrayList(AppConstants.HORSE_LIST_KEY)));
                break;
            }
            case AppConstants.GUN_TYPE : {
                rvItemsList.setAdapter(new GunListAdapter(this, getArguments().<GunModel>getParcelableArrayList(AppConstants.GUN_LIST_KEY)));
                break;
            }
        }

    }

    private void initView(View view) {
        rvItemsList = view.findViewById(R.id.rv_list_item);
    }

    private void initComponent() {
        rvItemsList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onItemSelected(int position,int typeOfResource) {
        if (onItemSelectedListener != null) {
            //Toast.makeText(getActivity(), "position"+position+" typeofresource "+typeOfResource, Toast.LENGTH_SHORT).show();

            onItemSelectedListener.onItemSelected(position,typeOfResource);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onItemSelectedListener = null;
    }


}
