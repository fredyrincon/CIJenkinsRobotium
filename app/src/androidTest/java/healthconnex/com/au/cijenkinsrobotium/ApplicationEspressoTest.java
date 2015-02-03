package healthconnex.com.au.cijenkinsrobotium;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.android.support.test.deps.guava.base.Predicates.not;

/**
 * Created by frincon on 3/02/2015.
 */
public class ApplicationEspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public ApplicationEspressoTest() {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testValidateIfLabelVisible() {
        ViewInteraction helloWorldText;
        helloWorldText = onView(withText("Hello world!")); // Find the text

        helloWorldText.check(ViewAssertions.matches(isDisplayed())); // Assert text is displayed
    }

    //Task of click on a button to open another activity and get back
   /* public void testEspressoPushNextActivity() throws  Exception {

        // check that we have the right activity
        solo.assertCurrentActivity("wrong activity", MainActivity.class);

        // Click a button which will start a new Activity
        // Here we use the ID of the string to find the right button
        onView((withId(R.id.buttonNext))).perform(click());

        // Validate that the Activity is the correct one
        ViewInteraction helloWorldChangedText;
        helloWorldChangedText = onView(withText("Hello world!")); // Find the text

        helloWorldChangedText.check(ViewAssertions.matches(not(ViewAssertions.matches(isDisplayed()))); // Assert text is displayed
        Espresso.onView(ViewMatchers.withId(R.id.action_logout)).check(ViewAssertions.matches(not(ViewMatchers.isDisplayed())));


        solo.assertCurrentActivity("wrong activity", DetailActivity.class);

        pressBack();
    }

    //Task of click on a button to open another activity and get back
    public void testEspressoPushSecondNextActivity() throws  Exception {

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
    public void testEspressoChangeLabelData() throws Exception {

        ViewInteraction helloWorldText;
        helloWorldText = onView(withText("Hello world!")); // Find the text

        onView((withId(R.id.buttonChangeText))).perform(click());

        ViewInteraction helloWorldChangedText;
        helloWorldChangedText = onView(withText("Testing Android Rocks!")); // Find the text

        helloWorldChangedText.check(ViewAssertions.matches(isDisplayed())); // Assert text is displayed
    }
}