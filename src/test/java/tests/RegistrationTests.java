package tests;

import Base.BaseTest;
import Base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;

public class RegistrationTests extends BaseTest {

    @Test
    public void testDobError(){
        WebDriver driver = new DriverManager().initDriver();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.navigateByUrl();
        registrationPage.enterFirstName("Itachi");
        registrationPage.enterLastName("Uchiha");
        registrationPage.submitForm();
        Assert.assertTrue(registrationPage.isDobErrorDisplayed(),"Dob error is not displayed");
        quitDriver(driver);
    }

    @Test
    public void testCountryDropdown(){
        WebDriver driver = new DriverManager().initDriver();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.navigateByUrl();
        Assert.assertEquals(registrationPage.getSelectedCountry(),"Your country *");
        registrationPage.selectCountry("India");
        Assert.assertEquals(registrationPage.getSelectedCountry(),"India");
        quitDriver(driver);
    }

    @Test
    public void testPhoneValidations(){
        WebDriver driver = new DriverManager().initDriver();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.navigateByUrl();
        registrationPage.enterPhone("hello123");
        registrationPage.submitForm();
        Assert.assertEquals(registrationPage.getPhoneError(),"Only numbers are allowed.");
        registrationPage.enterPhone("7489549876");
        Assert.assertFalse(registrationPage.isPhoneErrorPresent(),"Phone error should be resolved");
        quitDriver(driver);
    }
}
