package Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.factory.PageFactory;
import utilities.PropertyHandler;

public class BaseTest {

    protected String url;
    protected static PageFactory pageFactory = PageFactory.getPageFactory();

    @BeforeMethod
    public void init(){
        DriverManager.initDriver();
        url = PropertyHandler.getProperty("url");
        DriverManager.getDriver().get(url);
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }

}
