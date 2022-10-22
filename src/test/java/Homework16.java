import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 {

    @Test
    public static void createNewPlaylist () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io";
        driver.get(url);

        WebElement emailLogin = driver.findElement(By.cssSelector("[type='email']"));
        emailLogin.click();
        emailLogin.sendKeys("tasiakwiggins@gmail.com");

        WebElement passwordBox = driver.findElement(By.cssSelector("[type='password']"));
        passwordBox.click();
        passwordBox.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        Thread.sleep(5000);

        WebElement createPlaylist = driver.findElement(By.xpath("//*[@title='Create a new playlist']"));
        createPlaylist.click();
        Thread.sleep(5000);

        WebElement createNewPlaylist = driver.findElement(By.xpath("//*[@id='playlists']/nav/ul/li[1]"));
        createNewPlaylist.click();

        WebElement playlistNamed = driver.findElement(By.xpath("//*[@id='playlists']/form/input"));
        playlistNamed.click();
        playlistNamed.sendKeys("Abbott Elementary");
        playlistNamed.submit();

        Thread.sleep(5000);
        driver.quit();

    }
}
//    Create a new file Homework16.java file with @Test annotation in IntelliJ IDEA
//        Create a test case createNewPlaylist() using @Test annotation
//        Navigate to "https://bbb.testpro.io/"
//        Log in with your credentials
//        Create a new playlist (use XPath locators to locate the elements)
//        Validate that there is a new playlist made
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework