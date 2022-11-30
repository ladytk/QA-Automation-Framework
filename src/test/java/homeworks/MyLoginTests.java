package homeworks;
import POM.pages.AllSongsPage;
import POM.pages.HomePage;
import POM.pages.LoginPage;


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

    @Test( enabled = false, priority = 0,dataProvider = "invalidCredentials")
    public void LoginEmptyEmailPasswordTest () {
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

    public boolean isAvatarIconPresent() {
        WebElement avatarIconElement= driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
        return avatarIconElement.isDisplayed();
    }

    @Test (priority = 0)
    public void LoginValidEmailPasswordTest () {
        LoginPageHmw loginPageHmw= new LoginPageHmw(driver);
        HomePageHmw homePageHmw =new HomePageHmw(driver);

        loginPageHmw.provideEmail("abisola@yahoo.com");
        loginPageHmw.providePassword("te$t$tudent");
        loginPageHmw.clickSubmitButton();
        Assert.assertTrue(homePageHmw.isUserAvatarDisplayed());
    }
    @Test
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
