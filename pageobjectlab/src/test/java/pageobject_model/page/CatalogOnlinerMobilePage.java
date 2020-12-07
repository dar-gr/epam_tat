package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogOnlinerMobilePage extends AbstractPage {

    private static final String MOBILEPAGE_URL = "https://catalog.onliner.by/mobile";
    private final int WAIT_TIMEOUT_SECONDS = 10;

    @FindBy(className = "schema-order__button js-schema-aside-open")
    private WebElement filterButton;

    @FindBy(className = "schema-filter-control__item schema-filter__number-input schema-filter__number-input_price")
    private WebElement maxPriceInput;

    public CatalogOnlinerMobilePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CatalogOnlinerMobilePage openFilter(){

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(filterButton));

        return this;
    }

    public CatalogOnlinerMobileFilteredByMaxPricePage searchForMaxPriceFilter(String price) {

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.textToBePresentInElement(maxPriceInput, price));

        return new CatalogOnlinerMobileFilteredByMaxPricePage(driver, price);
    }

    @Override
    public CatalogOnlinerMobilePage openPage(){
        driver.get(MOBILEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }
}
