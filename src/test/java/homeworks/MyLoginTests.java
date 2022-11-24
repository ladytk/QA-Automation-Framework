package homeworks;

import POM.pages.AllSongsPage;
import POM.pages.HomePage;
import POM.pages.LoginPage;
<<<<<<< Updated upstream
=======
import homeworks.POM.Pages.AllSongsPageHmw;
import homeworks.POM.Pages.BasePageHmw;
import homeworks.POM.Pages.HomePageHmw;
import homeworks.POM.Pages.LoginPageHmw;
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
String url= "https://bbb.testpro.io/";

//    @DataProvider
//    public static Object[][] invalidCredentials() {
//        return new Object[][]{};
//    }


    @Test( enabled = false, priority = 0,dataProvider = "invalidCredentials")
    public void LoginEmptyEmailPasswordTest () {
        Assert.assertEquals(driver.getCurrentUrl(), url);
=======
    String expectedResultUrl= "https://bbb.testpro.io/";

    @Test( enabled = false, priority = 0,dataProvider = "invalidCredentials")
    public void LoginEmptyEmailPasswordTest () {
        clickSubmitBtn();
        Assert.assertEquals(driver.getCurrentUrl(), expectedResultUrl);
>>>>>>> Stashed changes
    }
    @DataProvider(name="inavildCredentials")
    public static Object[][] getCredentials(){

        return new Object[][]{
                {"invalid@class.com","invalidPass"},
                {"d@class.com",""},
                {"",""},

        };
<<<<<<< Updated upstream
}



    @Test (priority = 0)
    public void LoginValidEmailPasswordTest () {
        login();//lets try to login again
        By avatarIcon = By.cssSelector("[class='view-profile']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatarIcon));
        WebElement avatarIconElement = driver.findElement(avatarIcon);
        Assert.assertTrue(avatarIconElement.isDisplayed());


    }
    public boolean isAvatarIconPresent() {
        WebElement avatarIconElement= driver.findElement(By.xpath("//img[contains(@alt,'Avatar of')]"));
        return avatarIconElement.isDisplayed();
    }

//    @Test
//    public void Shuffle(){
//        AllSongsPage allSongsPage = new AllSongsPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
//
//        HomePage homePage = loginPage.login();
//
//        homePage.clickOnAllSongs()
//                .shuffle();
//        Assert.assertTrue(homePage.isSongPlaying());
//
//    }

//    @Test
//    public void PlayASongFromAllSongs(){
//        LoginPage loginPage = new LoginPage(driver);
//        HomePage homey = new HomePage(driver);
//        AllSongsPage singysongy = new AllSongsPage(driver);
//
//        //Step1: Login
//        loginPage.login();
//        //Step2: Click on All Songs
//        homey.clickOnAllSongs();
//        //Step3: double click on first song
//        singysongy.doubleClickFirstSong();
//        //Step4: check if song is playing
//        Assert.assertTrue(homey.isSongPlaying());
//    }


//    @Test(enabled = false, priority = 2)
//    public void LoginInvalidEmailPasswordTest () throws InterruptedException {
//
////        provideEmail();
////        providePassword();
//
//        provideEmail("dem@class.com");
//        providePassword("");
//
//        clickSubmitBtn();
//        By avatarIconLocator = By.xpath("//img[contains(@alt,'Avatar of')]");
//        WebElement avatarIcon = driver.findElement(avatarIconLocator);
//        wait.until(ExpectedConditions.elementToBeClickable(avatarIconLocator));
//        Assert.assertTrue(avatarIcon.isDisplayed());
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//
//    }
=======
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
        BasePageHmw basePageHmw = new BasePageHmw(driver);

        loginPageHmw.login();
        basePageHmw.clickOnAllSongs();
        allSongsPageHmw.Shuffle();
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
>>>>>>> Stashed changes

    @Test(enabled = false)
    public void LoginValidEmailEmptyPasswordTest () {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement emailField = driver.findElement(By.cssSelector("[type='email']"));
        emailField.click();
        emailField.sendKeys("adenik@yahoo.com");

        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        passwordField.click();
        emailField.sendKeys("te$t$tudent");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();

        WebElement avatarIcon = driver.findElement(By.cssSelector("[alt='Avatar of student']"));
        Assert.assertTrue(avatarIcon.isDisplayed());

        driver.quit();
    }

    @Test(enabled = false)
    public void SwitchToSongsMenu () throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        By emailSelector = By.cssSelector("[type='email']");
        WebElement emailField = driver.findElement(emailSelector);
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        By avatarSelector = By.cssSelector("[alt='Avatar of student']");
        By songMenuSelector = By.className("songs");
        By allButtonSelector = By.className("btn-shuffle-all");

        emailField.click();
        emailField.sendKeys("demo@class.com");
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
        submitButton.click();
        Assert.assertTrue(driver.findElement(avatarSelector).isDisplayed());
        // WebElement songsMenu = driver.findElement(By.className("songs"));
        // WebElement songsMenu = driver.findElement(songMenuSelector);
        driver.findElement(songMenuSelector).click();
        Assert.assertTrue(driver.findElement(allButtonSelector).isDisplayed());
        Thread.sleep(2000);

        driver.quit();
    }

    @Test(enabled = false)
    public void SearchSong () throws InterruptedException {
        WebDriver driver;
        driver = new ChromeDriver();
        By playlistLocator = By.cssSelector("#playlists h1");
        wait.until(ExpectedConditions.elementToBeClickable(playlistLocator));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(playlistLocator), "PLAYLISTS"));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        By emailSelector = By.cssSelector("[type='email']");
        WebElement emailField = driver.findElement(emailSelector);
        WebElement passwordField = driver.findElement(By.cssSelector("[type='password']"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        By avatarSelector = By.cssSelector("[alt='Avatar of student']");
        By searchBarSelector = By.id("searchForm");
        By allButtonSelector = By.className("btn-shuffle-all");

        emailField.click();
<<<<<<< Updated upstream
        emailField.sendKeys("adenik@class.com");
=======
        emailField.sendKeys("abisola@class.com");
>>>>>>> Stashed changes
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
        submitButton.click();
        Assert.assertTrue(driver.findElement(avatarSelector).isDisplayed());
<<<<<<< Updated upstream
//      WebElement songsMenu = driver.findElement(By.className("songs"));
//       WebElement songsMenu = driver.findElement(songMenuSelector);

//        Assert.assertTrue(driver.findElement().isDisplayed());


//        Thread.sleep(5000);


=======
>>>>>>> Stashed changes
        url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

}
