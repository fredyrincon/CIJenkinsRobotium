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

    @Smoke
    public void testAudit() throws Exception {
        solo.clickOnButton("Audit");
        solo.assertCurrentActivity("Expected AuditLog activity", "AuditLog");

        // Found at least one entry
        assertTrue("No entries found", solo.searchText("May 22", true));

        solo.goBack();
    }
}
