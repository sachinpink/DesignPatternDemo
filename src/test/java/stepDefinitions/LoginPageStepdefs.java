package stepDefinitions;
import DriverManagment.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageStepdefs
{
    private WebDriver driver;
    private LoginPage loginPage;

    @Before()
    public void setupStepDefinitions() {
        driver = DriverFactory.getInstance().getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("User search {string} on google home page")
    public void userSearchOnGoogleHomePage(String text) throws InterruptedException {
        loginPage.searchTest(text);
    }

    @Then("User selects the {string}")
    public void userSelectsThe(String text)
    {
        loginPage.selectFromList(text);
    }

    @Given("User click on {string}")
    public void userClickOn(String link)
    {
        loginPage.clickOnLinks(link);
    }

    @Given("User enters {string} and {string}")
    public void userEntersAnd(String userName, String password)
    {
        loginPage.enterCredentials(userName, password);
    }


}
