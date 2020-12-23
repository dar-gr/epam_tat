package framework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

    private static WebDriver driver;
    private static Logger log = LogManager.getLogger();

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        /*if(null == driver){
            switch (System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                default:{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }*/
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            log.info("open chrome browser");

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;

        log.info("close browser");
    }
}
