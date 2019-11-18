package com.example.warappv1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.warappv1.R;

import java.util.ArrayList;

public class GunModel implements Parcelable {

    private int gunImage;
    private String gunName;

    private static ArrayList<GunModel> gunModels;

    public GunModel(int gunImage, String gunName) {
        this.gunImage = gunImage;
        this.gunName = gunName;
    }

    protected GunModel(Parcel in) {
        gunImage = in.readInt();
        gunName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(gunImage);
        dest.writeString(gunName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GunModel> CREATOR = new Creator<GunModel>() {
        @Override
        public GunModel createFromParcel(Parcel in) {
            return new GunModel(in);
        }

        @Override
        public GunModel[] newArray(int size) {
            return new GunModel[size];
        }
    };

    public int getGunImage() {
        return gunImage;
    }

    public void setGunImage(int gunImage) {
        this.gunImage = gunImage;
    }

    public String getGunName() {
        return gunName;
    }

    public void setGunName(String gunName) {
        this.gunName = gunName;
    }

    public static synchronized ArrayList<GunModel> getGunList(){
        if (gunModels == null){
            gunModels = new ArrayList<>();
            gunModels.add(new GunModel(R.drawable.gun1,"Gun1"));
            gunModels.add(new GunModel(R.drawable.gun2,"Gun2"));
            gunModels.add(new GunModel(R.drawable.gun3,"Gun3"));
            gunModels.add(new GunModel(R.drawable.gun4,"Gun4"));
            gunModels.add(new GunModel(R.drawable.gun5,"Gun5"));
            gunModels.add(new GunModel(R.drawable.gun6,"Gun6"));
            gunModels.add(new GunModel(R.drawable.gun7,"Gun7"));
        }

        return gunModels;
    }
}
