package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class HomePage extends BasePage{
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private final By avatarLocator = By.cssSelector("img[alt='Avatar of Abdi']");
    public WebElement getUserAvatar () {
        return driver.findElement(avatarLocator);
    }
    public boolean isUserAvatarDisplayed() {
        return  driver.findElement(avatarLocator).isDisplayed();
    }
}

