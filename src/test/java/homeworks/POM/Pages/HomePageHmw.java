package homeworks.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePageHmw extends BasePageHmw {
    By avatarLocator = By.cssSelector("img.avatar");
    By soundBarPlayLocator =By.cssSelector("[data-testid='sound-bar-play']");
    By playButton= By .cssSelector("[data-testid='play-btn']");
    public HomePageHmw(WebDriver sentDriver) {
        super(sentDriver);
    }

    public WebElement getUserAvatar() {

        return driver.findElement(avatarLocator);
    }

    public boolean isUserAvatarDisplayed() {
        return driver.findElement(avatarLocator).isDisplayed();
    }
    public boolean isSongPlaying() {
        WebElement visualizer = driver.findElement(soundBarPlayLocator);
        Assert.assertTrue(visualizer.isDisplayed());
        return visualizer.isDisplayed();
    }


}
