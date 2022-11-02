import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hw21 extends BaseTest {
    @Test(priority = 1, description = "Playing a Song & Validating")
    @Parameters({"BaseUrl"})
    public static void playASong() {

        browserConfigs();
        clickSubmitBtn();
        chooseAllSongsList();
        getContextMenu();
        choosePlay();
        Assert.assertTrue(isSongPlaying());
    }
    private static boolean isSongPlaying() {

        WebElement soundBarVisualizer = driver.findElement(By.cssSelector(".playback"));
        return soundBarVisualizer.isDisplayed();
    }
    private static void choosePlay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback"))).click();
    }
    private static void getContextMenu() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        actions.contextClick(firstSong).perform();
    }
    private static void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    @Test(priority = 2, description = "Hover, Play, and Validate")
    @Parameters({"BaseUrl"})
    public void hoverOverPlayButton() {

        browserConfigs();
        clickSubmitBtn();
        chooseAllSongsList();
        hoverPlay();
        Assert.assertTrue(hoverPlay().isDisplayed());
    }
    private WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return driver.findElement(By.cssSelector("[data-testid='play-btn']"));
    }
    @Test(priority = 3, description = "Editing Playlist Name and Validating")
    @Parameters({"BaseUrl"})
    public void renamePlaylist()  {

        browserConfigs();
        clickSubmitBtn();
        doubleClickChoosePlaylist();
        choosePlaylist();
        enterPlaylistName();
        doesPlaylistExist();
    }
    private boolean doesPlaylistExist() {

        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Summer Songs']"));
        return playlistElement.isDisplayed();
    }
    private void enterPlaylistName() {

        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys("Summer Songs");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    private void choosePlaylist() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
    }
    private void doubleClickChoosePlaylist() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
        WebElement webElement = driver.findElement(By.cssSelector(".playlist:nth-child(4)"));
        actions.doubleClick(webElement).perform();
    }
}

