package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class LoginPage extends BasePage {
    protected WebDriver driver;


    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='passwd']")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@id='SubmitLogin']")
    public WebElement submitBtn;
    public void signIn(){
        String filePath = "src/test/data/config/configuration.properties";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.sendKeys(emailField, ConfigReader.readProperty(filePath, "username"));

        loginPage.sendKeys(passwordField, ConfigReader.readProperty(filePath, "password"));
        loginPage.click(submitBtn);
    }
}
