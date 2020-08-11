package com.example.criminalintent;

import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private boolean mSolved;

    public Crime(){
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public boolean getSolved(){
        return mSolved;
    }

    public void setSolved(boolean s){
        mSolved = s;
    }
}
