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

    @FindBy(xpath = "//div[@class='b-whbd-i']/p")
    private WebElement noMarksInfo;

    @FindBy(xpath = "//div[@class ='b-pmfilter']")
    private WebElement chooseAllCheckbox;

    @FindBy(xpath = "//div[@class ='b-pmchk']/a")
    private WebElement deleteChosenButton;

    public MarksPage(WebDriver driver){
        super(driver);
    }

    public MarksPage openCatalogMarks(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        catalogMarksButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return this;
    }

    public CatalogOnlinerMobilePage openFirstElement(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        nameOfMarkedProducts.get(0).click();

        return new CatalogOnlinerMobilePage(driver);
    }

    public String noMarksMessage(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return noMarksInfo.getText();
    }

    public MarksPage chooseAllElements(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        chooseAllCheckbox.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return this;
    }

    public MarksPage deleteChosen(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        deleteChosenButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }

    @Override
    public MarksPage openPage(){
        driver.get(MARKSPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return this;
    }
}
