package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import ninja.berbert.androidjokelib.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements IJokeFetcher {

    ProgressBar pbLoading;
    Button btJoke;

    String joke;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        pbLoading = (ProgressBar) root.findViewById(R.id.pb_loading);
        btJoke = (Button) root.findViewById(R.id.bt_joke);
        btJoke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchJoke();
            }
        });

        return root;
    }


    public void fetchJoke() {
        pbLoading.setVisibility(View.VISIBLE);
        btJoke.setEnabled(false);
        new JokeAsyncTask().execute(new Pair<IJokeFetcher, Boolean>(this, false));
    }


    @Override
    public void deliverJoke(String joke) {
        pbLoading.setVisibility(View.GONE);
        btJoke.setEnabled(true);
        this.joke = joke;
        goToJokeActv();

    }

    private void goToJokeActv() {
        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_JOKE, joke);
        startActivity(intent);
    }
}
