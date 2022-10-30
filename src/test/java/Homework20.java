import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework20 {

    @Test
    public void deletePlaylist() {
        playlistSelect();
        deletePlaylistButton();
        validateDeleted();

    }

    private void validateDeleted() {
        WebElement validateDeleted = driver.findElement(By.xpath("//div[@class='success show']"));
        Assert.assertTrue(validateDeleted.isDisplayed());
    }

    private void deletePlaylistButton()  {
        String xpaths = ("//button[@class='del btn-delete-playlist']");
        WebElement deletePlaylistButton = driver.findElement(By.xpath(xpaths));
        deletePlaylistButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpaths)));
    }

    private void playlistSelect() {
        WebElement playlistSelect = driver.findElement(By.xpath("//li[@class='playlist playlist']"));
        playlistSelect.click();

    }

    WebDriver driver;
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BaseURL);

        WebElement emailBox = driver.findElement(By.cssSelector("[type='email']"));
        emailBox.click();
        emailBox.sendKeys("tasiakwiggins@gmail.com");

        WebElement passwordBox = driver.findElement(By.cssSelector("[type='password']"));
        passwordBox.click();
        passwordBox.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='homeWrapper']//div[@class='heading-wrapper']")));
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
//    Create a new file Homework20.java file with @Test annotation in IntelliJ IDEA
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