package com.mobileproto.mommyapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Chloe Local on 11/14/13.
 */
public class TaskList implements Parcelable {

    TaskList(){

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
