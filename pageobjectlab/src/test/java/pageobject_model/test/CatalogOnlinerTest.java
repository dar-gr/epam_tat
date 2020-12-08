package pageobject_model.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.CatalogOnlinerMobilePage;
import pageobject_model.page.CatalogOnlinerPage;

import java.util.List;

public class CatalogOnlinerTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void resultOfUnrealFilterInCatalog() {

        List<WebElement> expectedMessageList = new CatalogOnlinerMobilePage(driver)
                .openPage()
                .clickFilter()
                .searchForMaxPriceFilter("5")
                .noResultMessage();
        Assert.assertFalse(expectedMessageList.isEmpty());
    }

    @Test
    public void openMobileCatalog(){
        int actualAmountOfMobilesOnPage = 29;
        List<WebElement> listOfMobilesOnPage = new CatalogOnlinerPage(driver)
                .openPage()
                .clickElectronics()
                .moveToMobiles()
                .clickMobiles()
                .resultListOfMobiles();
        int expectedAmountOfMobilesOnPage = listOfMobilesOnPage.size();
        Assert.assertEquals(actualAmountOfMobilesOnPage, expectedAmountOfMobilesOnPage);
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
