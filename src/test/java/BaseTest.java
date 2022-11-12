import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;
    ThreadLocal<WebDriver> threadDriver;

    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }
    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {
//        driver = new ChromeDriver();
//        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//        driver = new FirefoxDriver();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "chrome");
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(driver);
        actions = new Actions(getDriver());
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        getDriver().get(baseURL);
    }
    public WebDriver getDriver() {
        return threadDriver.get();
    }
    public WebDriver lambdaTest() throws MalformedURLException {
        String username = "tasiakwiggins";
        String accessKey = "ZNnbFhf6rgESlHPGlvZcNSnEMrwcWD4Pi0vrdC8pawiCnjHqSP";
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "107.0");
        caps.setCapability("platform", "Windows 11");
        caps.setCapability("resolution","1024x768");
        caps.setCapability("build", "First Test");
        caps.setCapability("name", this.getClass().getName());
        caps.setCapability("plugin", "git-testing");
        caps.setCapability("network", true); // To enable network logs
        caps.setCapability("visual", true); // To enable step by step screenshot
        caps.setCapability("video", true); // To enable video recording
        caps.setCapability("console", true); // To capture console logs
        return new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + hub), caps);
    }
    public WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.12.222:4444";
        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                return driver = new FirefoxDriver();
            case "msedge":
                System.setProperty("webdriver.msedge.driver", "msedgedriver.exe");
                return driver = new EdgeDriver();
            case "grid-firefox":
                caps.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-msedge":
                caps.setCapability("browserName", "edge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
            case "cloud":
                return lambdaTest();
            default:
                return driver = new ChromeDriver();

        }
    }

    @AfterMethod
    public void endSession () {
        getDriver().quit();
        threadDriver.remove();
    }
}


