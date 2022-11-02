import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public static String url;
    public static WebDriverWait wait;
    public static Actions action;

    public static void browserConfigs() {

        driver.get(url);
        action = new Actions(driver);
        url = "https://bbb.testpro.io/";
        driver.manage().window().maximize();
        provideEmail("dcabdi@gmail.com");
        providePassword("te$t$tudent");
    }
    @DataProvider(name = "InvalidCredentials")
    public static Object [][] getDataFromDataProviders(){
        return new Object[][] {
                {"invalid@class.com", "invalidPass"},
                {"d@clas.com", ""},
                {"" , ""}
        };
    }
    protected static void playlistWasDeleted() {

        WebElement deletedAlert = driver.findElement(By.xpath("//div[@class='alertify-logs top right']"));
        Assert.assertTrue(deletedAlert.isDisplayed());
    }
    protected static void playlistDeleteBtn() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']"))).click();
    }
    protected static void playlistToDelete() {

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#!/playlist/26571']"))).click();
    }
    public static boolean isSongPlaying() {

        WebElement soundBarVisualizer = driver.findElement(By.cssSelector(".playback"));
        return soundBarVisualizer.isDisplayed();
    }
    public static void choosePlay() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playback"))).click();
    }
    public static void getContextMenu() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        WebElement firstSong = driver.findElement(By.cssSelector(".all-songs tr.song-item:nth-child(1)"));
        action.contextClick(firstSong).perform();
    }
    public static void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();
    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public void launchBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        url = "https://bbb.testpro.io/";
        driver.get(url);
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
    protected static void validation() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("a[href*='playlist/24815']"))).click();
        WebElement songWasAdded = driver.findElement(By.xpath("//tr[@class='song-item']//td[contains(text(),'Epic Song')]"));
        Assert.assertTrue(songWasAdded.isDisplayed());
    }
    protected static void abdisPlaylist() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id='songsWrapper']//li[5]"))).click();
    }
    protected static void addSongToPlaylistBtn() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-add-to']"))).click();
    }
    protected static void addingNewSong() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@class='song-item']//td[contains(text(),'Epic Song')]"))).click();
    }
    protected static void allSongsTab() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='songs']"))).click();
    }
    protected static void songBeginsToPlay() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='sound-bar-play']"))).click();
        WebElement soundBarPlaySong = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBarPlaySong.isDisplayed());
    }
    protected static void songSelection() {

        Actions act = new Actions(driver);
        WebElement songSelected = driver.findElement(By.xpath("//*[@id=\"recentlyPlayedWrapper\"]/div/div/div[1]/table/tr[1]/td[2]"));
        act.doubleClick(songSelected).perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    protected static void recentlyPlayedTab()  {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[2]/a"))).click();
    }
    public void clickAvatarIcon() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[contains(@alt,'Avatar of')]"))).click();
    }
    public WebElement hoverPlay() {
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        action.moveToElement(play).perform();
        return driver.findElement(By.cssSelector("[data-testid='play-btn']"));
    }
    public boolean doesPlaylistExist() {

        WebElement playlistElement = driver.findElement(By.xpath("//a[text()='Summer Songs']"));
        return playlistElement.isDisplayed();
    }
    public void enterPlaylistName() {

        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name='name']"));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE));
        playlistInputField.sendKeys("Summer Songs");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public void choosePlaylist() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
    }
    public void doubleClickChoosePlaylist() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
        WebElement webElement = driver.findElement(By.cssSelector(".playlist:nth-child(4)"));
        action.moveToElement(webElement).perform();
    }
    @AfterMethod
    public static void tearDownBrowser() {
        driver.quit();
    }
}


