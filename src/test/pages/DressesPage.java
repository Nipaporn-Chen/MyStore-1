package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressesPage extends HomePage {
    protected WebDriver driver;

    public DressesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='quick-view-wrapper-mobile'])[3]")
    public WebElement firstDress;

    @FindBy(xpath = "//a[@class='fancybox-item fancybox-close']")
    public WebElement closeButton;

    @FindBy(xpath = "(//a[@title='T-shirts'])[1]")
    public WebElement tShirtButton;

    @FindBy(xpath = "//li[@class='clearfix first_item']")
    public WebElement recentlyViewedDress;
}






