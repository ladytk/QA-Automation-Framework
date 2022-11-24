package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaySongHmw18 extends MyBaseTest {
    @Test
    public void playASong() throws InterruptedException {
            login();
            clickSubmitBtn();
        isAllSongsHeaderPresent();
            clickAllSongs();
            String getSongTitle = getSongTitleText();
            playANewSong();
        }
        private void playANewSong () {
        Assert.assertTrue(isAllSongsHeaderPresent());
        clickOnASong();
            clickPlay();
            String verifySongPlays = getVerifySongPlays();
            Assert.assertEquals(verifySongPlays, getSongTitleText());

        }
    private boolean isAllSongsHeaderPresent() {
        WebElement allSongPageTitle = driver.findElement(By.xpath("//h1[normalize-space()='All Songs']"));
        return allSongPageTitle.isDisplayed();

    }
        private String getVerifySongPlays () {
            WebElement verifySong = driver.findElement(By.xpath("//section[@id='songsWrapper']//tr[@class='song-item selected']//td[@class='title']"));
            return verifySong.getText();
        }
        private String getSongTitleText () {
            WebElement getTitleText = driver.findElement(By.xpath("//section[@id='songsWrapper']//tr[@class='song-item selected']//td[@class='title']"));
            return getTitleText.getText();
        }

        private void clickPlay () {
            WebElement clickPlay = driver.findElement(By.xpath("//*[@title='Play or resume']"));
            clickPlay.click();
            Assert.assertTrue(driver.findElement((By) clickPlay).isEnabled());

            WebElement Visualizer = driver.findElement(By.xpath("//button[@data-testid='toggle-visualizer-btn']//img[@alt='Sound bars']"));
            Assert.assertTrue(Visualizer.isDisplayed());
        }
        private void clickAllSongs () throws InterruptedException {

            WebElement allSongs = driver.findElement(By.xpath("//a[@class='songs active']"));
            allSongs.click();
            By clickAllSongs = By.xpath("//a[@class='songs active']");
            wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(clickAllSongs), "All Songs"));
            wait.until(ExpectedConditions.elementToBeClickable(clickAllSongs));

        }
    private void clickOnASong() {
        WebElement clickOnASong = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        clickOnASong.click();
    }



        }


