package com.example.warappv1.fragment;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment {

    protected ButtonClickListener buttonClickListener;
    protected OnItemSelectedListener onItemSelectedListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof ButtonClickListener){
            buttonClickListener = (ButtonClickListener) context;
        }
        if (context instanceof OnItemSelectedListener) {
            onItemSelectedListener = (OnItemSelectedListener) context;
        }
    }

    public interface ButtonClickListener {
        // TODO: Update argument type and name
        void onButtonClick(int buttonId);
    }

    public interface OnItemSelectedListener {
        // TODO: Update argument type and name
        void onItemSelected(int position,int typeOfResource);
    }

}
