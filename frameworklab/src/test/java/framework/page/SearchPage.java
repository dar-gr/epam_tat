package framework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends AbstractPage{
    @FindBy(xpath = "//div[@class='product__details']/a")
    private WebElement searchResultName;

    public SearchPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isTreeFirstElementsContains(String searchString){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        WebElement w = searchResultName;
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(searchResultName));
        searchResultName.click();
        String t = w.getText();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        boolean r = t.contains(searchString);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        return r;
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("This page can't be opened without parameters!");
    }
}
