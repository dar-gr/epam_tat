package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogOnlinerMobileFilteredByMaxPricePage extends AbstractPage{

    private String price;
    private Logger logger = LogManager.getLogger();
    private static String messageClassDivXpath = "//div[@class='schema-products__message']";
    private static String productPriceClassDivXpath = "//div[@class='schema-product__price']/a";


    public CatalogOnlinerMobileFilteredByMaxPricePage(WebDriver driver, String price){
        super(driver);
        this.price = price;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> noResultMessage(){
        logger.info("get no result message");
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                                .presenceOfAllElementsLocatedBy(
                                        By.xpath(messageClassDivXpath)));
    }

    @Override
    public AbstractPage openPage()
    {
        throw new RuntimeException("This page can't be opened without parameters!");
    }
}
