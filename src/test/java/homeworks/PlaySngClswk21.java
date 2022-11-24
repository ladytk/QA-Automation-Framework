package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PlaySngClswk21 extends MyBaseTest {
    @Test
    public void playASong() {
        login();
        clickAllSongs();
        getContextMenu();
        choosePlay();
        Assert.assertTrue(isSongPlaying());
//        verifyVisualizer();

//        WebElement Visualizer = driver.findElement(By.xpath("//button[@data-testid='toggle-visualizer-btn']//img[@alt='Sound bars']"));
//            Assert.assertTrue(Visualizer.isDisplayed());
        }

    private void clickAllSongs() {
        By allSongsSelector= By.cssSelector(".menu.songs");
        driver.findElement(allSongsSelector).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header .song-list-controls")));
    }
    private void getContextMenu() {
/// right click and navigate to context menu
      By songLocator= By.cssSelector(".all-songs tr.song-item:nth-child(1)");
      wait.until(ExpectedConditions.visibilityOfElementLocated(songLocator));
      WebElement firstSong= driver.findElement(songLocator);
      actions.contextClick(firstSong).perform();
    }

    private void choosePlay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback"))).click();
    }

    public boolean isSongPlaying(){
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    @Test
    void hoverOverPlayButton(){
        login();

        chooseAllSongsList();
        hoverPlay();
        Assert.assertTrue(hoverPlay().isDisplayed());
        hoverPlay().click();
        Assert.assertTrue(isSongPlaying());
    }
    private WebElement hoverPlay() {
    WebElement play=driver.findElement(By.cssSelector("[data-testid='play-btn']"));
    actions.moveToElement(play).perform();
    return play;
    }

    @Test
    public void listOfSongWebElements(){
        login();
        choosePlaylistByName("ere");
        getListOfSongs();
        Assert.assertEquals(getListOfSongs().size(),3);
            
    }

    private void choosePlaylistByName(String name) {
        By playlistLocator= By.xpath("//section[@current-view='Playlist']//a[@class='active']");
      wait.until(ExpectedConditions.visibilityOfElementLocated(playlistLocator)) ;
    }

    private List getListOfSongs() {
        List<WebElement> songlist=driver.findElements(By.xpath("//*[@id='playlistWrapper']//table[@class='items']"));
    return songlist;
    }



}
