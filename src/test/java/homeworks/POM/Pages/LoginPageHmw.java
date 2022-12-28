package homeworks.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPageHmw extends BasePageHmw {
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement submitButton;

    public LoginPageHmw(WebDriver givenDriver) {

        super(givenDriver);
    }

    public LoginPageHmw provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPageHmw providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPageHmw clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public HomePageHmw login() {
        provideEmail("abisola@yahoo.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();
        return new HomePageHmw(driver);
    }

    public boolean isPageOpened() {
        return driver.getCurrentUrl().contains("https://bbb.testpro.io");
    }

    public boolean isAvatarIconPresent() {
        WebElement avatarIconElement = driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
        return avatarIconElement.isDisplayed();
    }
}



