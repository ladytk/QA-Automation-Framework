package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(css = "[type='email']")
    WebElement emailFieldLocator;
    @FindBy(css = "[type='password']")
    WebElement passwordFieldLocator;
    @FindBy(css = "[type='submit']")
    WebElement submitButtonLocator;
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
        public LoginPage clickSubmitButton () {
            submitButtonLocator.click();
            return this;
        }
        public LoginPage provideEmail (String email){
            emailFieldLocator.sendKeys(email);
            return this;
        }
        public LoginPage providePassword (String password){
            passwordFieldLocator.sendKeys(password);
            return this;
        }
        public void login() {
        provideEmail("tasiakwiggins@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitButton();
        }
    }
