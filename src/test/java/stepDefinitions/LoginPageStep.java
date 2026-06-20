package stepDefinitions;

import DriverManagment.DriverFactory;
import Pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class LoginPageStep {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before()
    public void setupStepDefinitions() {
        driver = DriverFactory.getInstance().getDriver();
        loginPage = new LoginPage(driver);
    }


    @Given("User enters {string} and {string}")
    public void userEntersAnd(String userName, String password) {
        loginPage.enterCredentials(userName, password);
    }


}
