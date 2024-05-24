package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    WebDriver driver;

    public WebDriver initDriver(){
        driver = new ChromeDriver();
        return driver;
    }

//    public static WebDriver getDriver(){
//        return threadLocalDriver.get();
//    }

    public void quitDriver(){
        driver.quit();
    }

}
