package com.example.workshopfacilitationguide;

class ExampleItem {
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
}
