package homeworks.POM.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePageHmw extends BasePageHmw {
    By avatarLocator = By.cssSelector("img.avatar");
    By soundBarPlayLocator =By.cssSelector("[data-testid='sound-bar-play']");
    By playButton= By .cssSelector("[data-testid='play-btn']");
    public HomePageHmw(WebDriver sentDriver) {
        super(sentDriver);
    }

    public WebElement getUserAvatar() {

        return driver.findElement(avatarLocator);
    }

    public boolean isUserAvatarDisplayed() {
        return driver.findElement(avatarLocator).isDisplayed();
    }
    public boolean isSongPlaying() {
        WebElement visualizer = driver.findElement(soundBarPlayLocator);
        Assert.assertTrue(visualizer.isDisplayed());
        return visualizer.isDisplayed();
    }
    public void myPlaylist() throws InterruptedException {
        WebElement myPlaylist = driver.findElement(By.xpath("  //section[@id='playlists']//a[@class='active']"));
        myPlaylist.click();
        By newPlaylistLocator = By.xpath("//section[@id='playlists']//a[@class='active']");
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(newPlaylistLocator), "Abby"));
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistLocator));
    }
    public void delPlaylist() throws InterruptedException {
        WebElement delPlaylist = driver.findElement(By.xpath("//nav[@class='menu playlist-item-menu']//*[contains(text(),'Delete')]"));
        WebElement deletePlaylistLocator= driver.findElement(By.xpath("//nav[@class='menu playlist-item-menu']//*[contains(text(),'Delete')]"));
        wait.until(ExpectedConditions.visibilityOf( deletePlaylistLocator));

    }
    public String getConfirmationText(String deleted_playlist) {

        return driver.findElement(By.xpath("//p[@class='msg']")).getText();

    }

    public boolean doesPlaylistExist() {
        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Sucre']"));
        return playlistElement.isDisplayed();

    }
    public void enterPlaylistName() {
        WebElement playlistInputField = driver.findElement(By.xpath("//*[contains(text(),'Edit')]"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("Sucre");
        wait.until(ExpectedConditions.textToBePresentInElement(playlistInputField,"Sucre"));
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public void doubleClickChoosePlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        WebElement element = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        actions.doubleClick(element).perform();
    }
}
