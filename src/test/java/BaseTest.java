import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {

    static WebDriver driver;
    static String url;
   public static void browserConfigs() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        url = "https://bbb.testpro.io/";
        driver.manage().window().maximize();
    }

    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }

    public static void clickSubmitBtn() {
        WebElement loginButton= BaseTest.driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
    }

    public static void providePassword(String password) {
        WebElement passwordField = BaseTest.driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public static void provideEmail(String email) {
        WebElement emailField = BaseTest.driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    @AfterMethod
    public static void tearDownBrowser() {
        driver.quit();
    }

    protected static void validation() throws InterruptedException {

        WebElement myPlaylist = driver.findElement(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a"));
        myPlaylist.click();
        Thread.sleep(2000);
        WebElement songWasAdded = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'Epic Song')]"));
        Assert.assertTrue(songWasAdded.isDisplayed());
    }

    protected static void abdisPlaylist() throws InterruptedException {

        WebElement myPlaylist = driver.findElement(By.xpath("//section[@id='songsWrapper']//li[5]"));
        myPlaylist.click();
        Thread.sleep(2000);
    }

    protected static void addSongToPlaylistBtn() throws InterruptedException {

        WebElement addingTheSong = driver.findElement(By.xpath("//button[@title='Add selected songs to…']"));
        addingTheSong.click();
        Thread.sleep(2000);
    }

    protected static void songChoice() throws InterruptedException {

        WebElement choiceOfSong = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'Epic Song')]"));
        choiceOfSong.click();
        Thread.sleep(2000);
    }

    protected static void allSongsTab() throws InterruptedException {
        WebElement songsTab = driver.findElement(By.xpath("//a[@class='songs']"));
        songsTab.click();
        songsTab.click();
        Thread.sleep(2000);
    }

    public void clickAvatarIcon() {
        WebElement avatarIcon = BaseTest.driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
        avatarIcon.click();
    }

    @BeforeMethod
    public void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = "https://bbb.testpro.io/";
        driver.get(url);
    }
}
