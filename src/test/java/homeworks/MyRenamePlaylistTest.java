package homeworks;

import homeworks.POM.Pages.HomePageHmw;
import homeworks.POM.Pages.LoginPageHmw;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyRenamePlaylistTest extends MyBaseTest {
    @Test
    public void renamePlaylist() throws InterruptedException {
        LoginPageHmw loginPageHmw= new LoginPageHmw(driver);
        HomePageHmw homePageHmw=new HomePageHmw(driver);

        loginPageHmw.login();
        homePageHmw.myPlaylist();
        homePageHmw.doubleClickChoosePlaylist();
        homePageHmw.enterPlaylistName();
        Assert.assertTrue(homePageHmw.doesPlaylistExist());
    }

//    private boolean doesPlaylistExist() {
//        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Sucre']"));
//        return playlistElement.isDisplayed();
//
//    }
//    private void enterPlaylistName() {
//        WebElement playlistInputField = driver.findElement(By.xpath("//*[contains(text(),'Edit')]"));
//        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE)));
//        playlistInputField.sendKeys("Sucre");
//        wait.until(ExpectedConditions.textToBePresentInElement(playlistInputField,"Sucre"));
//        playlistInputField.sendKeys(Keys.ENTER);
//    }
//    private void doubleClickChoosePlaylist() {
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
//        WebElement element = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
//        actions.doubleClick(element).perform();
//    }

}
