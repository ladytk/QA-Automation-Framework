package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    By avatarLocator = By.cssSelector("img.avatar");

    public HomePage(WebDriver sentDriver) { //sentDriver can be named anything
        super(sentDriver);
    }
    public WebElement getUserAvatar() {
        return driver.findElement(avatarLocator);
    }
    public boolean isUserAvatarDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        return driver.findElement(avatarLocator).isDisplayed();
    }
}
