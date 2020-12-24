package framework.page;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class OfferPage extends AbstractPage {
    @FindBy (xpath = "//span[@class='i-checkbox offers-form__checkbox offers-form__checkbox_base-alter']")
    private List<WebElement> filterCheckboxes;

    @FindBy (xpath = "//div[@class = 'offers-list__description offers-list__description_alter offers-list__description_base-alter offers-list__description_condensed']")
    private List<WebElement> addressDeliverInfo;

    @FindBy(xpath = "//span[@class='button-style button-style_another button-style_base offers-form__button']")
    private WebElement cityConfirmationButton;

    @FindBy (xpath = "//div[@class='offers-list__description offers-list__description_additional offers-list__description_tiny /*offers-list__description_reseller*/ offers-list__description_ellipsis offers-list__description_condensed-alter']")
    private List<WebElement> officialDealerInfo;

    @FindBy(xpath = "//div[@class='offers-list__flex']")
    private List<WebElement> allOffers;

    public OfferPage(WebDriver driver){
        super(driver);
    }

    public OfferPage clickAddressDeliverCheckbox(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        for(WebElement filterCheckbox : filterCheckboxes){
            if(filterCheckbox.getText().contains("Доставка по адресу")){
                filterCheckbox.click();
                new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
                cityConfirmationButton.click();

            }
        }
        return this;
    }

    public OfferPage clickOfficialDealerCheckbox() throws InterruptedException {
        //new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        for(WebElement filterCheckbox : filterCheckboxes){
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            if(filterCheckbox.getText().contains("Официальный дилер")){
                //new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(filterCheckbox));
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                filterCheckbox.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                //new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
                cityConfirmationButton.click();
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                //new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='offers-list__flex']"), officialDealerInfo.size()));
            }
        }
        //new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return this;
    }

    public int countOnlyOfficialDealerOffer() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return officialDealerInfo.size();
    }

    public int countAllOffers() {
        //new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return allOffers.size();//driver.findElements(By.xpath("//div[@class='offers-list__flex']")).size();
    }

    @Override
    public AbstractPage openPage(){
        throw new RuntimeException("This page can't be opened without parameters!");
    }
}
