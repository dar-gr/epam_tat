package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdMobilesPage extends AbstractPage {
    private static final String MOBILEPAGE_URL = "https://catalog.onliner.by/mobile?segment=second";

    @FindBy(xpath = "//div[@class ='schema-product__title']/a")
    private List<WebElement> adList;

    @FindBy(xpath = "//div[@class='catalog-masthead']/h1")
    private WebElement adName;

    public AdMobilesPage(WebDriver driver){
        super(driver);
    }

    public String getFirstAdName(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return adList.get(0).getText();
    }

    public AdMobilesPage openFirstAd(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        adList.get(0).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return this;
    }

    public String getAdName(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return adName.getText();
    }

    @Override
    public AdMobilesPage openPage(){
        driver.get(MOBILEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }
}
