package tests;

import Base.BaseTest;
import Base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.interfaces.HomePage;

import java.util.Arrays;

public class HomePageTests extends BaseTest {

    @Test
    public void testCategories(){
        HomePage homepage = pageFactory.getHomePage(DriverManager.getDriver());
        homepage.openCategories();
        Assert.assertEquals(homepage.getCategoriesList(), Arrays.asList("Hand Tools", "Power Tools", "Other", "Special Tools","","Rentals"));
    }

    @Test
    public void testHeader(){
        HomePage homepage = pageFactory.getHomePage(DriverManager.getDriver());
        homepage.validateHeader();
    }

    @Test
    public void testFooter(){
        HomePage homepage = pageFactory.getHomePage(DriverManager.getDriver());
        Assert.assertEquals(homepage.getFooterText(),"This is a DEMO application (GitHub repo), used for software testing training purpose. | Support this project | Privacy Policy | Banner photo by Barn Images on Unsplash.");
    }
}
