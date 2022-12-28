package homeworks.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPageHmw extends BasePageHmw{
    By shufflebuttonLocator= By.cssSelector(".btn-shuffle-all");
    By firstSongLocator=By.cssSelector("tr.song-item");


    public AllSongsPageHmw (WebDriver givenDriver) {
        super(givenDriver);
    }

    public AllSongsPageHmw shuffle() {
driver.findElement(shufflebuttonLocator).click();
return this;
    }
    public AllSongsPageHmw clickFirstSong(){
        actions.doubleClick(driver.findElement(firstSongLocator));
        return this;
    }
    public AllSongsPageHmw contextClickFirstSong() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        actions.contextClick(firstSong).perform();
        return this;
    }
    public AllSongsPageHmw playFromContextMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback"))).click();
        return this;
    }
}
