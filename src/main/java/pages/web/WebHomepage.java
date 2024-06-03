package pages.web;

import Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.FilterSideBar;
import pages.ProductDetailPage;
import pages.interfaces.HomePage;

import java.util.List;
import java.util.stream.Collectors;

public class WebHomepage extends BasePage implements HomePage {
    protected By homeMenuOptCss=By.cssSelector("[data-test='nav-home']");
    protected By categoriesMenuOptCss=By.cssSelector("[data-test='nav-categories']");
    protected By contactMenuOptCss=By.cssSelector("[data-test='nav-contact']");
    protected By signInMenuOptCss=By.cssSelector("[data-test='nav-sign-in']");
    protected By languageMenuOptCss=By.cssSelector("[data-test='language']");
    protected By categoriesDdnOtpCss=By.cssSelector("[class*='dropdown-menu'][aria-label='nav-categories'] li");
    protected By brandLogoCss=By.cssSelector("[class='navbar-brand']");
    protected By footerCss=By.cssSelector("app-footer");
    protected By productNameCss=By.cssSelector("[data-test='product-name']");
    protected By productPriceCss=By.cssSelector("[data-test='product-price']");
    protected By noResultsCss=By.cssSelector("[data-test='no-results']");

    public void openCategories() {
        waitAndClick(categoriesMenuOptCss);
    }

    public WebHomepage(WebDriver driver) {
        super(driver);
    }

    public void validateHeader(){
        Assert.assertTrue(isDisplayed(brandLogoCss));
        Assert.assertTrue(isDisplayed(homeMenuOptCss));
        Assert.assertTrue(isDisplayed(categoriesMenuOptCss));
        Assert.assertTrue(isDisplayed(contactMenuOptCss));
        Assert.assertTrue(isDisplayed(signInMenuOptCss));
        Assert.assertTrue(isDisplayed(languageMenuOptCss));
    }

    public String getFooterText(){
        return getText(footerCss);
    }

    public FilterSideBar getFilterBar(){
        return new FilterSideBar(driver);
    }

    public List<String> getProductNameList(){
        waitForVisible(productNameCss);
        List<WebElement> elements = driver.findElements(productNameCss);
        return elements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public List<String> getProductPriceList(){
        waitForVisible(productPriceCss);
        List<WebElement> elements = driver.findElements(productPriceCss);
        return elements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public ProductDetailPage selectProduct(int i){
        waitForVisible(productNameCss);
        List<WebElement> elements = driver.findElements(productNameCss);
        elements.get(i-1).click();
        return new ProductDetailPage(driver);
    }

    public boolean noResultsPresent(){
        return isDisplayed(noResultsCss);
    }

    public List<String> getCategoriesList(){
        waitForVisible(categoriesDdnOtpCss);
        List<WebElement> elements = driver.findElements(categoriesDdnOtpCss);
        return elements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }
}