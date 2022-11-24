package homeworks.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AllSongsPageHmw extends BasePageHmw{
    By shufflebuttonLocator= By.cssSelector(".btn-shuffle-all");
    By firstSongLocator=By.cssSelector("tr.song-item");


    public AllSongsPageHmw (WebDriver givenDriver) {
        super(givenDriver);
    }

    public void Shuffle() {
driver.findElement(shufflebuttonLocator).click();
    }
    public void clickFirstSong(){
        actions.doubleClick(driver.findElement(firstSongLocator));

    }



}
