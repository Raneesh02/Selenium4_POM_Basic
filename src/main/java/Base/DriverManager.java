package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static ThreadLocal<WebDriver> threadLocalDriver= new ThreadLocal<>();;

    public static WebDriver initDriver(){
//        threadLocalDriver.set(new ChromeDriver());
        FirefoxOptions dcc = new FirefoxOptions();
//        dcc.setCapability("browserName", "firefox");
        try {
            threadLocalDriver.set(new RemoteWebDriver(new URL("http://localhost:4444"),dcc));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return threadLocalDriver.get();
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void quitDriver(){
        threadLocalDriver.get().quit();
        threadLocalDriver.remove();
    }

}
