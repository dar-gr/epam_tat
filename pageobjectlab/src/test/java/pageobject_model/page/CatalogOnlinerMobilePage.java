package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static pageobject_model.waits.WaitsForElements.*;

public class CatalogOnlinerMobilePage {

    private static final String MOBILEPAGE_URL = "https://catalog.onliner.by/mobile";
    private WebDriver driver;

    public CatalogOnlinerMobilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public CatalogOnlinerMobilePage openPage(){
        driver.get(MOBILEPAGE_URL);
        new WebDriverWait(driver, 10);
        return this;
    }

    public CatalogOnlinerMobilePage openFilter(){
        WebElement filterDiv = waitForElementLocatedBy(driver,
                By.xpath("//div[@class='schema-order__button js-schema-aside-open']"));
        filterDiv.click();
        return this;
    }

    public CatalogOnlinerMobileFilteredByMaxPricePage searchForMaxPriceFilter(String price) {
        WebElement maxPriceInput = waitForElementsLocatedBy(driver,
                By.xpath("//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price']")).get(1);
        maxPriceInput.sendKeys(price);
        return new CatalogOnlinerMobileFilteredByMaxPricePage(driver, price);
    }
}
