package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;

public class Homework19A extends MyBaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        login();
        myPlaylist();
        delPlaylist();
//        doesPlaylistExist();
        Assert.assertTrue(getConfirmationText().contains("Deleted Playlist"));

    }
    private String getConfirmationText() {
        return driver.findElement(By.xpath("//p[@class='msg']")).getText();
    }
    private void myPlaylist() throws InterruptedException {
        WebElement myPlaylist = driver.findElement(By.xpath("  //section[@id='playlists']//a[@class='active']"));
        myPlaylist.click();
        By newPlaylistLocator = By.xpath("//section[@id='playlists']//a[@class='active']");
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(newPlaylistLocator), "Abby"));
        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistLocator));
    }
    private void delPlaylist() throws InterruptedException {
        WebElement delPlaylist = driver.findElement(By.xpath("//nav[@class='menu playlist-item-menu']//*[contains(text(),'Delete')]"));
        WebElement deletePlaylistLocator= driver.findElement(By.xpath("//nav[@class='menu playlist-item-menu']//*[contains(text(),'Delete')]"));
        wait.until(ExpectedConditions.visibilityOf( deletePlaylistLocator));

        }
//  private boolean doesPlaylistExist(){
//   WebElement doesPlaylistExist = driver.findElement(By.xpath("//section[@id='playlists']//a[@class='active']"));
//   return doesPlaylistExist.isDisplayed();
//    }
}



