package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.widget.Toast;

import com.example.felip.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Snippet from https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
 */

class JokeAsyncTask extends AsyncTask<IJokeFetcher, Void, String> {
    private static MyApi myApiService = null;
    IJokeFetcher callback;

    @Override
    protected String doInBackground(IJokeFetcher... params) {
        callback = params[0];
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://" + BuildConfig.PROJECT_ID + ".appspot.com/_ah/api/");
            // end options for devappserver
            Log.i("Joke App", "Url: " + builder.getRootUrl());
            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        callback.deliverJoke(result);
    }
}

