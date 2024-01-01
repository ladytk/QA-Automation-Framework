import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class RegisterNewUserTest {

    @Test
    public static void NewUserAccount () {

        String url = "https://bbb.testpro.io/";
        String registrationURL = "https://bbb.testpro.io/registration.php";

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.manage().window().maximize();


        WebElement registrationLinkElement = driver.findElement(By.id("hel"));
//        WebElement textToGetUsingCssSelector = driver.findElement(By.cssSelector("font[color='#f9f9ff']"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        registrationLinkElement.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//        first approach - assert if the current url is equal to your stored (String)  registration page url
        Assert.assertEquals(driver.getCurrentUrl(), registrationURL);

//        another approach - Print current url
        String retrievedUrl = driver.getCurrentUrl();
        System.out.println("Our current URL is " +retrievedUrl);

//        another approach - check if the "Register new account" text/line which can be found in the registration page is displayed in the web page
        WebElement registerNewAccountHeader = driver.findElement(By.xpath("//h2[contains(text(),'Register new account')]"));
        boolean isHeaderPresent = registerNewAccountHeader.isDisplayed();
        System.out.println(isHeaderPresent); // returns true if element is displayed

        driver.quit();
    }

}








