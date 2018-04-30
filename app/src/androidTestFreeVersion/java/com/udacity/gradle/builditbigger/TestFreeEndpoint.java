package com.udacity.gradle.builditbigger;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.freeversion.MainFreeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class TestFreeEndpoint {

    @Rule
    public ActivityTestRule<MainFreeActivity> mFreeActivityRule = new ActivityTestRule<>(MainFreeActivity.class);

    @Test
    public void testEndpoint() {
        MainActivity activity = mFreeActivityRule.getActivity();

        activity.setEndpointTestCallback(new MainActivity.EndpointTestCallback() {
            @Override
            public void onHandleResponseCalled(String response) {
                assertNotNull(response);
            }
        });

        Espresso.onView(ViewMatchers.withId(R.id.fetch_joke_button)).perform(click());
    }

}