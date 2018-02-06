package com.error_found.kotdroid.designa.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user12 on 6/2/18.
 */

public class ParcelableModel implements Parcelable {
  public String name;
  public int id;

    protected ParcelableModel(Parcel in) {
        name = in.readString();
        id = in.readInt();
    }

    public static final Creator<ParcelableModel> CREATOR = new Creator<ParcelableModel>() {
        @Override
        public ParcelableModel createFromParcel(Parcel in) {
            return new ParcelableModel(in);
        }

        @Override
        public ParcelableModel[] newArray(int size) {
            return new ParcelableModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(id);
    }
}
