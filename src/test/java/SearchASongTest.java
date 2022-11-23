import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchASongTest {

    @Test
    public static void SearchSong () throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            String url = "https://bbb.testpro.io/";
            driver.get(url);
            WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
            emailField.click();
            emailField.sendKeys("dcabdi@gmail.com");

            WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
            passwordField.click();
            passwordField.sendKeys("te$t$tudent");

            WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
            submitButton.click();

            WebElement avatarIcon = driver.findElement(By.cssSelector("[alt = 'Avatar of student']"));
            Assert.assertTrue(avatarIcon.isDisplayed());

            WebElement homeLink = driver.findElement(By.cssSelector("[href=\"#!/home\"]"));
            homeLink.click();

            WebElement searchIcon = driver.findElement(By.cssSelector("[type = 'search']"));
            searchIcon.click();
            searchIcon.sendKeys("Pluto");
            WebElement searchResult = driver.findElement(By.cssSelector("………….."));
            Assert.assertEquals(searchResult.getText(),"Pluto" );
            Thread.sleep(2000);
        } finally {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
