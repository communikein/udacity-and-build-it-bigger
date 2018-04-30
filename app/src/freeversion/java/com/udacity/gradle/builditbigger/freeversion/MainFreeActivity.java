package com.udacity.gradle.builditbigger.freeversion;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;
import com.udacity.gradle.builditbigger.jokedisplay.JokeDisplayActivity;

public class MainFreeActivity extends MainActivity {

    private Button fetchJokeButton;
    public InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_free);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        fetchJokeButton = findViewById(R.id.fetch_joke_button);
        fetchJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fetchJoke();
            }
        });

        AdView mAdView = findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }

    public void fetchJoke() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();

            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {}

                @Override
                public void onAdFailedToLoad(int errorCode) {}

                @Override
                public void onAdOpened() {}

                @Override
                public void onAdLeftApplication() {}

                @Override
                public void onAdClosed() {
                    new EndpointsAsyncTask().execute();
                }
            });
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

    @Override
    public void onEndpointResponseReceived(String response) {
        Intent intent = new Intent(MainFreeActivity.this, JokeDisplayActivity.class);
        intent.putExtra(JokeDisplayActivity.PARAM_JOKE, response);
        startActivity(intent);
    }

    @Override
    public void onEndpointResponseError() {
        Snackbar.make(fetchJokeButton, getString(R.string.error_backend),
                Snackbar.LENGTH_LONG).show();
    }
}
