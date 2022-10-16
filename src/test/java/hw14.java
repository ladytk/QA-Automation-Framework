import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class hw14 {

    @Test
    public static void RegistrationPage () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            driver.get(url);
            WebElement registrationField = driver.findElement(By.cssSelector("[id = 'hel']"));
            registrationField.click();
            WebElement registrationButton = driver.findElement(By.cssSelector("[id = 'button']"));
            Assert.assertTrue(registrationButton.isDisplayed());
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
