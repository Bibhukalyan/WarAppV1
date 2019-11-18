package com.example.warappv1.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.warappv1.R;
import com.example.warappv1.model.GunModel;

import java.util.ArrayList;

public class GunListAdapterHorizontal extends RecyclerView.Adapter<GunListAdapterHorizontal.ViewHolder> {

    private ArrayList<GunModel> gunModels;
    private LayoutInflater inflater;
    private Activity mcontext;

    public GunListAdapterHorizontal(Context context, ArrayList<GunModel> gunModels) {
        inflater = LayoutInflater.from(context);
        this.gunModels = gunModels;
        this.mcontext = (Activity) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_horse_view_horizontal, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        if (gunModels != null && gunModels.get(position) != null){
            holder.ivHorse.setImageResource(gunModels.get(position).getGunImage());
            holder.tvHorseName.setText(gunModels.get(position).getGunName());
            /*holder.containerLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mcontext, "Clicked", Toast.LENGTH_SHORT).show();
                    mcontext.setResult(Activity.RESULT_OK,new Intent().putExtra(SelectHorseActivity.SELECTED_HORSE,horseList.get(position)));
                    mcontext.finish();
                }
            });*/
        }
    }


    @Override
    public int getItemCount() {
        return gunModels.size();
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
        }


    }



}
