import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationPageTest extends BaseTest{
    @Test(priority = 1)
    public static void RegistrationPage () {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            driver.get(url);
            WebElement registrationField = driver.findElement(By.cssSelector("[id = 'hel']"));
            registrationField.click();
            WebElement registrationButton = driver.findElement(By.cssSelector("[id = 'button']"));
            Assert.assertTrue(registrationButton.isDisplayed());
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.quit();
        }
    }
}
