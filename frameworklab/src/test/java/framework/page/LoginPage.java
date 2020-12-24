package framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//div[@class='auth-input__wrapper auth-form__input-wrapper auth-form__input-wrapper_width_full']//input")
    private List<WebElement> usernameAndPasswordInput;

    @FindBy(xpath = "//div[@class='auth-form__control auth-form__control_condensed-additional']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']")
    private WebElement invalidMessage;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public LoginPage enterInvalidUser(){
        usernameAndPasswordInput.get(0).sendKeys("invalid");
        usernameAndPasswordInput.get(1).sendKeys("invalid");

        return this;
    }

    public LoginPage signInButtonClick(){
        signInButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return this;
    }

    public String isInvalidMessage(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        String s = invalidMessage.getText();
        return s;
    }

    public LoginPage enterUserInfo(){
        usernameAndPasswordInput.get(0).sendKeys("test1101");
        usernameAndPasswordInput.get(1).sendKeys("testtest");

        return this;
    }


    @Override
    public AbstractPage openPage(){
        throw new RuntimeException("This page can't be opened without parameters!");
    }
}
