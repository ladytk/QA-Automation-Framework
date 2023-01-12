package Auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoLoginPage extends AutoBasePage {

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
    public AutoLoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public AutoLoginPage clickSubmitBtn(){
        submitButton.click();
        return this;
    }

    public AutoLoginPage provideEmail(String email){
        emailField.sendKeys(email);
        return this;
    }

    public AutoLoginPage providePassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public AutoHomePage login(){
        provideEmail("trangoishi99@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        return new AutoHomePage(driver);
    }


    public boolean isPageOpened() {
        return driver.getCurrentUrl().contains("https://bbb.testpro.io");
    }
}
