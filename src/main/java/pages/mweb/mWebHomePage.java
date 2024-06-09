package pages.mweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.web.WebHomepage;

public class mWebHomePage extends WebHomepage {

    By hamburgerCss=By.cssSelector("button[aria-controls='navbarSupportedContent']");

    public mWebHomePage(WebDriver driver) {
        super(driver);
    }


    public void openCategories(){
        toggleHamburger();
        super.openCategories();
    }

    public void validateHeader(){
        toggleHamburger();
        super.validateHeader();
    }
    public void toggleHamburger(){
        waitAndClick(hamburgerCss);
    }

}
