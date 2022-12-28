package homeworks;

import homeworks.POM.Pages.HomePageHmw;
import homeworks.POM.Pages.LoginPageHmw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyDeletePlaylistTest extends MyBaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        LoginPageHmw loginPageHmw= new LoginPageHmw(driver);
        HomePageHmw homePageHmw=new HomePageHmw(driver);
        loginPageHmw.login();
         homePageHmw.myPlaylist();
        homePageHmw.delPlaylist();
//        Assert.assertTrue(getConfirmationText().contains("Deleted Playlist"));
        Assert.assertTrue(Boolean.parseBoolean(homePageHmw.getConfirmationText("Deleted Playlist")));

    }
//    public String getConfirmationText() {
//
//        return driver.findElement(By.xpath("//p[@class='msg']")).getText();
//    }
//    private void myPlaylist() throws InterruptedException {
//        WebElement myPlaylist = driver.findElement(By.xpath("  //section[@id='playlists']//a[@class='active']"));
//        myPlaylist.click();
//        By newPlaylistLocator = By.xpath("//section[@id='playlists']//a[@class='active']");
//        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(newPlaylistLocator), "Abby"));
//        wait.until(ExpectedConditions.elementToBeClickable(newPlaylistLocator));
//    }
//    private void delPlaylist() throws InterruptedException {
//        WebElement delPlaylist = driver.findElement(By.xpath("//nav[@class='menu playlist-item-menu']//*[contains(text(),'Delete')]"));
//        WebElement deletePlaylistLocator= driver.findElement(By.xpath("//nav[@class='menu playlist-item-menu']//*[contains(text(),'Delete')]"));
//        wait.until(ExpectedConditions.visibilityOf( deletePlaylistLocator));
//
//        }
//  private boolean doesPlaylistExist(){
//   WebElement doesPlaylistExist = driver.findElement(By.xpath("//section[@id='playlists']//a[@class='active']"));
//   return doesPlaylistExist.isDisplayed();
//    }
}



