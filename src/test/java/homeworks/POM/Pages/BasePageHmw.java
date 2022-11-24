package homeworks.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePageHmw {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    By allSongsMenuItemLocator =By.cssSelector(" li a.songs");

    public BasePageHmw(WebDriver givenDriver){
        driver= givenDriver;
        wait =new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickOnAllSongs(){
      driver.findElement(allSongsMenuItemLocator).click();
    }

}
