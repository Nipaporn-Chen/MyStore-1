package tests;

import base.BaseTest;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class ShoppingCartTest extends BaseTest {
    HomePage homePage;


    @BeforeMethod
    public void localSetUp() {
        homePage = new HomePage(getDriver());
    }

    @Test(testName = "Validate shopping cart")
    public void test01() {
        Assert.assertTrue(homePage.shoppingCart.isDisplayed());

    }

    @Test(testName = "total validation")
    public void test02() throws InterruptedException {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(homePage.buttonHover1).perform();

        homePage.addToCartBtn1.click();
        homePage.continueShopBtn.click();

        actions.moveToElement(homePage.buttonHover2).perform();

        homePage.addToCartBtn2.click();
        homePage.continueShopBtn.click();

        actions.moveToElement(homePage.shoppingCart).click().perform();

        String item1Cost = homePage.priceItem1.getText();
        String item1CostTrim = item1Cost.substring(1);
        double item1CostNum = Double.parseDouble(item1CostTrim);
        System.out.println(item1CostNum);

        String item2Cost = homePage.priceItem2.getText();
        String item2CostTrim = item1Cost.substring(1);
        double item2CostNum = Double.parseDouble(item2CostTrim);
        System.out.println(item2CostNum);

        String shippingCost = homePage.shippingCost.getText();
        String shippingCostTrim = shippingCost.substring(1);
        double shippingCostNum = Double.parseDouble(shippingCostTrim);
        System.out.println(shippingCostNum);

        String totalCost = homePage.total.getText();
        String totalCostTrim = totalCost.substring(1);
        double totalCostNum = Double.parseDouble(totalCostTrim);
        System.out.println(totalCostNum);

        double sum = item1CostNum+item2CostNum+shippingCostNum;

        Assert.assertEquals(sum, totalCostNum);
    }
}
