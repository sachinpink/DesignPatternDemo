package Pages;

import com.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage
{
    private final WebDriver driver;

    By dashboard = By.xpath("//span[text()='Products']");
    By checkOutButton = By.xpath("//button[@name='checkout']");
    By cardLink = By.xpath("//a[@class='shopping_cart_link']");

    public HomePage(WebDriver driver)
    {
        this.driver=driver;
    }

    public void verifyLoggedIn()
    {
        WebElement dashboardIcon = Utils.waitForVisible(driver, dashboard,5);
        boolean status = dashboardIcon.isDisplayed();
        if (status) {
            System.out.println("Logged In");
        } else {
            System.out.println("Failed to login");
            Assert.fail("Failed to login");
        }
    }

    public void clickOnCartAndCheckOut() throws InterruptedException {
        Utils.waitForLocaterToBeClickable(driver,cardLink,30);
        WebElement link = driver.findElement(cardLink);
        Utils.clickByJs(driver,link);
        Utils.clickByJs(driver, Utils.waitForLocaterToBeClickable(driver, checkOutButton, 30));
        Utils.waitForSomeTime(3000);

    }
}
