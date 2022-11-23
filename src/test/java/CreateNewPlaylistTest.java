import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateNewPlaylistTest {
    @Test
    public static void CreateNewPlaylist () {

        String url = " https://bbb.testpro.io/ ";
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();

        String email = "dcabdi@gmail.com";
        String password = "te$t$tudent";

        WebElement emailAddressField = driver.findElement(By.cssSelector("input[type='email']"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password'][placeholder = 'Password']"));
        WebElement loginButton= driver.findElement(By.cssSelector("button[type='submit']"));

        emailAddressField.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        passwordField.sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginButton.click();

        WebElement createPlaylistButton = driver.findElement(By.xpath("//i[@title='Create a new playlist']"));
        createPlaylistButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement newPlaylistButton = driver.findElement(By.xpath("//*[@id=\"playlists\"]/nav/ul/li[1]"));
        newPlaylistButton.click();

        WebElement playlistFieldName = driver.findElement(By.xpath("//*[@id=\"playlists\"]/form/input"));
        playlistFieldName.sendKeys("Playlist1");
        playlistFieldName.sendKeys(Keys.RETURN);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement firstPlaylistResult = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        System.out.println(firstPlaylistResult.getText());

        Assert.assertTrue(firstPlaylistResult.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.quit();
    }
}
