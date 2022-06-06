package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//*[@title='Faded Short Sleeve T-shirts']")
    public WebElement buttonHover1;

    @FindBy(xpath = "//*[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-in-line first-item-of-tablet-line last-item-of-mobile-line']" )
    public WebElement buttonHover2;

    @FindBy(xpath = "//*[@title='View my shopping cart']")
    public WebElement shoppingCart;

    @FindBy(className = "//*[@class='price cart_block_total ajax_block_cart_total']")
    public WebElement total;

    @FindBy(className = "/*[@class='price']")
    public List<WebElement> productPrice;

    @FindBy(className = "//*[@class='price cart_block_shipping_cost ajax_cart_shipping_cost']")
    public WebElement shippingCost;

    @FindBy(xpath = "//*[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line first-item-of-tablet-line first-item-of-mobile-line']")
    public WebElement item1;

    @FindBy(xpath = "//*[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 last-in-line first-item-of-tablet-line last-item-of-mobile-line']")
    public WebElement item2;

    @FindBy(xpath = "//*[text()='Add to cart']")
    public WebElement addToCartBtn1;

    @FindBy(xpath = "//*[@data-id-product='4']")
    public WebElement addToCartBtn2;

    @FindBy(xpath = "//*[@title='Continue shopping']")
    public WebElement continueShopBtn;

}
