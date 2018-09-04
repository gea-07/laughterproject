package com.udacity.gradle.builditbigger.flavorspecificactivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.arleneg.android.androidjokelibrary.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.backend.getAJoke.GetAJoke;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    private static GetAJoke myApiService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public EndpointsAsyncTask loadJokeData() {
        // Credit: Lines 32-36 were inspired by https://stackoverflow.com/questions/9119627/android-sdk-asynctask-doinbackground-not-running-subclass
        EndpointsAsyncTask jokeTask = new EndpointsAsyncTask();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            jokeTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, this);
        else
            jokeTask.execute(this);
        return jokeTask;
    }

    public void tellJoke(View view) {
        loadJokeData();
    }

    public void showJoke(String joke) {
        Toast.makeText(this, joke, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_ID, joke);
        this.startActivity(intent);
    }
}
