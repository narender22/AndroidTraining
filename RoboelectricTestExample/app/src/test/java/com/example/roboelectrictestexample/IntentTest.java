package com.example.roboelectrictestexample;

import android.content.Intent;
import android.widget.Button;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowToast;

@RunWith(RobolectricTestRunner.class)
public class IntentTest {
    private MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void buttonClickShouldShowToast() {
        Button button = activity.findViewById(R.id.button);
        button.performClick();

        Intent intent = Shadows.shadowOf(activity).peekNextStartedActivity();
        Assert.assertEquals(SecondActivity.class.getCanonicalName(), intent.getComponent().getClassName());
    }

    @Test
    public void testButtonClickShouldShowToast() {
        MainActivity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        Button toastButton = activity.findViewById(R.id.showToast);

        Assert.assertNotNull(toastButton);
        toastButton.performClick();
        Assert.assertEquals(ShadowToast.getTextOfLatestToast(), "some toast");
    }

}
