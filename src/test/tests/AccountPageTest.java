package tests;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class AccountPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    BasePage basePage;

    AccountPage accountPage;

    @BeforeMethod
    public void localSetUp(){
        homePage = new HomePage(getDriver());
    }
    @Test(testName = "verify order history button")
    public void test01() throws InterruptedException {
        homePage.click(homePage.signinBtn);
        basePage.sleep(2000L);
        homePage.waitForElementVisibility(loginPage.emailField);
        loginPage.sendKeys(loginPage.emailField, "test1111@test1111.com");
        homePage.waitForElementVisibility(loginPage.passwordField);
        loginPage.sendKeys(loginPage.passwordField, "qwerty123");
        loginPage.click(loginPage.signinBtn);
        WebElement[] btns = {accountPage.orderHistoryAndDetails, accountPage.myCreditSlips, accountPage.myAddresses, accountPage.myPersonalInformation, accountPage.myWishList};
        for (WebElement btn : btns) {
            Assert.assertTrue(btn.isEnabled());
        }
    }
}
