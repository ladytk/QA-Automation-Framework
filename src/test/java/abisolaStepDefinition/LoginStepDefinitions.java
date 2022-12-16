

package abisolaStepDefinition;
import POM.pages.LoginPage;
import homeworks.POM.Pages.LoginPageHmw;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {

    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;
    @FindBy(css = "[type='submit']")
    WebElement submitButton;
    WebDriver driver;
    WebDriverWait wait ;

    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver","chromedriver108.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Given("I open Login Page")
    public void i_open_login_page() {
      driver.get("https://bbb.testpro.io/");
    }


    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPageHmw loginPageHmw = new LoginPageHmw(driver);
        loginPageHmw.provideEmail(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPageHmw loginPageHmw = new LoginPageHmw(driver);
        loginPageHmw.providePassword(password);
        
    }

    @And("I submit")
    public void iSubmit() {
        LoginPageHmw loginPageHmw = new LoginPageHmw(driver);
        loginPageHmw.clickSubmitButton();
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        LoginPageHmw loginPageHmw = new LoginPageHmw(driver);
        loginPageHmw.isPageOpened();
    }




}