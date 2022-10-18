import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework15 {

    @Test
    public static void SongSearch () throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        WebElement emailLogin = driver.findElement(By.cssSelector("[type='email']"));
        emailLogin.click();
        emailLogin.sendKeys("tasiakwiggins@gmail.com");

        WebElement passwordLogin = driver.findElement(By.cssSelector("[type='password']"));
        passwordLogin.click();
        passwordLogin.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement searchBox = driver.findElement(By.cssSelector("[type='search']"));
        searchBox.click();
        searchBox.sendKeys("Pluto");

        Thread.sleep(5000);
        driver.quit();
    }
}

//    Create a new file Homework15.java file with @Test annotation in IntelliJ IDEA
//        Create a test case search() using @Test annotation
//        Navigate to "https://bbb.testpro.io/"
//        Log in with your credentials
//        Search for the song "Pluto" (use CSS locators to locate the elements)
//        Validate that there is a song matched in a search results
//        Create a new branch and commit your changes
//        Push your code to a remote repository
//        Create a pull request
//        Copy and paste the link of the pull request (or your branch) to the field below, so we can check your homework