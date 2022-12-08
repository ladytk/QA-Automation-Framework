package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class MyBaseTest {

   static WebDriver driver;
    static Actions actions;
   static ThreadLocal<WebDriver> threadDriver;
   static String url;
   static WebDriverWait wait;

    @BeforeSuite
    public static void chromeConfigs() {

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        } else {
            System.setProperty("webdriver.chrome.driver", "Untitled/chromedriver");
        }

    }

    public static WebDriver lambdaTest() throws MalformedURLException{
        String username = "bisolofinmakin";
        String accessKey = "qGd35ejfnh7j3dvVBZvdSUXI41vvexbsSvhwJhpRn6xvwr7GKt";
        String hub="@hub.lambdatest.com/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("resolution","1024x768");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "108.0");
        capabilities.setCapability("build", "TestNGHomework20 With Java");
//       capabilities.setCapability("name", this.getClass(),getName());
        capabilities.setCapability("plugin", "git-testing");
        return new RemoteWebDriver(new URL("https://" + username+":" + accessKey + hub),capabilities);
    }



    @BeforeMethod

    @Parameters({"baseURL"})

    public static void launchBrowser(@Optional String baseURL) throws MalformedURLException {

DesiredCapabilities capabilities= new DesiredCapabilities();
capabilities.setCapability("browserName","chrome");

        if (baseURL == null)
            baseURL = "https://bbb.testpro.io";

        threadDriver= new ThreadLocal<>();
//       System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver= pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);

//        actions = new Actions(getDriver());

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        url = baseURL;
//        driver.get(url);
//        actions = new Actions(driver);
//        // Make webdriver load the pages REALLY slow
//        WebDriver augmentedDriver = new Augmenter().augment(driver);
//        ChromiumNetworkConditions networkConditions = new ChromiumNetworkConditions();
//        networkConditions.setDownloadThroughput(100 * 1024);
//        networkConditions.setUploadThroughput(500 * 1024);
//        networkConditions.setLatency(Duration.ofMillis(5000));
//        ((HasNetworkConditions) augmentedDriver).setNetworkConditions(networkConditions);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        url = baseURL;
        getDriver().get(url);

    }

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

        public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL="http://192.168.1.196:4444";

     switch(browser){
         case "firefox":
             System.setProperty("webdriver.gecko.driver","geckodriver.exe");
             return driver =new FirefoxDriver();
         case "MicrosoftEdge":
             System.setProperty("webdriver.edge.driver","msedgedriver.exe");
             return driver =new EdgeDriver();

         case "grid-edge":
             caps.setCapability("browserName","MicrosoftEdge");
             return driver= new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
         case "grid-firefox":
             caps.setCapability("browserName","firefox");
             return driver= new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
         case "grid-chrome":
             caps.setCapability("browserName","chrome");
             return driver= new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
         case"cloud":
             return lambdaTest();
         default:
             return driver =new ChromeDriver();
     }
    }




    @AfterMethod
    public void tearDownBrowser() {
        getDriver().quit();
        threadDriver.remove();
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

