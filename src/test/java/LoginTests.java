import POM.pages.BasePage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
import POM.pages.SongsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(enabled = false)
    public void changeUsernameVerifyTheChange() throws InterruptedException {

        browserConfigs();
        provideEmail("dcabdi@gmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        clickAvatarIcon();

        WebElement currentPassword = driver.findElement(By.xpath("//input[@name='current_password']"));
        currentPassword.sendKeys("te$t$tudent");

        WebElement username= driver.findElement(By.xpath("//input[@name='name']"));
        username.clear();
        username.sendKeys("Abdi");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement usernameActual = driver.findElement(By.xpath("//span[@class='name']"));
        WebElement saveBtn = driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        saveBtn.click();
        Assert.assertTrue(usernameActual.isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        tearDownBrowser();
    }
    @Test(priority = 1)
    public static void LoginValidEmailPasswordTest () {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        getDriver().manage().window().maximize();
        loginPage.provideEmail("dcabdi@gmail.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn()
                .isPageOpened();

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @Test(priority = 2)
    public void PlayASongFromAllSongs() {

        getDriver().manage().window().maximize();
        LoginPage loginpage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        SongsPage songsPage = new SongsPage(getDriver());

        loginpage.login();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        homePage.clickOnAllSongs();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        songsPage.doubleClickFirstSong();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        Assert.assertTrue(songsPage.isSongPlaying());
    }
}





























