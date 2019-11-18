package com.example.warappv1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.warappv1.fragment.ButtonListFragment;
import com.example.warappv1.fragment.ItemListFragment;
import com.example.warappv1.utils.AppConstants;

public class MainActivity extends AppCompatActivity implements ButtonListFragment.ButtonClickListener,ItemListFragment.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameForFragment,new ButtonListFragment())
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
        switch (buttonId){
            case AppConstants.HORSE_SELECTED:{
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameForFragment,new ItemListFragment())
                        .addToBackStack(null)
                .commit();
                break;
            }
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(int position, int typeOfResource) {

    }
}
