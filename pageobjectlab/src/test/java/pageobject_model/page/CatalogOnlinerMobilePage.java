package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CatalogOnlinerMobilePage extends AbstractPage {

    private static final String MOBILEPAGE_URL = "https://catalog.onliner.by/mobile";

    @FindBy(xpath = "//div[@class='schema-order__button js-schema-aside-open']")
    private WebElement filterButton;

    @FindBy(xpath = "//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price']")
    private List<WebElement> priceInput;

    @FindBy(xpath = "//span[@data-bind='html: product.extended_name || product.full_name' and (contains(text(),'Смартфон') or contains(text(), 'телефон'))]")
    private List<WebElement> listOfPageElements;

    public CatalogOnlinerMobilePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CatalogOnlinerMobilePage clickFilter(){

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        filterButton.click();

        return this;
    }

    public CatalogOnlinerMobileFilteredByMaxPricePage searchForMaxPriceFilter(String price) {

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        priceInput.get(1).sendKeys(price);

        return new CatalogOnlinerMobileFilteredByMaxPricePage(driver, price);
    }

    public List<WebElement> resultListOfMobiles (){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return listOfPageElements;
    }

    @Override
    public CatalogOnlinerMobilePage openPage(){
        driver.get(MOBILEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }
}
