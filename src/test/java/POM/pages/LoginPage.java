package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{
    By emailFieldLocator = By.cssSelector("[type='email']");
    By passwordFieldLocator = By.cssSelector("[type='password']");
    By submitButtonLocator = By.cssSelector("[type='submit']");
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
        public void clickSubmitButton () {
            driver.findElement(submitButtonLocator).click();
        }
        public void provideEmail (String email){
            driver.findElement(emailFieldLocator).sendKeys(email);
        }
        public void providePassword (String password){
            driver.findElement(passwordFieldLocator).sendKeys(password);
        }
        public void login() {
        provideEmail("tasiakwiggins@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitButton();
        }
    }
