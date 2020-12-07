package pageobject_model.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.CatalogOnlinerMobilePage;

import java.util.List;

public class OnlinerCatalogTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void resultOfUnrealFilterInCatalog() throws InterruptedException {

        List<WebElement> expectedMessageList = new CatalogOnlinerMobilePage(driver)
                .openPage()
                .openFilter()
                .searchForMaxPriceFilter("5")
                .noResultMessage();
        Assert.assertFalse(expectedMessageList.isEmpty());
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
