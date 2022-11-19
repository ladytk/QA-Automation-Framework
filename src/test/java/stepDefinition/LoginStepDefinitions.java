package stepDefinition;

import POM.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginStepDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Given("I open Browser")
    public void openBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Given("I open Login Page")
    public void openLoginPage() {
        driver.get("https://bbb.testpro.io");
    }

    @When("I enter email {string}")
    public void iEnterEmail(String email) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.provideEmail(email);
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='email']")));

    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.providePassword(password);
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='password']")));

    }

    @And("I submit")
    public void submit() {
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type='submit']")));
    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitButton();
//        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }
}
