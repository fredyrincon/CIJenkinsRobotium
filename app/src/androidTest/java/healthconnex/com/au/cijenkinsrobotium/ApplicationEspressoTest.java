package healthconnex.com.au.cijenkinsrobotium;

import android.support.test.espresso.ViewAssertion;
import android.test.ActivityInstrumentationTestCase2;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

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

    public void testListGoesOverTheFold() {
        onView(withText("Hello world")).check((ViewAssertion) isDisplayed());
    }
}