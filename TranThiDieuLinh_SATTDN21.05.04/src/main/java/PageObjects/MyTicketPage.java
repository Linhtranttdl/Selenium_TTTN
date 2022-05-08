package PageObjects;

import Common.Constant;
import Common.Utilities;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class MyTicketPage {

    //Locators
    private final By lblInformTheNumberOfTicketsBooked = By.xpath("//div[@id='content']//li[1]");

    private final By btnCancel = By.xpath("//tbody/tr[count(//th[text()='Operation']/preceding-sibling::th)-8]//input[@value='Cancel']");

    //Elements
    public WebElement getLblInformTheNumberOfTicketsBooked() {
        return Constant.WEBDRIVER.findElement(lblInformTheNumberOfTicketsBooked);
    }

    public WebElement getBtnCancel() {
        return Constant.WEBDRIVER.findElement(btnCancel);
    }

    //Methods
    public String getLblInformTheNumberOfTicketsBookedMsg() {
        return this.getLblInformTheNumberOfTicketsBooked().getText();
    }

    public void cancelTicket() {
        Utilities.scrollPage(getBtnCancel());
        this.getBtnCancel().click();
    }

    public boolean isBtnCancelDisappear() {
        try {
            getBtnCancel();
            return false;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return true;
        }
    }

    public void acceptAlert() throws InterruptedException, AWTException {
        Alert alert = Constant.WEBDRIVER.switchTo().alert();
        alert.accept();
    }
}
