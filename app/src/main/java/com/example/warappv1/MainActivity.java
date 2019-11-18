package com.example.warappv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.warappv1.fragment.ButtonListFragment;
import com.example.warappv1.fragment.ItemListFragment;
import com.example.warappv1.model.GunModel;
import com.example.warappv1.model.HorseModel;
import com.example.warappv1.utils.AppConstants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ButtonListFragment.ButtonClickListener,ItemListFragment.OnItemSelectedListener{

    ArrayList<HorseModel> horseModels;
    ArrayList<GunModel> gunModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
    }

    private void initViews() {

        horseModels = new ArrayList<>();
        gunModels = new ArrayList<>();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameForFragment,new ButtonListFragment(null,null))
                .commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onButtonClick(int buttonId) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ItemListFragment itemListFragment = new ItemListFragment();
        switch (buttonId){
            case AppConstants.HORSE_SELECTED:{

                Bundle horseBundle = new Bundle();
                horseBundle.putInt(AppConstants.TYPE_KEY_FOR_FRAGMENT_ARG,AppConstants.HORSE_TYPE);
                horseBundle.putParcelableArrayList(AppConstants.HORSE_LIST_KEY,HorseModel.getHorseList());
                itemListFragment.setArguments(horseBundle);

                fragmentTransaction.replace(R.id.frameForFragment,itemListFragment)
                .commit();
                break;
            }
            case AppConstants.GUN_SELECTED:{
                Bundle gunBundle = new Bundle();
                gunBundle.putInt(AppConstants.TYPE_KEY_FOR_FRAGMENT_ARG,AppConstants.GUN_TYPE);
                gunBundle.putParcelableArrayList(AppConstants.GUN_LIST_KEY, GunModel.getGunList());
                itemListFragment.setArguments(gunBundle);

                fragmentTransaction.replace(R.id.frameForFragment,itemListFragment)
                        .commit();
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(int position, int typeOfResource) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        switch (typeOfResource){

            case AppConstants.HORSE_SELECTED: {
                horseModels.add(HorseModel.getHorseList().get(position));

                break;
            }

            case AppConstants.GUN_SELECTED: {
                gunModels.add(GunModel.getGunList().get(position));

                break;
            }
        }

        fragmentTransaction.replace(R.id.frameForFragment,new ButtonListFragment(horseModels,gunModels))
                .commit();

    }
}
