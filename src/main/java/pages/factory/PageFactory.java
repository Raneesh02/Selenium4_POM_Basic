package pages.factory;


import org.openqa.selenium.WebDriver;
import pages.interfaces.HomePage;
import utilities.PropertyHandler;

public abstract class PageFactory {

    public static PageFactory getPageFactory(){
        String platform = PropertyHandler.platform;
        return switch (platform){
            case "web" -> new WebPageFactory();
            case "mweb" -> new MWebPageFactory();
            default -> throw new IllegalArgumentException("Platform " + platform + " is not correct value");
        };
    }

    abstract public HomePage getHomePage(WebDriver driver);
}