package Railway;

import Common.JsonHelper;
import Common.Utilities;
import PageObjects.*;
import com.google.gson.JsonObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;

public class TC16 extends TestBase {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "User can cancel a ticket", dataProvider = "data-provider")

    public void TC16(String departStation, String arriveStation, String seatType, String ticketAmount) throws InterruptedException, AWTException {
        System.out.println("Pre-condition: Create and activate a new account");
        homePage.open();
        homePage.goToRegisterPage();
        String username = Utilities.getEmailRandom();
        String password = Utilities.getPasswordRandom();
        String confirmPassword = password;
        String pid = Utilities.getPidRandom();
        registerPage.register(username, password, confirmPassword, pid);

        System.out.println("Step 1: Navigate to QA Railway Website");
        homePage.open();

        System.out.println("Step 2: Login with a valid account");
        homePage.goToLoginPage();
        loginPage.login(username, password);

        System.out.println("Step 3: Book a ticket");
        String departDate = Utilities.getDepartDate(10);
        bookTicketPage.bookTicketMultipleTimes(departDate, departStation, arriveStation, seatType, ticketAmount, 1);

        System.out.println("Step 4: Click on \"My ticket\" tab");
        homePage.goToMyTicketPage();

        System.out.println("Step 5: Click on \"Cancel\" button of ticket which user want to cancel.");
        String getOnClickHanding = myTicketPage.getBtnCancel().getAttribute("onclick");
        myTicketPage.cancelTicket();

        System.out.println("Step 6: Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        myTicketPage.acceptAlert();

        Assert.assertTrue((myTicketPage.isBtnCancelDisappear() == true)
                        || ((myTicketPage.isBtnCancelDisappear() == false) &&
                        (getOnClickHanding != myTicketPage.getBtnCancel().getAttribute("onclick"))),
                "Cancel button is not disappear");
    }

    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        String filePath = Utilities.getProjectPathDataJson();
        JsonObject jsonObject = JsonHelper.getJsonObject(filePath);
        JsonObject dataTTC502 = jsonObject.getAsJsonObject(this.getClass().getSimpleName());
        String departStation = dataTTC502.get("departStation").getAsString();
        String arriveStation = dataTTC502.get("arriveStation").getAsString();
        String seatType = dataTTC502.get("seatType").getAsString();
        String ticketAmount = dataTTC502.get("ticketAmount").getAsString();

        Object[][] object = new Object[][]{
                {departStation, arriveStation, seatType, ticketAmount}
        };
        return object;
    }
}
