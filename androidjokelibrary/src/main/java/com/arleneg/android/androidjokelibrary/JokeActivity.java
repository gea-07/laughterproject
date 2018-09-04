package com.arleneg.android.androidjokelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_ID = "jokeID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String joke = intent.getStringExtra(JOKE_ID);
        if (joke != null) {
            JokeActivityFragment jokeFragment = (JokeActivityFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragment);
            jokeFragment.setJoke(joke);
        }
    }

}
