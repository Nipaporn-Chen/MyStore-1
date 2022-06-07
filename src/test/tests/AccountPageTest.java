package tests;

import base.BasePage;
import base.BaseTest;
import org.openqa.selenium.By;
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
    public void localSetUp() {
        homePage = new HomePage(getDriver());
    }

    @Test(testName = "us-8", description = "locating buttons on my personal page")
    public void test01() throws InterruptedException {

        getDriver().findElement(By.className("login")).click();
        getDriver().findElement(By.className("login")).click();
        getDriver().findElement(By.name("email")).sendKeys("test1111@test1111.com");
        getDriver().findElement(By.name("passwd")).sendKeys("qwerty123");
        getDriver().findElement(By.id("SubmitLogin")).click();
        Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='Order history and details']")).isEnabled());
        Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='My credit slips']")).isEnabled());
        Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='My addresses']")).isEnabled());
        Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='My personal information']")).isEnabled());
        Assert.assertTrue(getDriver().findElement(By.xpath("//span[text()='My wishlists']")).isEnabled());

//        homePage.click(homePage.signinBtn);
//        basePage.sleep(2000L);
//        basePage.waitForElementClickability(loginPage.emailField);
//        loginPage.emailField.sendKeys("test1111@test1111.com");
//        loginPage.passwordField.sendKeys("qwerty123");
//        loginPage.submitBtn.click();

//        Assert.assertTrue(accountPage.orderHistoryAndDetails.isEnabled());


//        WebElement[] btns = {accountPage.orderHistoryAndDetails, accountPage.myCreditSlips, accountPage.myAddresses, accountPage.myPersonalInformation, accountPage.myWishList};
//        for (WebElement btn : btns) {
//            Assert.assertTrue(btn.isEnabled());
//        }
//    }
//}
    }
}