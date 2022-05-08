package Railway.Login;

import Common.Constant;
import Common.Utilities;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import Railway.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC32 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test(description = "TC32 - Verify that user cannot login with an incorrect password")

    public void TC32() {
        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Click on \"Login\" tab");
        homePage.goToLoginPage();

        System.out.println("Step 3: Enter incorrect email format to the fields");
        System.out.println("Step 4: Enter password of any account");
        System.out.println("Step 5: Click on Login button");
        loginPage.login(Constant.USERNAME, Utilities.getPasswordRandom());

        String actualMsg = loginPage.getErrorLoginInvalidUsernameOrPassword();
        String expectedMsg = "Invalid username or password. Please try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Error login function");
    }
}

