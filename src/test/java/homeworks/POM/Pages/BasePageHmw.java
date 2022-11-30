package homeworks.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageHmw {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    By allSongsMenuItemLocator =By.cssSelector(" li a.songs");
    By avatarLocator = By.cssSelector("img.avatar");
    By soundBarPlayLocator = By.cssSelector("[data-testid = 'sound-bar-play']");

    public BasePageHmw(WebDriver givenDriver){
        driver= givenDriver;
        wait =new WebDriverWait(driver, Duration.ofSeconds(5));
        actions =new Actions(driver);
        PageFactory.initElements(driver,this);
    }
    public WebElement getUserAvatar(){
        return driver.findElement(avatarLocator);
    }

    public boolean isUserAvatarDisplayed(){
        return driver.findElement(avatarLocator).isDisplayed();
    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(soundBarPlayLocator);
        return soundBarVisualizer.isDisplayed();
    }
    public  AllSongsPageHmw clickOnAllSongs(){
        driver.findElement(allSongsMenuItemLocator).click();
        return new AllSongsPageHmw(driver);
    }
//    public  WebElement hoverPlay() {
//        WebElement play=driver.findElement(By.cssSelector("[data-testid='play-btn']"));
//        actions.moveToElement(play).perform();
//        return play;
//    }

}
