package Railway.FAQ;

import PageObjects.HomePage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC33 extends TestBase {
    HomePage homePage = new HomePage();

    @Test(description = "TC33 - Verify that user can navigate to FAQ tab")

    public void TC33() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Go to FAQ page");
        homePage.goToFAQPage();

        String actualMsg = homePage.getNamePagesTitle();
        String expectedMsg = "Frequently Asked Questions";
        Assert.assertEquals(actualMsg, expectedMsg, "FAQ page is not displayed as expected");
    }
}