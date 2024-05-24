package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.PropertyHandler;

public class BaseTest {

    protected String url;
    DriverManager driverManager;

    @BeforeMethod
    public void init(){
//        DriverManager.initDriver();
//        DriverManager.getDriver();
        url = PropertyHandler.getProperty("url");
//        DriverManager.getDriver().get(url);
    }

    @AfterMethod
    public void tearDown(){
//        DriverManager.quitDriver();
    }

    protected  void quitDriver(WebDriver driver){
        driver.quit();
    }

}
