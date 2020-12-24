package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CatalogOnlinerMobilePage extends AbstractPage {

    private static final String MOBILEPAGE_URL = "https://catalog.onliner.by/mobile";
    private static Logger log = LogManager.getLogger();

    @FindBy(xpath = "//div[@class='schema-order__button js-schema-aside-open']")
    private WebElement filterButton;

    @FindBy(xpath = "//input[@class='schema-filter-control__item schema-filter__number-input schema-filter__number-input_price']")
    private List<WebElement> priceInput;

    @FindBy(xpath = "//label[@class='schema-product__control']")
    private List<WebElement> listOfMobilesCheckboxes;

    @FindBy(xpath = "//div[@class='compare-button__state compare-button__state_initial']/a[@class='compare-button__sub compare-button__sub_main']")
    private List<WebElement> compareElement;

    @FindBy(xpath = "//span[@data-bind='html: product.extended_name || product.full_name']")
    private List<WebElement> mainMobileNames;

    @FindBy(xpath = "//span[@data-bind='html: children.extended_name || children.full_name']")
    private List<WebElement> additionalMobileNames;

    @FindBy(xpath = "//div[@class='schema-product__offers']")
    private List<WebElement> offerButtons;

    @FindBy(xpath = "//div[@class='auth-bar__item auth-bar__item--text']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class = 'b-top-profile__item b-top-profile__item_arrow']")
    private WebElement profileInfoButton;

    @FindBy(xpath = "//div[@class='b-top-profile__name']")
    private WebElement usernameElement;

    @FindBy(xpath = "//li[@id='product-bookmark-control']")
    private WebElement markButton;

    @FindBy(xpath = "//div[@class='catalog-masthead']/h1")
    private WebElement phoneName;

    @FindBy(xpath = "//div[@class='schema-product__image']")
    private List<WebElement> productsTitle;

    public CatalogOnlinerMobilePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        log.info("open mobile page");
    }

    public CatalogOnlinerMobilePage clickFilter(){

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        filterButton.click();
        log.info("click filter button");

        return this;
    }

    public CatalogOnlinerMobileFilteredByMaxPricePage searchForMaxPriceFilter(String price) {

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        priceInput.get(1).sendKeys(price);
        log.info("enter max price in filter");

        return new CatalogOnlinerMobileFilteredByMaxPricePage(driver, price);
    }

    public boolean resultListOfMobiles (){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        boolean isOnlyMobiles = false;
        for (WebElement mainMobileName : mainMobileNames) {
            isOnlyMobiles = mainMobileName.getText().contains("Смартфон") ||
                    !mainMobileName.getText().contains("телефон");
        }
        log.info("check if only mobiles");

        return isOnlyMobiles;
    }

    public CatalogOnlinerMobilePage chooseTwoFirstMobiles(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        listOfMobilesCheckboxes.get(1).click();
        log.info("click second mobile checkbox ");
        listOfMobilesCheckboxes.get(0).click();
        log.info("click first mobile checkbox");

        return this;
    }

    public ComparePage clickCompare(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        compareElement.get(0).click();
        log.info("click to open compare page");

        return new ComparePage(driver);
    }

    public List<String> getTwoFirstElements(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        List<String> mobilesName = new ArrayList<>();
        mobilesName.add(additionalMobileNames.get(0).getText());
        mobilesName.add(mainMobileNames.get(0).getText());
        log.info("take names of two first elements");

        return mobilesName;
    }

    public OfferPage clickOfferButtonOfFirstMobile(){
        offerButtons.get(0).click();
        //new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        log.info("click offers of first mobile");
        return new OfferPage(driver);
    }

    public LoginPage clickSignInPage(){
        signInButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return new LoginPage(driver);
    }

    public CatalogOnlinerMobilePage extendProfileInfoClick(){
        profileInfoButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return this;
    }

    public String getUsername(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return usernameElement.getText();
    }

    public CatalogOnlinerMobilePage openPhonePage(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        driver.get("https://catalog.onliner.by/mobile/honor/10xlitednnlx9uz");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return this;
    }

    public LoginPage addInMarks() {
        markButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return new LoginPage(driver);
    }

    public String getUrl() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return driver.getCurrentUrl();
    }

    @Override
    public CatalogOnlinerMobilePage openPage(){
        driver.get(MOBILEPAGE_URL);
        log.info("open mobiles page");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }
}
