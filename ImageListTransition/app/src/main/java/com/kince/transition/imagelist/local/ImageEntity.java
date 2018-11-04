package com.kince.transition.imagelist.local;

import android.os.Parcel;
import android.os.Parcelable;

public class ImageEntity implements Parcelable {

    public String title;
    public int url;

    public ImageEntity(String title, int url) {
        this.title = title;
        this.url = url;
    }

    protected ImageEntity(Parcel in) {
        title = in.readString();
        url = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ImageEntity> CREATOR = new Creator<ImageEntity>() {
        @Override
        public ImageEntity createFromParcel(Parcel in) {
            return new ImageEntity(in);
        }

        @Override
        public ImageEntity[] newArray(int size) {
            return new ImageEntity[size];
        }
    };
}
