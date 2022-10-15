import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework14 {
    @Test
    public static void LoginIntoKoel () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("tasiakwiggins@gmail.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

            Thread.sleep(5000);
            driver.quit();
            }

    @Test
    public static void NavigateToRegistration () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement registrationButton = driver.findElement(By.xpath("//a[@href='/registration.php']"));
        //WebElement registrationButton = driver.findElement(By.linkText("https://bbb.testpro.io/registration.php"));
        registrationButton.click();

        Thread.sleep(5000);
        driver.quit();
    }
        }

//    Using Selenium, Navigate to "https://bbb.testpro.io/"
//        Click Registration link
//        Validate that you are redirected to Registration page
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework Koel with the use of Selenium
