package homeworks;

import homeworks.POM.Pages.AllSongsPageHmw;
import homeworks.POM.Pages.BasePageHmw;
import homeworks.POM.Pages.HomePageHmw;
import homeworks.POM.Pages.LoginPageHmw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PlaySngClswk21 extends MyBaseTest {
    @Test
    public void playASong() {
        LoginPageHmw loginPageHmw= new LoginPageHmw(driver);
        AllSongsPageHmw allSongsPageHmw= new AllSongsPageHmw(driver);
        HomePageHmw homePageHmw=new HomePageHmw(driver);

        loginPageHmw.login()
        .clickOnAllSongs();
        allSongsPageHmw .contextClickFirstSong();
        allSongsPageHmw.playFromContextMenu();
        Assert.assertTrue(allSongsPageHmw.isSongPlaying());
        }

    public boolean isSongPlaying(){
        WebElement soundBarVisualizer = driver.findElement(By.cssSelector("[data-testid = 'sound-bar-play']"));
        return soundBarVisualizer.isDisplayed();
    }
    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }

    @Test
    public void hoverOverPlayButton(){

            login();
            chooseAllSongsList();
            hoverPlay();
            Assert.assertTrue(hoverPlay().isDisplayed());
            hoverPlay().click();
            Assert.assertTrue(isSongPlaying());
        }

    public WebElement hoverPlay() {
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
