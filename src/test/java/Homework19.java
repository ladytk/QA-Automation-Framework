import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 {
    
    @Test
    public void deletePlaylist() throws InterruptedException {
        playlistSelect();
        deletePlaylistButton();
        validateDeleted();

    }

    private void validateDeleted() {
        WebElement validateDeleted = driver.findElement(By.xpath("//div[@class='success show']"));
        Assert.assertTrue(validateDeleted.isDisplayed());
    }

    private void deletePlaylistButton() throws InterruptedException {
        WebElement deletePlaylistButton = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deletePlaylistButton.click();
        Thread.sleep(1000);
    }

    private void playlistSelect() {
        WebElement playlistSelect = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        playlistSelect.click();

    }

    WebDriver driver;
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = BaseURL;
        driver.get(url);

        WebElement emailBox = driver.findElement(By.cssSelector("[type='email']"));
        emailBox.click();
        emailBox.sendKeys("tasiakwiggins@gmail.com");

        WebElement passwordBox = driver.findElement(By.cssSelector("[type='password']"));
        passwordBox.click();
        passwordBox.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        Thread.sleep(2000);
    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
//    Create a new file Homework19.java file with @Test annotation in IntelliJ IDEA
//        Create a test case deletePlaylist() using @Test annotations
//        Use the helper/reusable methods we created
//        Use @Parameters for passing baseUrl from the TestNG config file to the tests
//        Navigate to "https://bbb.testpro.io/"
//        Log in with your credentials
//        Choose a playlist
//        Delete the playlist
//        Validate that the playlist is deleted
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework