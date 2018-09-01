package com.udacity.gradle.builditbigger.backend;

import com.arleneg.android.jokerlib.Laughter;

/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;
    private String mJokeStr;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

    public void setJoke() {
        Laughter joke = new Laughter();
        mJokeStr = joke != null ? joke.getALaugh() : "";
    }
    public String getJoke() {
        return mJokeStr;
    }
}