import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;


public class BaseTest {

    @BeforeSuite
    public void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }

    WebDriver driver;
    }