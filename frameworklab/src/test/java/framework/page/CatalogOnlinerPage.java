package framework.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogOnlinerPage extends AbstractPage {

    private static final String MOBILEPAGE_URL = "https://catalog.onliner.by";
    private final Logger logger = LogManager.getLogger();

    public CatalogOnlinerPage(WebDriver driver){
        super(driver);
    }

    public CatalogOnlinerPage clickElectronics(){
        String electronicsButtonXpath = "//div[@class='catalog-navigation catalog-navigation_opened']/ul/li[@class='catalog-navigation-classifier__item ' and @data-id = '1']";
        driver.findElement(By.xpath(electronicsButtonXpath)).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        logger.info("click electronics");

        return this;
    }

    public CatalogOnlinerPage moveToMobiles(){
        Actions moveToMobiles = new Actions(driver);
        String mobilesMoveXpath = "//div[@class = 'catalog-navigation-list__aside-title']";
        moveToMobiles.moveToElement(driver.findElements(By.xpath(mobilesMoveXpath)).get(0)).build().perform();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        logger.info("move to mobiles");

        return this;
    }

    public CatalogOnlinerMobilePage clickMobiles(){
        String mobilesButtonXpath = "//div/a[@class='catalog-navigation-list__dropdown-item'][@href = 'https://catalog.onliner.by/mobile']//span";
        driver.findElements(By.xpath(mobilesButtonXpath)).get(0).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        logger.info("click mobiles");

        return new CatalogOnlinerMobilePage(driver);
    }

    @Override
    public CatalogOnlinerPage openPage(){
        driver.get(MOBILEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        logger.info("Open catalog with mobiles page");

        return this;
    }
}
