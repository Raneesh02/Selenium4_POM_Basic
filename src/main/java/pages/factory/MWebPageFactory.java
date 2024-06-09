package pages.factory;

import org.openqa.selenium.WebDriver;
import pages.interfaces.HomePage;
import pages.mweb.mWebHomePage;

public class MWebPageFactory extends PageFactory{


    @Override
    public HomePage getHomePage(WebDriver driver) {
        return new mWebHomePage(driver);
    }
}
