package com.example.memorybox;

import android.os.Parcel;
import android.os.Parcelable;

public class Memory implements Parcelable {
    int rating;
    String name;
    String desc;
    int imageResourceId;





    public Memory(int rating, String name, String desc) {
        this.rating = rating;
        this.name = name;
        this.desc = desc;
    }

    public Memory(Parcel parcel) {
        // the code in this constructor needs to be specific for the type of object
        // we are receiving
        name = parcel.readString();
        rating = parcel.readInt();
        desc = parcel.readString();
        imageResourceId = parcel.readInt();
    }

    public Memory() {
        rating = 0;
        name = "";
        desc = "";
        imageResourceId = 0;
    }

    // this code is needed for the Food class to work with Parcelable
    public static final Parcelable.Creator<Memory> CREATOR = new
            Parcelable.Creator<Memory>() {

                @Override
                public Memory createFromParcel(Parcel parcel) {
                    return new Memory(parcel);
                }

                @Override
                public Memory[] newArray(int size) {
                    return new Memory[0];
                }
            };

    /**
     * This is what is used when we send the Food object through an intent
     * It is also a method that is part of the Parceable interface and is needed
     * to set up the object that is being sent.  Then, when it is received, the
     * other Food constructor that accepts a Parcel reference can "unpack it"
     *
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(rating);
        dest.writeString(desc);
        dest.writeInt(imageResourceId);
    }

    public String toString() {
        return this.name;
    }

    @Override
    public int describeContents() {
        return 0;
    }



    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
