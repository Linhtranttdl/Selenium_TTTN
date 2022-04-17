package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage {
    //Locator
    private final By tabContact = By.xpath("//a[@href='/Page/Contact.cshtml']");

    //Element
    public WebElement getTabContact () {return Constant.WEBDRIVER.findElement(tabContact);}

    //Method
    public void gotoContactPage(){
        this.getTabContact().click();
    }
}
