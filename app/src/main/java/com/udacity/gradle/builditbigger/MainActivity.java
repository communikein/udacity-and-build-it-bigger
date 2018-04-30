package com.udacity.gradle.builditbigger;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements EndpointAsyncTask.EndpointTestCallback {

    public EndpointResponseCallback mResponseCallback;
    public EndpointTestCallback mTestCallback;

    public interface EndpointResponseCallback {
        void onEndpointResponseReceived(String response);
        void onEndpointResponseError();
    }

    public interface EndpointTestCallback {
        void onHandleResponseCalled(String response);
    }

    public void setEndpointResponseCallback(EndpointResponseCallback callback) {
        this.mResponseCallback = callback;
    }

    public void setEndpointTestCallback(EndpointTestCallback callback) {
        this.mTestCallback = callback;
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

    @Override
    public void onHandleResponseCalled(String response) {

    }

    @Override
    public void onEndpointResponseReceived(String response) {

    }

    @Override
    public void onEndpointResponseError() {

    }
}
