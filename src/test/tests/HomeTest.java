package tests;

import base.BasePage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.SeleniumUtils;

public class HomeTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void localSetUp(){homePage = new HomePage(getDriver());}

    @Test(testName = "Verify information section is displayed and clickable - Specials")
    public void test01(){

        Assert.assertTrue(homePage.specialLink.isEnabled());
    }

    @Test(testName = "Verify information section is displayed and clickable - New product")
    public void test02(){

        Assert.assertTrue(homePage.newProductLink.isEnabled());
    }

    @Test(testName = "Verify information section is displayed and clickable - Best sellers")
    public void test03(){

        Assert.assertTrue(homePage.bestSellerLink.isEnabled());
    }

    @Test(testName = "Verify information section is displayed and clickable - Our stores")
    public void test04(){

        Assert.assertTrue(homePage.ourStoresLink.isEnabled());
    }

    @Test(testName = "Verify information section is displayed and clickable - Contact us")
    public void test05(){

        Assert.assertTrue(homePage.contactUsLink.isEnabled());
    }

    @Test(testName = "Verify information section is displayed and clickable - Terms and conditions of use")
    public void test06(){

        Assert.assertTrue(homePage.termsAndConditionsLink.isEnabled());
    }

    @Test(testName = "Verify information section is displayed and clickable - About us")
    public void test07(){

        Assert.assertTrue(homePage.aboutUsLink.isEnabled());
    }

    @Test(testName = "Verify information section is displayed and clickable - Sitemap")
    public void test08(){

        Assert.assertTrue(homePage.siteMap.isEnabled());
    }
    @Test(testName = "verify buttons on personal page", description = "order history and details")
    public void test09(){
        homePage.click(homePage.signinBtn);

    }

    @Test(testName = "AUT-5: Test social media icon - Facebook")
    public void testAUT0501() throws InterruptedException {
        homePage.click(homePage.facebookBtn);
        String actual = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);
        Assert.assertEquals(actual, "Selenium Framework");
    }

    @Test(testName = "AUT-5: Test social media icon - Twitter")
    public void testAUT0502(){
        homePage.click(homePage.twitterBtn);
        String actual = SeleniumUtils.switchToWindowAndVerifyUrl(getDriver(), extentManager);
        Assert.assertTrue(actual.contains("twitter"));
    }

    @Test(testName = "AUT-5: Test social media icon - Youtube")
    public void testAUT0503(){
        homePage.click(homePage.youtubeBtn);
        String actual = SeleniumUtils.switchToWindowAndVerifyUrl(getDriver(), extentManager);
        Assert.assertTrue(actual.contains("youtube"));
    }

    @Test(testName = "AUT-5: Test social media icon - GooglePlus")
    public void testAUT0504(){
        homePage.click(homePage.googlePlusBtn);
        String actual = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);
        // Assert.assertEquals(actual, "Sign in - Google Accounts");
        Assert.assertEquals(actual, "Google+");
    }
    @Test(testName = "us-8", description = "account page button is ebabled")
    public void test10() {
        homePage.click(homePage.signinBtn);
        loginPage.sendKeys(loginPage.emailField, "test1111test1111.com");
        loginPage.sendKeys(loginPage.passwordField, "qwerty123");
        loginPage.click(homePage.signinBtn);
    }

}
