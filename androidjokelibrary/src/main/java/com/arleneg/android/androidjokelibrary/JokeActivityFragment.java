package com.arleneg.android.androidjokelibrary;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    private String mJokeString;
    private TextView mJokeTextView;

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        mJokeTextView = view.findViewById(R.id.joke_textview);
        return view;

    }

    public void setJoke(String data) {
        mJokeString = data;
        if (mJokeString != null) {
            mJokeTextView.setText(mJokeString);
        }
    }
}
