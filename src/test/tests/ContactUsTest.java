package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactUsTest extends BaseTest {
    HomePage homePage;
    ContactUsPage contactUsPage;
    List<String> expectedSubject = new ArrayList<>(Arrays.asList("Customer service", "Webmaster"));
    int expectedResult = 1;
    String testOrder = "1234567890";
    String testMessage = "Random Message for Text Area";
    String uploadFilePath = System.getProperty("user.dir") + "/src/test/data/extras/file.txt";

    @BeforeMethod
    public void localSetUp() {
        homePage = new HomePage(getDriver());
        contactUsPage = new ContactUsPage(getDriver());
        homePage.click(homePage.contactUsLink);
    }

    @Test(testName = "IN-2.1 - Test Subject", description = "validating options for subject")
    public void test101() {
        Select select = new Select(contactUsPage.subject);
        List<WebElement> actual = select.getOptions();

        for (String eachExp : expectedSubject) {
            boolean found = false;
            for (WebElement eachActual : actual) {
                String optionStr = eachActual.getText();
                if (eachExp.equals(optionStr))
                    found = true;
            }
            extentManager.logScreenshot("Test log message here");
            Assert.assertEquals(found, true);
        }
    }

    @Test(testName = "IN-2.2.1 - Test email address", description = "Testing valid email address")
    public void test102() {
        this.fillSubject();
        this.fillEmail(1); //valid address
        contactUsPage.sendKeys(contactUsPage.orderRef, testOrder);
        contactUsPage.sendKeys(contactUsPage.messageArea, testMessage);
        contactUsPage.click(contactUsPage.sendBtn);
        extentManager.logScreenshot("Test log message here");
        Assert.assertEquals(contactUsPage.result.size(), expectedResult);

    }

    @Test(testName = "IN-2.2.2 - Test email address", description = "Testing invalid email address")
    public void test103() {
        this.fillSubject();
        this.fillEmail(2); //invalid address
        contactUsPage.sendKeys(contactUsPage.orderRef, testOrder);
        contactUsPage.sendKeys(contactUsPage.messageArea, testMessage);
        contactUsPage.click(contactUsPage.sendBtn);
        extentManager.logScreenshot("Test log message here");
        Assert.assertEquals(contactUsPage.result.size(), 0);
    }

    @Test(testName = "IN-2.2.3 - Test email address", description = "Testing empty email address")
    public void test104() {
        this.fillSubject();
        // empty email address
        contactUsPage.sendKeys(contactUsPage.orderRef, testOrder);
        contactUsPage.sendKeys(contactUsPage.messageArea, testMessage);
        contactUsPage.click(contactUsPage.sendBtn);
        extentManager.logScreenshot("Test log message here");
        Assert.assertEquals(contactUsPage.result.size(), 0);
    }

    @Test(testName = "IN-2.3.1 - Test Order Reference", description = "Testing 10 digits order reference")
    public void test105() {
        this.fillSubject();
        this.fillEmail(1); //valid address
        contactUsPage.sendKeys(contactUsPage.orderRef, testOrder);
        contactUsPage.sendKeys(contactUsPage.messageArea, testMessage);
        contactUsPage.click(contactUsPage.sendBtn);
        extentManager.logScreenshot("Test log message here");
        Assert.assertEquals(contactUsPage.result.size(), expectedResult);

    }

    @Test(testName = "IN-2.3.2 - Test Order Reference", description = "Testing empty order reference")
    public void test106() {
        this.fillSubject();
        this.fillEmail(1); //valid address
// empty order Reference
        contactUsPage.sendKeys(contactUsPage.messageArea, testMessage);
        contactUsPage.click(contactUsPage.sendBtn);
        extentManager.logScreenshot("Test log message here");
        Assert.assertEquals(contactUsPage.result.size(), expectedResult);

    }

    @Test(testName = "IN-2.4.1 - Attach File Btn", description = "Validate File can be uploaded")
    public void test107() {
        this.fillSubject();
        this.fillEmail(1); //valid address
        contactUsPage.sendKeys(contactUsPage.orderRef, testOrder);
        contactUsPage.sendKeys(contactUsPage.messageArea, testMessage);
        contactUsPage.attachBtn.sendKeys(uploadFilePath);
        // contactUsPage.sendKeys(contactUsPage.attachBtn, uploadFilePath);
        contactUsPage.click(contactUsPage.sendBtn);
        extentManager.logScreenshot("Test log message here");
        Assert.assertEquals(contactUsPage.result.size(), expectedResult);
    }

    @Test(testName = "IN-2.5.1 - Message Area", description = "Verify message gets sent with text in Message Area")
    public void test108() {
        this.fillSubject();
        this.fillEmail(1); //valid address
        contactUsPage.sendKeys(contactUsPage.orderRef, testOrder);
        contactUsPage.sendKeys(contactUsPage.messageArea, testMessage);
        contactUsPage.click(contactUsPage.sendBtn);
        extentManager.logScreenshot("Test log message here");
        Assert.assertEquals(contactUsPage.result.size(), expectedResult);

    }

    @Test(testName = "IN-2.5.2 - Message Area", description = "Verify message is not sent if message area is empty")
    public void test109() {
        this.fillSubject();
        this.fillEmail(1); //valid address
        contactUsPage.sendKeys(contactUsPage.orderRef, testOrder);
// empty message
        contactUsPage.click(contactUsPage.sendBtn);
        extentManager.logScreenshot("Test log message here");
        Assert.assertEquals(contactUsPage.result.size(), 0);

    }


    public void fillSubject() {
        Select select = new Select(contactUsPage.subject);
        select.selectByIndex(1);
    }

    public void fillEmail(int emailType) {
        //  case 1 valid email address, case 2 invalid email address
        String inputEmail = "";
        switch (emailType) {
            case 1:
                inputEmail = "validemail@gmail.com";
                break;
            case 2:
                inputEmail = "invalid@email@gmail.com";
                break;
            default:
                System.out.println("Invalid email type number");

        }
        contactUsPage.sendKeys(contactUsPage.email, inputEmail);

    }


}


