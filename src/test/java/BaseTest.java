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
import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    Actions actions;
    WebDriverWait wait;

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
        driver = pickBrowser(System.getProperty("browser"));

        actions = new Actions(driver);
        driver.get(baseURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
            default:
                return driver = new ChromeDriver();

        }
    }

    @AfterMethod
    public void endSession () {

        driver.quit();
    }
}


