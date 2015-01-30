package healthconnex.com.au.cijenkinsrobotium;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;

import com.robotium.solo.Solo;

/**
 * Created by frincon on 30/01/2015.
 */
public class ApplicationRobotuimTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public ApplicationRobotuimTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    public void anotherTest () throws  Exception {

        // check that we have the right activity
        solo.assertCurrentActivity("wrong activity", MainActivity.class);

        // Click a button which will start a new Activity
        // Here we use the ID of the string to find the right button
        solo.clickOnButton(solo.getString(R.string.button1));

        // Validate that the Activity is the correct one
        solo.assertCurrentActivity("wrong activity", DetailActivity.class);



        /*solo.clickInList(1);

        // searchForText has a timeout of 5 seconds
        assertTrue(solo.waitForText("Android")); // Assertion
        solo.clickInList(2);
        assertTrue(solo.waitForText("iPhone")); // Assertion
        solo.clickInList(3);
        assertTrue(solo.waitForText("Blackberry")); // Assertion
        */

        solo.goBack();
       /* solo.clickOnButton("Button2");
        solo.clickOnButton("Button3");*/

        // open the menu
        /*solo.sendKey(Solo.MENU);
        solo.clickOnText("Preferences");
        solo.clickOnText("User");
        solo.clearEditText(0);
        Assert.assertTrue(solo.searchText(""));
        solo.enterText(0, "http//:www.vogella.com");
        Assert.assertTrue(solo.searchText("http//:www.vogella.com"));
        solo.goBack();*/


    }

   /* @Smoke
    public void testAudit() throws Exception {
        solo.clickOnButton("Audit");
        solo.assertCurrentActivity("Expected AuditLog activity", "AuditLog");

        // Found at least one entry
        assertTrue("No entries found", solo.searchText("May 22", true));

        solo.goBack();
    }*/
}
