package com.udacity.gradle.builditbigger.paidversion;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;

import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.jokedisplay.JokeDisplayActivity;

public class MainPaidActivity extends MainActivity {

    private Button fetchJokeButton;
    private View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paid);

        fetchJokeButton = findViewById(R.id.fetch_joke_button);
        fetchJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchJoke();
            }
        });

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
    }

    public void fetchJoke() {
        progressBar.setVisibility(View.VISIBLE);

        new EndpointsAsyncTask().execute();
    }

    @Override
    public void onEndpointResponseReceived(String response) {
        progressBar.setVisibility(View.GONE);

        Intent intent = new Intent(MainPaidActivity.this, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.PARAM_JOKE, response);
        startActivity(intent);
    }

    @Override
    public void onEndpointResponseError() {
        progressBar.setVisibility(View.GONE);

        Snackbar.make(fetchJokeButton, getString(R.string.error_backend),
                Snackbar.LENGTH_LONG).show();
    }
}
