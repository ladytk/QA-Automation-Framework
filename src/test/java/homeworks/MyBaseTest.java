package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class MyBaseTest {

    public WebDriver driver;
    Actions actions;
    public String url;
    public WebDriverWait wait;

    @BeforeSuite
    public static void chromeConfigs() {

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "Untitled/chromedriver");
        }

    }

    @BeforeMethod

    @Parameters({"baseURL"})

    public void launchBrowser(@Optional String baseURL) throws MalformedURLException {

        if (baseURL == null)
            baseURL = "https://bbb.testpro.io";
//        driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
//        driver= new FirefoxDriver();
        driver= pickBrowser(System.getProperty("browser"));
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = baseURL;
        driver.get(url);

//        actions = new Actions(driver);
//        // Make webdriver load the pages REALLY slow
//        WebDriver augmentedDriver = new Augmenter().augment(driver);
//        ChromiumNetworkConditions networkConditions = new ChromiumNetworkConditions();
//        networkConditions.setDownloadThroughput(100 * 1024);
//        networkConditions.setUploadThroughput(500 * 1024);
//        networkConditions.setLatency(Duration.ofMillis(5000));
//        ((HasNetworkConditions) augmentedDriver).setNetworkConditions(networkConditions);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = baseURL;
        driver.get(url);

    }

    private WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL="http://192.168.1.196:4444";
     switch(browser){
         case"firefox":
             System.setProperty("webdriver.gecko.driver","geckodriver");
             return driver =new FirefoxDriver();
         case "grid-firefox":
             caps.setCapability("browserName","firefox");
             return driver= new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
         case "grid-chrome":
             caps.setCapability("browserName","chrome");
             return driver= new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
         default:
             return driver =new ChromeDriver();


     }
    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    public void clickSubmitBtn() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
    }
    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.sendKeys(password);
    }

        public void login() {
            provideEmail("abisola@yahoo.com");
            providePassword("te$t$tudent");
            clickSubmitBtn();
        }
    }

