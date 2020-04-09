package com.example.workshopfacilitationguide;

import android.os.Parcel;
import android.os.Parcelable;

class ExampleItem implements Parcelable {
    private int mImageResource;
    private String mText1;
    private String mText2;
    private String mText3;

    ExampleItem(int imageResource, String text1, String text2, String text3) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
        mText3 = text3;
    }

    protected ExampleItem(Parcel in) {
        mImageResource = in.readInt();
        mText1 = in.readString();
        mText2 = in.readString();
        mText3 = in.readString();
    }

    public static final Creator<ExampleItem> CREATOR = new Creator<ExampleItem>() {
        @Override
        public ExampleItem createFromParcel(Parcel in) {
            return new ExampleItem(in);
        }

        @Override
        public ExampleItem[] newArray(int size) {
            return new ExampleItem[size];
        }
    };

    int getImageResource() {
        return mImageResource;
    }

    String getText1() {
        return mText1;
    }

    String getText2() {
        return mText2;
    }

    String getText3() {
        return mText3;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mImageResource);
        dest.writeString(mText1);
        dest.writeString(mText2);
        dest.writeString(mText3);
    }
}
