package InternSearch.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageSearch extends BasePageSearch {

    // Declaring the locators
    //By emailFieldLocator = By.cssSelector("[type='email']");
    @FindBy(css="[type='email']")
    WebElement emailField;
    //By passwordFieldLocator = By.cssSelector("[type='password']");
    @FindBy(css="[type='password']")
    WebElement passwordField;
    //By submitButtonLocator = By.cssSelector("[type='submit']");
    @FindBy(css="[type='submit']")
    WebElement submitButton;

    //passing the driver from our LoginTests page
    public LoginPageSearch(WebDriver givenDriver){
        super(givenDriver);
    }

    public LoginPageSearch clickSubmitBtn(){
        submitButton.click();
        return this;
    }

    public LoginPageSearch provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public LoginPageSearch providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public HomePageSearch login(){
        provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        return new HomePageSearch(driver);
    }


    public boolean isPageOpened() {
        return driver.getCurrentUrl().contains("https://bbb.testpro.io");
    }
}