package pages.factory;


import org.openqa.selenium.WebDriver;
import pages.interfaces.HomePage;
import pages.mweb.mWebHomePage;
import pages.web.WebHomepage;
import utilities.PropertyHandler;

public class PageFactory {

    public static HomePage getHomePage(WebDriver webDriver){
        String platform = PropertyHandler.platform;
        if(platform.equalsIgnoreCase("web")){
            return new WebHomepage(webDriver);
        }
        else if(platform.equalsIgnoreCase("mweb")){
            return new mWebHomePage(webDriver);
        }
        else{
            throw new IllegalArgumentException("wrong platform value "+ platform);
        }
    }

}