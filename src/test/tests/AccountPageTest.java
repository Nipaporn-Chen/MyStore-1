package tests;


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
    AccountPage accountPage;

    @BeforeMethod


    public void localSetup() {
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());
        accountPage = new AccountPage(getDriver());
        homePage.click(homePage.signinBtn);
    }


    @Test(testName = "us-8", description = "locating buttons on my personal page")
    public void test01() {


        loginPage.sendKeys(loginPage.emailField, "test1111@test1111.com");
        loginPage.sendKeys(loginPage.passwordField, "qwerty123");
        loginPage.click(loginPage.submitBtn);

        WebElement[] btns = {accountPage.orderHistoryAndDetails, accountPage.myCreditSlips, accountPage.myAddresses, accountPage.myPersonalInformation, accountPage.myWishList};
        for (WebElement btn : btns) {
            Assert.assertTrue(btn.isEnabled());
        }
    }
}


