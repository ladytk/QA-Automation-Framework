package InternSearch.pages;

import POM.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPageSearch extends BasePageSearch {

    //Locators
    By shuffleBtnLocator = By.cssSelector(".btn-shuffle-all");
    By firstSongLocator = By.cssSelector(".play");

    public AllSongsPageSearch(WebDriver givenDriver) {
        super(givenDriver);
    }

    public AllSongsPageSearch shuffle() {
        driver.findElement(shuffleBtnLocator).click();
        return this;
    }

    public void doubleClickFirstSong() {
        actions.doubleClick(driver.findElement(firstSongLocator));
    }

    public void contextClickFirstSong() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        actions.contextClick(firstSong).perform();
    }

    public void playFromContextMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback"))).click();
    }
}
