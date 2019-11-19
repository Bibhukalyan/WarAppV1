package com.example.warappv1.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.warappv1.R;
import com.example.warappv1.fragment.BaseFragment;
import com.example.warappv1.fragment.ItemListFragment;
import com.example.warappv1.model.AmmunationModel;
import com.example.warappv1.model.GunModel;
import com.example.warappv1.utils.AppConstants;

import java.util.ArrayList;

public class AmuListAdapter extends RecyclerView.Adapter<AmuListAdapter.ViewHolder> {

    private ArrayList<AmmunationModel> ammunationModels;
    private LayoutInflater inflater;
    private BaseFragment fragment;

    public AmuListAdapter(BaseFragment fragment, ArrayList<AmmunationModel> ammunationModels) {
        inflater = LayoutInflater.from(fragment.getContext());
        this.ammunationModels = ammunationModels;
        this.fragment = fragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_horse_view, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (ammunationModels != null && ammunationModels.get(position) != null){
            holder.ivHorse.setImageResource(ammunationModels.get(position).getAmuImage());
            holder.tvHorseName.setText(ammunationModels.get(position).getAmuName());
            holder.containerLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(mcontext, "Clicked", Toast.LENGTH_SHORT).show();
                    //mcontext.setResult(Activity.RESULT_OK,new Intent().putExtra(MyOtherActivity.GUN_SELECTED,gunModels.get(position)));
                    //mcontext.finish();
                    ((ItemListFragment) fragment).onItemSelected(position, AppConstants.GUN_SELECTED);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        return ammunationModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHorse;
        TextView tvHorseName;
        View containerLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            containerLayout = itemView;//itemView.findViewById(R.id.container_layout);
            ivHorse = itemView.findViewById(R.id.ivHorse);
            tvHorseName = itemView.findViewById(R.id.tvHorseName);
            itemView.findViewById(R.id.rb_horse_rating).setVisibility(View.GONE);
            itemView.findViewById(R.id.tv_horse_breed).setVisibility(View.GONE);
        }


    }



}
