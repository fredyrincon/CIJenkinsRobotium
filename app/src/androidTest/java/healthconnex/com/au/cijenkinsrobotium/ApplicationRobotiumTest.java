package healthconnex.com.au.cijenkinsrobotium;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.Smoke;

import com.robotium.solo.Solo;
import com.squareup.spoon.Spoon;

import org.junit.Assert;

/**
 * Created by frincon on 30/01/2015.
 */
public class ApplicationRobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity activity;
    private Solo solo;

    public ApplicationRobotiumTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        solo = new Solo(getInstrumentation(), getActivity());
        activity = getActivity();
    }

    //Task of click on a button to open another activity and get back
    public void testPushNextActivity() throws  Exception {

        solo.takeScreenshot();

        Spoon.screenshot(activity, "initial_state");

        // check that we have the right activity
        solo.assertCurrentActivity("wrong activity", MainActivity.class);

        // Click a button which will start a new Activity
        // Here we use the ID of the string to find the right button
        solo.clickOnButton(solo.getString(R.string.button1));

        Spoon.screenshot(activity, "click_button");

        // Validate that the Activity is the correct one
        solo.assertCurrentActivity("wrong activity", DetailActivity.class);

        solo.takeScreenshot();

        solo.goBack();
    }

    //Task of click on a button to open another activity and get back
    public void testPushSecondNextActivity() throws  Exception {

        solo.takeScreenshot();

        // check that we have the right activity
        solo.assertCurrentActivity("wrong activity", MainActivity.class);

        // Click a button which will start a new Activity
        // Here we use the ID of the string to find the right button
        solo.clickOnButton(solo.getString(R.string.button2));

        // Validate that the Activity is the correct one
        solo.assertCurrentActivity("wrong activity", SecondDetailActivity.class);

        solo.takeScreenshot();

        solo.goBack();
    }

    //Task to change the label of the textView
    public void testChangeLabelData() throws Exception {

        solo.takeScreenshot();

        solo.clickOnButton(solo.getString(R.string.button3));
        //Assert.assertTrue(solo.searchText("Testing Android Rocks!"));

        assertTrue("No Text found in the activity", solo.searchText("Testing Android Rocks!", true));

        solo.takeScreenshot();
    }




    /*
    * public void test_login(){
     solo.enterText(0,username);
     solo.enterText(1,password);
     solo.clickOnButton("Login");
     assertTrue(solo.searchText("Please wait. Logging in."));
     solo.waitForActivity("com.pointabout.personal.MainTabActivity", 3000);
     solo.assertCurrentActivity("The activity should be Main Tab", "MainTabActivity");
     solo.sendKey(Solo.MENU);
     solo.clickOnText("Logout");
     solo.waitForText("Are you sure you want to log out");
     solo.clickOnButton("Logout");
     solo.waitForText("You have been logged out of Personal.");
     */

    /**
     *  public void testPreferenceIsSaved() throws Exception {

     solo.sendKey(Solo.MENU);
     solo.clickOnText("More");
     solo.clickOnText("Preferences");
     solo.clickOnText("Edit File Extensions");
     Assert.assertTrue(solo.searchText("rtf"));

     solo.clickOnText("txt");
     solo.clearEditText(2);
     solo.enterText(2, "robotium");
     solo.clickOnButton("Save");
     solo.goBack();
     solo.clickOnText("Edit File Extensions");
     Assert.assertTrue(solo.searchText("application/robotium"));

     }
     */



    /*// Perform test number 1. Test function needs to be called test
    public void testAnotherTest () throws  Exception {

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

       /* solo.goBack();
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
/*

    }*/

   /* @Smoke
    public void testAudit() throws Exception {
        solo.clickOnButton("Audit");
        solo.assertCurrentActivity("Expected AuditLog activity", "AuditLog");

        // Found at least one entry
        assertTrue("No entries found", solo.searchText("May 22", true));

        solo.goBack();
    }*/

    @Override
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}
