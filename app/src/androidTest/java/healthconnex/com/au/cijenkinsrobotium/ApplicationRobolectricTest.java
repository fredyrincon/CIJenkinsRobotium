package healthconnex.com.au.cijenkinsrobotium;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import junit.framework.Assert;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.robolectric.Robolectric.buildActivity;
import static org.robolectric.Robolectric.shadowOf;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.util.ActivityController;

/**
 * Created by frincon on 2/02/2015.
 */
@RunWith(RobolectricTestRunner.class)
public class ApplicationRobolectricTest  {

    private MainActivity activity;

    private Button btnNext;
    private Button btnSecond;
    private Button btnChange;
    private TextView textViewLabel;
    private SecondDetailActivity secondActivity;
    private DetailActivity detailActivity;

    //private final ActivityController<MainActivity> controller = buildActivity(MainActivity.class);

    @Before
    public void setUp() {
        activity = Robolectric.buildActivity(MainActivity.class).create().visible().get();
        btnNext = (Button) activity.findViewById(R.id.buttonNext);
        btnSecond = (Button) activity.findViewById(R.id.buttonSecondNext);
        btnChange = (Button) activity.findViewById(R.id.buttonChangeText);
        textViewLabel = (TextView) activity.findViewById(R.id.textView);
    }

    // Sanity check for the layout
    @Test
    public void shouldHaveButtonThatSaysShowNext() throws Exception{
        // Verifies the button and text field exist
        assertThat(btnNext, notNullValue());
        assertNotNull(textViewLabel);
        // Verifies the text of the button
        assertThat((String) btnNext.getText(), equalTo("Show next"));
    }

    //Task of click on a button to open another activity and get back
    public void testRoboelectricPushNextActivity() throws  Exception {
        //Click the button
        btnNext.performClick();

        // Construct Shadow versions of Activity and Intent
        Intent startedIntent = shadowOf(activity).getNextStartedActivity();

        // Verify the intent was started with correct result extra
        //assertThat(resultValue, equalTo(startedIntent.getStringExtra("result")));
        assertThat(startedIntent.getComponent().getClassName(), equalTo(DetailActivity.class.getName()));
    }

    //Task of click on a button to open another activity and get back
    public void testRoboelectricPushSecondNextActivity() throws  Exception {

        //click the button
        btnChange.performClick();

        // Construct Shadow versions of Activity and Intent
        Intent startedIntent = shadowOf(activity).getNextStartedActivity();

        // Verify the intent was started with correct result extra
        //assertThat(resultValue, equalTo(startedIntent.getStringExtra("result")));
        assertThat(startedIntent.getComponent().getClassName(), equalTo(SecondDetailActivity.class.getName()));
    }

    //Task to change the label of the textView
    public void testRoboelectricChangeLabelData() throws Exception {
        btnChange.performClick();
        String resultsText = textViewLabel.getText().toString();
        assertThat(resultsText, equalTo("Testing Android Rocks!"));
    }

    //Testing lifecycle
    public void testRoboelectricLifeCycle() throws  Exception {
        Activity activity = buildActivity(MainActivity.class).create().start().resume().visible().get();
    }

    @Test
    public void testShouldFail() {
        Assert.assertTrue(Boolean.FALSE);
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
