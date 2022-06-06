package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h4[text()='Information']")
    public WebElement informationTag;

    @FindBy(xpath = "//a[@title='Specials']")
    public WebElement specialLink;

    @FindBy(xpath = "//a[@title='New products']")
    public WebElement newProductLink;

    @FindBy(xpath = "//a[@title='Best sellers']")
    public  WebElement bestSellerLink;

    @FindBy(xpath = "//a[@title='Our stores']")
    public WebElement ourStoresLink;

    @FindBy(xpath = "//a[@title='Contact us']")
    public WebElement contactUsLink;

    @FindBy(xpath = "//a[@title='Terms and conditions of use']")
    public WebElement termsAndConditionsLink;

    @FindBy(xpath = "//a[@title='About us']")
    public WebElement aboutUsLink;

    @FindBy(xpath = "//a[@title='About us']")
    public WebElement siteMap;

    @FindBy(xpath = "//li[@class='facebook']//a")
    public WebElement facebookBtn;

    @FindBy(xpath = "//li[@class='twitter']//a")
    public WebElement twitterBtn;

    @FindBy(xpath = "//li[@class='youtube']//a")
    public WebElement youtubeBtn;

    @FindBy(xpath = "//li[@class='google-plus']//a")
    public WebElement googlePlusBtn;

    @FindBy(className = "login")
    public WebElement signinBtn;

}
