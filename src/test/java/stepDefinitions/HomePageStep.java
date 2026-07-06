package stepDefinitions;

import DriverManagment.DriverFactory;
import Pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class HomePageStep
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
        homePage.selectProductAndClickOnAddToCart(productName);

    }


    @And("Verify the {string} is added into cart")
    public void verifyTheIsAddedIntoCart(String product)
    {
        homePage.verifyProductInCart(product);

    }

    @And("User Clicks on Checkout button from cart page")
    public void userClicksOnCheckoutButtonFromCartPage() throws InterruptedException {
        homePage.clickOnCheckOut();
    }

    @And("User enter the User details")
    public void userEnterTheUserDetails()
    {
        homePage.enterUserDetails();
    }

    @And("I verify the Order is placed successfully")
    public void iVerifyTheOrderIsPlacedSuccessfully()
    {
        homePage.verifyOrderStatus();

    }
}
