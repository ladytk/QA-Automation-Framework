import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static String url;
    public static WebDriverWait wait;
    public static Actions action;
    public static ThreadLocal<WebDriver> threadDriver;
    
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
    public static WebDriver getDriver() {
        return threadDriver.get();
    }
    @BeforeMethod
    @Parameters({"BaseUrl"})
    public static void launchBrowser(@Optional String BaseUrl) throws MalformedURLException {

        BaseUrl = "https://bbb.testpro.io";
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);

        action = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        url = BaseUrl;
        getDriver().get(url);
    }
    public static WebDriver lambdaTest() throws MalformedURLException {

        String username = "dcabdi";
        String authkey = "YGR6858gI4iuTWrwrfJPuRSU52h1C4d0QiuFQ0ieHWlXEsDs6b";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "107.0");
        capabilities.setCapability("platform", "MacOS Ventura");
        capabilities.setCapability("resolution","1920x1080");
        capabilities.setCapability("build", "TestNG With Java");
        capabilities.setCapability("name", "Login Test");
        capabilities.setCapability("plugin", "git-testing");

        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), capabilities);
    }
    private static WebDriver pickBrowser(String browser) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://10.0.0.48:4444";

        switch (browser){
            case "firefox":
                System.setProperty("webdriver.gecko.driver","geckodriver");
                return driver = new FirefoxDriver();
            case "safari":
                return driver = new SafariDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName" , "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari":
                capabilities.setCapability("browserName" , "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName" , "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                return driver = new ChromeDriver();
        }
    }
    @AfterMethod
    public static void tearDownBrowser() {
        getDriver().quit();
        threadDriver.remove();
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

        WebElement soundBarVisualizer = driver.findElement(By.xpath("//button[@title='Click for a marvelous visualizer!']"));
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.songs"))).click();
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
        waitForVisibilityOfElement(playlistInputField);
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL + "a", Keys.BACK_SPACE)));
        playlistInputField.sendKeys("Summer Songs");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public void choosePlaylist() {

        WebElement playlist = driver.findElement(By.cssSelector(".playlist:nth-child(4)"));
        waitForElementToBeClickable(playlist);
    }
    public void doubleClickChoosePlaylist() {

        WebElement webElement = driver.findElement(By.cssSelector(".playlist:nth-child(4)"));
        waitForElementToBeClickable(webElement);
        new Actions(driver).doubleClick(webElement).perform();
    }
    protected void waitForElementToBeClickable(WebElement webElementLocator) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .elementToBeClickable(webElementLocator));
    }
    protected void waitForVisibilityOfElement(WebElement webElementLocator) {

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOf(webElementLocator));
    }
}


