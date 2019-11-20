package com.example.warappv1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.warappv1.R;
import com.example.warappv1.fragment.BaseFragment;
import com.example.warappv1.fragment.ItemListFragment;
import com.example.warappv1.model.HorseModel;
import com.example.warappv1.utils.AppConstants;

import java.util.ArrayList;

public class HorseListAdapter extends RecyclerView.Adapter<HorseListAdapter.ViewHolder> {

    private ArrayList<HorseModel> horseList;
    private LayoutInflater inflater;
    //private Context mcontext;
    private BaseFragment baseFragment;

    public HorseListAdapter(BaseFragment fragment, ArrayList<HorseModel> horseList) {
        inflater = LayoutInflater.from(fragment.getContext());
        this.horseList = horseList;
        //this.mcontext = context;
        this.baseFragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_horse_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (horseList != null && horseList.get(position) != null){
            holder.ivHorse.setImageResource(horseList.get(position).getHorseImage());
            holder.tvHorseName.setText(horseList.get(position).getHorseName());
            holder.tvHorseBreed.setText(horseList.get(position).getHorseBreed());
            holder.horseRating.setRating(horseList.get(position).getHorseRating());
            holder.containerLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(baseFragment.getContext(), "Clciked", Toast.LENGTH_SHORT).show();
                    if (baseFragment instanceof ItemListFragment)
                        ((ItemListFragment) baseFragment).onItemSelected(position, AppConstants.HORSE_SELECTED);

                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return horseList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHorse;
        TextView tvHorseName,tvHorseBreed;
        View containerLayout;
        RatingBar horseRating;

        public ViewHolder(View itemView) {
            super(itemView);
            containerLayout = itemView;//itemView.findViewById(R.id.container_layout);
            ivHorse = itemView.findViewById(R.id.ivHorse);
            tvHorseName = itemView.findViewById(R.id.tvHorseName);
            tvHorseBreed = itemView.findViewById(R.id.tv_horse_breed);
            horseRating = itemView.findViewById(R.id.rb_horse_rating);
        }


    }



}
