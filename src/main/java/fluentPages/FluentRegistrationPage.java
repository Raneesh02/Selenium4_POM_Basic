package fluentPages;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FluentRegistrationPage extends BasePage {
    String navigationUrl="/auth/register";

    By firstNameCss=By.cssSelector("input[data-test='first-name']");
    By lastNameCss=By.cssSelector("input[data-test='last-name']");
    By dobErrorCss=By.cssSelector("[data-test='dob-error']");
    By registerBtnCss=By.cssSelector("button[data-test='register-submit']");
    By countryDDwnCss=By.cssSelector("select[data-test='country']");
    By phoneErrorCss=By.cssSelector("[data-test='phone-error']");
    By phoneTxtCss=By.cssSelector("input[data-test='phone']");



    public FluentRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public FluentRegistrationPage navigateByUrl(){
        this.driver.get(this.url+navigationUrl);
        return this;
    }


    public FluentRegistrationPage enterFirstName(String name){
        waitAndSendKeys(firstNameCss,name);
        return this;
    }

    public FluentRegistrationPage enterLastName(String name){
        waitAndSendKeys(lastNameCss,name);
        return this;
    }

    public FluentRegistrationPage submitForm(){
        waitAndClick(registerBtnCss);
        return this;
    }

    public boolean isDobErrorDisplayed(){
        return isDisplayed(dobErrorCss);
    }
    public FluentRegistrationPage selectCountry(String country){
        waitAndSelect(countryDDwnCss, country);
        return this;
    }

    public String getSelectedCountry(){
        return getSelectedOption(countryDDwnCss);
    }
    public String getPhoneError(){
        return getText(phoneErrorCss);
    }
    public boolean isPhoneErrorPresent(){ return isDisplayed(phoneErrorCss);}
    public FluentRegistrationPage enterPhone(String phone){
        waitAndSendKeys(phoneTxtCss,phone);
        return this;
    }
}
