import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class PlaySong extends BaseTest{
    @Test
    public void playSong()  {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("tasiakwiggins@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitButton();
        Assert.assertTrue(homePage.isUserAvatarDisplayed());

        viewAllSongs();
        selectSong();
        playingSong();
        validateSongPlays();
    }

    private void validateSongPlays() {
        String songValidation = "//button[@title='Click for a marvelous visualizer!']";
        WebElement validateSongPlays = driver.findElement(By.xpath(songValidation));
        Assert.assertTrue(validateSongPlays.isDisplayed());
    }

    public void playingSong()  {
        String playButton = "//span[@data-testid='play-btn']";
        String songsPlaying = "//i[@data-testid='play-next-btn']";
        WebElement playingSong = driver.findElement(By.xpath(songsPlaying));
        playingSong.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(playButton)));
        WebElement playPauseButton = driver.findElement(By.xpath(playButton));
        playPauseButton.click();
    }

    public void selectSong() {
        String songSelection = "//tr[@class='song-item']//td[contains(text(),'Epic Cinematic')]";
        WebElement selectSong = driver.findElement(By.xpath(songSelection));
        selectSong.click();
    }

    public void viewAllSongs() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='All Songs']"))).click();
        String clickAllSongs = "//a[text()='All Songs']";
        WebElement allSongs = driver.findElement(By.xpath(clickAllSongs));
        allSongs.click();
    }

}
