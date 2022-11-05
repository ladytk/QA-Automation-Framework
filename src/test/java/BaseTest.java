import POM.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

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
    public void launchBrowser(String baseURL) {
        driver = new ChromeDriver();
        actions = new Actions(driver);
        driver.get(baseURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));



    }
    @AfterMethod
    public void endSession () {

        driver.quit();
    }
//    public void clickSubmitButton() {
//        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
//        submitButton.click();
//    }

//    public void provideEmail(String email) {
//        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
//        emailField.click();
//        emailField.sendKeys(email);
//    }
//
//    public void providePassword(String password) {
//        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
//        passwordField.click();
//        passwordField.sendKeys(password);
//}
//    public void login() {
//    provideEmail("tasiakwiggins@gmail.com");
//    providePassword("te$t$udent");
//    clickSubmitButton();
//    }
}

