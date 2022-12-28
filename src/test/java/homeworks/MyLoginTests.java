package homeworks;
import homeworks.POM.Pages.AllSongsPageHmw;
import homeworks.POM.Pages.BasePageHmw;
import homeworks.POM.Pages.HomePageHmw;
import homeworks.POM.Pages.LoginPageHmw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyLoginTests extends MyBaseTest {

String url= "https://bbb.testpro.io/";

    @Test( enabled = false, priority = 0)
    public void LoginEmptyEmailPasswordTest () {
        LoginPageHmw loginPageHmw= new LoginPageHmw(getDriver());


    loginPageHmw.provideEmail("");
    loginPageHmw.providePassword("");
    loginPageHmw.clickSubmitButton();
    Assert.assertTrue(loginPageHmw.isPageOpened());
    }

    @Test(enabled = false, priority = 0)
    public void OpenLoginPageTest () {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @DataProvider(name="inavildCredentials")
    public static Object[][] getCredentials(){

        return new Object[][]{
                {"invalid@class.com","invalidPass"},
                {"d@class.com",""},
                {"",""},
        };
}


    @Test (priority = 0)
    public void LoginValidEmailPasswordTest () {
        LoginPageHmw loginPageHmw= new LoginPageHmw(getDriver());
        HomePageHmw homePageHmw =new HomePageHmw(getDriver());

        loginPageHmw.provideEmail("abisola@yahoo.com");
        loginPageHmw.providePassword("te$t$tudent");
        loginPageHmw.clickSubmitButton();
        Assert.assertTrue(homePageHmw.isUserAvatarDisplayed());
    }
    @Test(enabled = false)
    public void Shuffle(){
        AllSongsPageHmw allSongsPageHmw = new AllSongsPageHmw(driver);
        LoginPageHmw loginPageHmw = new LoginPageHmw(driver);
          HomePageHmw homePageHmw= loginPageHmw.login();

      homePageHmw.clickOnAllSongs()
                .shuffle();
        Assert.assertTrue(homePageHmw.isSongPlaying());

    }
    @Test
    public void PlayASongFromAllSongs(){
        LoginPageHmw loginPageHmw =new LoginPageHmw(driver);
        BasePageHmw basePageHmw = new BasePageHmw(driver);
        HomePageHmw homePageHmw =new HomePageHmw(driver);
        AllSongsPageHmw allSongsPageHmw= new AllSongsPageHmw(driver);

        loginPageHmw.login();
        basePageHmw.clickOnAllSongs();
        allSongsPageHmw.clickFirstSong();
        Assert.assertTrue(homePageHmw.isSongPlaying());
    }

}
