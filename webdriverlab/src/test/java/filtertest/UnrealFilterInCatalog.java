package filtertest;

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

import java.util.List;

public class UnrealFilterInCatalog {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void resultOfUnrealFilterInCatalog() throws InterruptedException {
        driver.get("https://catalog.onliner.by/mobile");

        WebElement filterDiv = waitForElementLocatedBy(driver,
                By.xpath("//div[@class='schema-order__button js-schema-aside-open']"));
        filterDiv.click();

        WebElement maxPriceInput = waitForElementsLocatedBy(driver,
                By.xpath("//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price']")).get(1);
        maxPriceInput.sendKeys("5");

        List<WebElement> noResultMessages = waitForElementsLocatedBy(driver,
                By.xpath("//div[@class='schema-products__message']"));

        Assert.assertFalse(noResultMessages.isEmpty());
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver, 10).
                until(ExpectedConditions.presenceOfElementLocated(by));
    }

    private static List<WebElement> waitForElementsLocatedBy(WebDriver driver, By by){
        return new WebDriverWait(driver, 10).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
}
