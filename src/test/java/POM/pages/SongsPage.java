package POM.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SongsPage extends BasePage{
    private final By shuffleBtnLocator = By.cssSelector(".btn-shuffle-all");
    private final By firstSongLocator = By.cssSelector(".play");
    private final By soundBarPlayLocator = By.cssSelector("[data-testid = 'sound-bar-play']");

    private final By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    public SongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public SongsPage shuffle() {
        driver.findElement(shuffleBtnLocator).click();
        return this;
    }
    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = driver.findElement(soundBarPlayLocator);
        return soundBarVisualizer.isDisplayed();
    }

    public void doubleClickFirstSong() {
        actions.doubleClick(driver.findElement(firstSongLocator));
    }
    public void contextClickFistSong() {
        wait.until(ExpectedConditions.visibilityOf((WebElement) firstSong));
        actions.contextClick((WebElement) firstSong).click();
    }
    public void playFromContextMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback"))).click();
    }
}
