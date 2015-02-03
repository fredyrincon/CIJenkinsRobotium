package healthconnex.com.au.cijenkinsrobotium;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.util.ActivityController;

import java_cup.Main;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.robolectric.Robolectric.buildActivity;
import static org.robolectric.Robolectric.shadowOf;

/**
 * Created by frincon on 2/02/2015.
 */
@RunWith(RobolectricTestRunner.class)
public class ApplicationRobolectricTest  {

    private MainActivity activity;

    private final ActivityController<MainActivity> controller = buildActivity(MainActivity.class);

    @Before
    public void setUp() {
    }

    @Test
    public void testShouldFail() {
        Assert.assertTrue(Boolean.FALSE);
    }


   /* //Task of click on a button to open another activity and get back
    public void testRoboelectricPushNextActivity() throws  Exception {

        /*Activity activity = Robolectric.buildActivity(MainActivity.class).create().get();
        Button pressNextButton = (Button) activity.findViewById(R.id.buttonNext);
        pressNextButton.performClick();

        Intent expectedIntent = new Intent(activity, DetailActivity.class);
        assertThat(shadowOf(activity).getNextStartedActivity()).isEqualTo(expectedIntent);

        solo.goBack();*/


       /* MainActivity activity = controller.create().start().resume().get();
        activity.findViewById(R.id.buttonNext).performClick();

        Intent expectedIntent = new Intent(activity, MainActivity.class);
        assertThat(shadowOf(activity).getNextStartedActivity()).isEqualTo(expectedIntent);
    }

    //Task of click on a button to open another activity and get back
    public void testRoboelectricPushSecondNextActivity() throws  Exception {

        // check that we have the right activity
        solo.assertCurrentActivity("wrong activity", MainActivity.class);

        // Click a button which will start a new Activity
        // Here we use the ID of the string to find the right button
        solo.clickOnButton(solo.getString(R.string.button2));

        // Validate that the Activity is the correct one
        solo.assertCurrentActivity("wrong activity", SecondDetailActivity.class);

        solo.goBack();
    }*/

    //Task to change the label of the textView
    public void testRoboelectricChangeLabelData() throws Exception {
        Activity activity = Robolectric.buildActivity(MainActivity.class).create().get();

        Button pressChangeLabel = (Button) activity.findViewById(R.id.buttonChangeText);
        TextView results = (TextView) activity.findViewById(R.id.textView);

        pressChangeLabel.performClick();
        String resultsText = results.getText().toString();
        assertThat(resultsText, equalTo("Testing Android Rocks!"));
    }

    //Testing lifecycle
    public void testRoboelectricLifeCycle() throws  Exception {
        Activity activity = Robolectric.buildActivity(MainActivity.class).create().start().resume().visible().get();
    }

    /*@Test
    public void testClickingButton_shouldChangeResultsViewText() throws Exception {
        Activity activity = buildActivity(MainActivity.class).create().get();

        Button pressMeButton = (Button) activity.findViewById(R.id.buttonChangeText);
        TextView results = (TextView) activity.findViewById(R.id.textView);

        pressMeButton.performClick();
        String resultsText = results.getText().toString();
        assertThat(resultsText, equalTo("Testing Android Rocks!"));
    }

    @Before
    public void setup()  {
        activity = buildActivity(MainActivity.class).create().get();
    }

    @Test
    public void testcheckActivityNotNull() throws Exception {
        assertNotNull(activity);
    }



    @Test
    public void testButtonClickShouldStartNewActivity() throws Exception
    {
        Button button = (Button) activity.findViewById(R.id.buttonSecondNext);
        button.performClick();
        Intent intent = shadowOf(activity).peekNextStartedActivity();
        assertEquals(SecondDetailActivity.class.getCanonicalName(), intent.getComponent().getClassName());
    }*/

      /*@Test
    public void clickingLogin_shouldStartDetailActivity() {
        MainActivity activity = controller.create().start().resume().get();
        activity.findViewById(R.id.buttonNext).performClick();

        Intent expectedIntent = new Intent(activity, DetailActivity.class);
        assertThat(shadowOf(activity).getNextStartedActivity()).isEqualTo(expectedIntent);
    }*/
}
