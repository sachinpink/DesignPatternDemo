package stepDefinitions;

import DriverManagment.DriverFactory;
import Pages.HomePage;
import Pages.LoginPage;
import com.Utils;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageStepdefs
{
    private WebDriver driver;
    private HomePage homePage;

    @Before()
    public void setupStepDefinitions()
    {

        driver = DriverFactory.getInstance().getDriver();
        homePage =new HomePage(driver);

    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully()
    {
        homePage.verifyLoggedIn();
    }

    @And("User add the product into card which having name {string}")
    public void userAddTheProductIntoCardWhichHavingName(String productName)
    {
        WebElement addToCart=  driver.findElement(By.xpath("//div[text()='"+productName+"']/ancestor::div[@class='inventory_item_label']/following-sibling::div//button"));
        Utils.clickByJs(driver,addToCart);

    }

    @And("Verify User is on Cart page")
    public void verifyUserIsOnCartPage() throws InterruptedException {
        homePage.clickOnCartAndCheckOut();
    }
}
