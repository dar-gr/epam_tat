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

public class ComparePage extends AbstractPage {
    private static Logger log = LogManager.getLogger();

    @FindBy(xpath = "//span[@class='product-summary__caption']")
    private List<WebElement> comparedElementsName;

    @FindBy(xpath = "//div[@class='catalog-masthead__aside']")
    private WebElement cleanButton;

    public ComparePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getComparedElements(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        int amountOfComparedElements = comparedElementsName.size() / 2;
        List<String> nameOfElements = new ArrayList<>();

        for (int i = 0; i < amountOfComparedElements; i++) {
            nameOfElements.add(comparedElementsName.get(i).getText());
        }

        log.info("get names of compared elements");

        return nameOfElements;
    }

    public String cleanCompares(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        cleanButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);

        return driver.getCurrentUrl();
    }

    @Override
    public AbstractPage openPage(){
        throw new RuntimeException("This page can't be opened without parameters!");
    }
}
