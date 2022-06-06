package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DressesPage;

public class DressesTest extends HomeTest {

    DressesPage dressesPage;

    @BeforeMethod
    public void localSetUp(){
        dressesPage = new DressesPage(getDriver());

    }
    @Test(testName = "AUT-6 Recently viewed items", description = "confirm quick view dresses show up in recently viewed")
    public void test01(){
        dressesPage.firstDress.click();
        dressesPage.closeButton.click();


    }

}

