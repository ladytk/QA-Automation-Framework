package POM.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage{
    @FindBy(css = "[type='email']")
    private WebElement emailField;
    @FindBy(css = "[type='password']")
    private WebElement passwordField;
    @FindBy(css = "[type='submit']")
    private WebElement submitButtonLocator;

    public LoginPage( WebDriver givenDriver ) {
        super(givenDriver);
    }
    public LoginPage clickSubmitBtn() {
        submitButtonLocator.click();
        return this;
    }
    public LoginPage provideEmail(String email)  {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public HomePage login(){

        provideEmail("dcabdi@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        return new HomePage(driver);
    }
    public boolean isPageOpened() {
        return driver.getCurrentUrl().contains("https://bbb.testpro.io");
    }
}
