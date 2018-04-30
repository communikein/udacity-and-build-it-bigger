package com.udacity.gradle.builditbigger;


import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.paidversion.MainPaidActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static junit.framework.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class TestEndpoint {

    @Rule
    public ActivityTestRule<MainPaidActivity> mActivityRule = new ActivityTestRule<>(MainPaidActivity.class);

    @Test
    public void testFreeEndpoint() {
        MainPaidActivity activity = mActivityRule.getActivity();
        activity.setCallback(new MainPaidActivity.EndpointTestCallback() {
            @Override
            public void onHandleResponseCalled(String response) {
                assertNotNull(response);
            }
        });

        Espresso.onView(ViewMatchers.withId(R.id.fetch_joke_button)).perform(click());
    }

}