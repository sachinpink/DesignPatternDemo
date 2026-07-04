package stepDefinitions;

import DriverManagment.DriverFactory;
import Pages.LoginPage;
import com.ExcelUtility;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.HashMap;

public class LoginPageStep {
    private LoginPage loginPage;

    @Before()
    public void setupStepDefinitions() {
        WebDriver driver = DriverFactory.getInstance().getDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("User enters {string} and {string}")
    public void userEntersAnd(String userName, String password) throws IOException {
        HashMap<String,String> userDetails = ExcelUtility.readExcel("Admin");
        System.out.println("UserName "+ userDetails.get("UserName"));
        System.out.println("Password " + userDetails.get("Password"));
        loginPage.enterCredentials(userName, password);
    }


}
