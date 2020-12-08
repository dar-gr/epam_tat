package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogOnlinerPage extends AbstractPage {

    private static final String MOBILEPAGE_URL = "https://catalog.onliner.by";

    public CatalogOnlinerPage(WebDriver driver){
        super(driver);
    }

    public CatalogOnlinerPage clickElectronics(){
        String electronicsButtonXpath = "//div[@class='catalog-navigation catalog-navigation_opened']/ul/li[@class='catalog-navigation-classifier__item ' and @data-id = '1']";
        driver.findElement(By.xpath(electronicsButtonXpath)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return this;
    }

    public CatalogOnlinerPage moveToMobiles(){
        Actions moveToMobiles = new Actions(driver);
        String mobilesMoveXpath = "//li[@class='catalog-navigation-classifier__item catalog-navigation-classifier__item_active' and @data-id= '1']";
        moveToMobiles.moveToElement(driver.findElement(By.xpath(mobilesMoveXpath))).build().perform();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return this;
    }

    public CatalogOnlinerMobilePage clickMobiles(){
        String mobilesButtonXpath = "//div/a[@href='https://catalog.onliner.by/mobile']";
        driver.findElement(By.xpath(mobilesButtonXpath)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return new CatalogOnlinerMobilePage(driver);
    }

    @Override
    public CatalogOnlinerPage openPage(){
        driver.get(MOBILEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return this;
    }
}
