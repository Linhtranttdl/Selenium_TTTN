package Railway.Timetable;

import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC46 extends TestBase {
    HomePage homePage = new HomePage();

    @Test(description = "TC46 - Verify that \"check price\" link can navigate to Ticket Price tab")

    public void TC46() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to Timetable page");
        System.out.println("Step 3: Click on \"check price\" link of any train");
        System.out.println("Step 4: Observe tab is navigated ");
        homePage.goToTimeTablePage();

        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Train Timetable";
        Assert.assertEquals(actualMsg, expectedMsg, "Timetable page is not displayed as expected");
    }
}



