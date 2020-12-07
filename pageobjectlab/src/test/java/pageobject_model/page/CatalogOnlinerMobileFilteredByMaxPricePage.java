package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static pageobject_model.waits.WaitsForElements.*;

public class CatalogOnlinerMobileFilteredByMaxPricePage {

    private WebDriver driver;
    private String price;

    public CatalogOnlinerMobileFilteredByMaxPricePage(WebDriver driver, String price){
        this.driver = driver;
        this.price = price;
    }

    public List<WebElement> resultList() {
        return waitForElementsLocatedBy(driver,
                By.xpath("//div[@class='schema-product__price']/a"));
    }

    public List<WebElement> noResultMessage(){
        return waitForElementsLocatedBy(driver,
                By.xpath("//div[@class='schema-products__message']"));
    }
}
