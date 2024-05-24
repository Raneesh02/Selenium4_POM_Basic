package tests;

import Base.BaseTest;
import Base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Homepage;

import java.util.Arrays;

public class HomePageTests extends BaseTest {

    @Test
    public void testCategories(){
        WebDriver driver = new DriverManager().initDriver();
        Homepage homepage = new Homepage(driver);
        homepage.openCategories();
        Assert.assertEquals(homepage.getCategoriesList(), Arrays.asList("Hand Tools", "Power Tools", "Other", "Special Tools","","Rentals"));
        quitDriver(driver);
    }

    @Test
    public void testHeader(){
        WebDriver driver = new DriverManager().initDriver();
        Homepage homepage = new Homepage(driver);
        homepage.validateHeader();
        quitDriver(driver);
    }

    @Test
    public void testFooter(){
        WebDriver driver = new DriverManager().initDriver();
        Homepage homepage = new Homepage(driver);
        Assert.assertEquals(homepage.getFooterText(),"This is a DEMO application (GitHub repo), used for software testing training purpose. | Support this project | Privacy Policy | Banner photo by Barn Images on Unsplash.");
        quitDriver(driver);
    }
}
