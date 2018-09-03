package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.getAJoke.GetAJoke;
import com.udacity.gradle.builditbigger.flavorspecificactivity.MainActivity;

import java.io.IOException;

// EnpointAsyncTask was adapted from
// https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/77e9910911d5412e5efede5fa681ec105a0f02ad/HelloEndpoints#2-connecting-your-android-app-to-the-backend
public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {

    private Context context;
    static private GetAJoke myApiService = null;
    public String mJokeStr;

    @Override
    protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
            GetAJoke.Builder builder = new GetAJoke.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        context = params[0];

        try {
            return myApiService.getAJoke().execute().getJoke();
        } catch (IOException e) {
            return "GCE IO Exception";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        if (result == null) {
            return;
        }
        mJokeStr = result;

        if (context != null) {
            ((MainActivity)context).showJoke(mJokeStr);
        }
    }
}