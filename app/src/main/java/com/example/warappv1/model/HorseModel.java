package com.example.warappv1.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.warappv1.R;

import java.util.ArrayList;

public class HorseModel implements Parcelable {

    private int horseImage;
    private String horseName;
    private String horseBreed;
    private float horseRating;



    private static ArrayList<HorseModel> horseModels;

    public HorseModel(int horseImage, String horseName, String horseBreed, float horseRating) {
        this.horseImage = horseImage;
        this.horseName = horseName;
        this.horseBreed = horseBreed;
        this.horseRating = horseRating;
    }

    protected HorseModel(Parcel in) {
        horseImage = in.readInt();
        horseName = in.readString();
        horseBreed = in.readString();
        horseRating = in.readFloat();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(horseImage);
        dest.writeString(horseName);
        dest.writeString(horseBreed);
        dest.writeFloat(horseRating);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<HorseModel> CREATOR = new Creator<HorseModel>() {
        @Override
        public HorseModel createFromParcel(Parcel in) {
            return new HorseModel(in);
        }

        @Override
        public HorseModel[] newArray(int size) {
            return new HorseModel[size];
        }
    };

    public int getHorseImage() {
        return horseImage;
    }

    public void setHorseImage(int horseImage) {
        this.horseImage = horseImage;
    }

    public String getHorseName() {
        return horseName;
    }

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public String getHorseBreed() {
        return horseBreed;
    }

    public void setHorseBreed(String horseBreed) {
        this.horseBreed = horseBreed;
    }

    public float getHorseRating() {
        return horseRating;
    }

    public void setHorseRating(float horseRating) {
        this.horseRating = horseRating;
    }

    public static synchronized ArrayList<HorseModel> getHorseList(){
        if (horseModels == null){
            horseModels = new ArrayList<>();
            horseModels.add(new HorseModel(R.drawable.horse1,"Horse1","Breed1",3.5f));
            horseModels.add(new HorseModel(R.drawable.horse2,"Horse2","Breed2",2.5f));
            horseModels.add(new HorseModel(R.drawable.horse3,"Horse3","Breed3",4.5f));
            horseModels.add(new HorseModel(R.drawable.horse4,"Horse4","Breed4",4));
            horseModels.add(new HorseModel(R.drawable.horse5,"Horse5","Breed5",5));
            horseModels.add(new HorseModel(R.drawable.horse6,"Horse6","Breed6",2));
            horseModels.add(new HorseModel(R.drawable.horse7,"Horse7","Breed7",1));
        }
        return horseModels;


    }

}
