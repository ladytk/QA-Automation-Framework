import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 {


    @Test
    public void playSong() throws InterruptedException {
        enterEmail("tasiakwiggins@gmail.com");
        enterPassword("te$t$tudent");
        submitButton();

        viewAllSongs();
        selectSong();
        playingSong();
        validateSongPlays();
    }

    private void validateSongPlays() {
        WebElement validateSongPlays = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer!']"));
        Assert.assertTrue(validateSongPlays.isDisplayed());
    }

    public void playingSong() throws InterruptedException {
        WebElement playingSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        playingSong.click();
        Thread.sleep(2000);
        WebElement playPauseButton = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        playPauseButton.click();
    }

    public void selectSong() {
        WebElement selectSong = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'Epic Cinematic')]"));
        selectSong.click();
    }

    public void viewAllSongs() throws InterruptedException {
        WebElement allSongs = driver.findElement(By.xpath("//a[text()='All Songs']"));
        allSongs.click();
        Thread.sleep(2000);
    }
    WebDriver driver;
    @BeforeMethod
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);
    }
    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    public void submitButton() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(1000);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath("//*[@type='password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath("//*[@type='email']"));
        emailField.sendKeys(email);
    }

    }

//    Create a new file Homework18.java file with @Test annotation in IntelliJ IDEA
//        Create a test case playSong() using @Test annotations
//        Use the helper/reusable methods we created
//        Create a new config XML file for the test case
//        Specify the method to be ran in the XML file
//        Navigate to "https://bbb.testpro.io/"
//        Log in with your credentials
//        Play a song
//        Validate that a song is playing
