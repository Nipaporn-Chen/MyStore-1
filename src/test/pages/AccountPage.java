package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class AccountPage extends BasePage {
    protected WebDriver driver;

    public AccountPage(WebDriver driver){
            super(driver);
            this.driver = driver;
            PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//span[text()='Order history and details']")
    public WebElement orderHistoryAndDetails;

    @FindBy(xpath = "//span[text()='My credit slips']")
    public WebElement myCreditSlips;

    @FindBy(xpath = "//span[text()='My addresses']")
    public WebElement myAddresses;

    @FindBy(xpath = "//span[text()='My personal information']")
    public WebElement myPersonalInformation;

    @FindBy(xpath = "//span[text()='My wishlists']")
    public WebElement myWishList;
}
