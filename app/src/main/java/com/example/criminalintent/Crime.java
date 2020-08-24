package com.example.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private boolean mSolved;
    private Date mDate;
    private boolean ismSolved;

    public Crime(){
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public Date getDate(){
        return mDate;
    }

    public void setDate(Date d){
        mDate = d;
    }

    public boolean isSolved(){
        return mSolved;
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


    public void setSolved(boolean s){
        mSolved = s;
    }
}
