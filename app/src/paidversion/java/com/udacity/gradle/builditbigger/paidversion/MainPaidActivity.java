package com.udacity.gradle.builditbigger.paidversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.R;

public class MainPaidActivity extends AppCompatActivity {

    private Button fetchJokeButton;

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

    public void fetchJoke() {
        Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
    }
}
