import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class PracticeFun {
    @Test
    public static void TestingEverything () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://app.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement titleText = driver.findElement(By.tagName("h1"));
        String st = titleText.getText();
        System.out.println("Text is " + st + " at Testpro today!");

        //Thread.sleep(5000);
        driver.quit();
    }
    }

