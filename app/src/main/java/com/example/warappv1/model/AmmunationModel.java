package com.example.warappv1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.warappv1.R;

import java.util.ArrayList;

public class AmmunationModel implements Parcelable {

    private int amuImage;
    private String amuName;

    private static ArrayList<AmmunationModel> amuModels;

    public AmmunationModel(int amuImage, String amuName) {
        this.amuImage = amuImage;
        this.amuName = amuName;
    }

    protected AmmunationModel(Parcel in) {
        amuImage = in.readInt();
        amuName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(amuImage);
        dest.writeString(amuName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<AmmunationModel> CREATOR = new Creator<AmmunationModel>() {
        @Override
        public AmmunationModel createFromParcel(Parcel in) {
            return new AmmunationModel(in);
        }

        @Override
        public AmmunationModel[] newArray(int size) {
            return new AmmunationModel[size];
        }
    };

    public int getAmuImage() {
        return amuImage;
    }

    public void setAmuImage(int amuImage) {
        this.amuImage = amuImage;
    }

    public String getAmuName() {
        return amuName;
    }

    public void setAmuName(String amuName) {
        this.amuName = amuName;
    }

    public static synchronized ArrayList<AmmunationModel> getAmuList(){
        if (amuModels == null){
            amuModels = new ArrayList<>();
            amuModels.add(new AmmunationModel(R.drawable.gun1,"Amu1"));
            amuModels.add(new AmmunationModel(R.drawable.gun2,"Amu2"));
            amuModels.add(new AmmunationModel(R.drawable.gun3,"Amu3"));
            amuModels.add(new AmmunationModel(R.drawable.gun4,"Amu4"));
            amuModels.add(new AmmunationModel(R.drawable.gun5,"Amu5"));
            amuModels.add(new AmmunationModel(R.drawable.gun6,"Amu6"));
            amuModels.add(new AmmunationModel(R.drawable.gun7,"Amu7"));
        }

        return amuModels;
    }
}
