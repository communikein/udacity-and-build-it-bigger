package com.udacity.gradle.builditbigger.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String PARAM_JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        if (getIntent().hasExtra(PARAM_JOKE)) {
            String joke = getIntent().getStringExtra(PARAM_JOKE);

            ((TextView) findViewById(R.id.joke_textView)).setText(joke);
        }
    }

}
