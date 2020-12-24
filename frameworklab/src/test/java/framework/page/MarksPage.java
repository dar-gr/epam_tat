package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MarksPage extends AbstractPage {
    private static String MARKSPAGE_URL = "https://profile.onliner.by/bookmarks";

    @FindBy(xpath = "//td[@class='pimage']")
    private List<WebElement> nameOfMarkedProducts;

    @FindBy(xpath = "//li/a[@href='/bookmarks/catalog']")
    private WebElement catalogMarksButton;

    public MarksPage(WebDriver driver){
        super(driver);
    }

    public MarksPage openCatalogMarks(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        catalogMarksButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return this;
    }

    public String openFirstElementAndGetUrl(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        nameOfMarkedProducts.get(0).click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return driver.getCurrentUrl();
    }

    @Override
    public MarksPage openPage(){
        driver.get(MARKSPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }
}
