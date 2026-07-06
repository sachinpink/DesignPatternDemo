package Pages;

import com.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomePage
{
    private final WebDriver driver;

    By dashboard = By.xpath("//span[text()='Products']");
    By checkOutButton = By.xpath("//button[@name='checkout']");
    By cardLink = By.xpath("//a[@class='shopping_cart_link']");
    By productInCart = By.cssSelector(".inventory_item_name");
    By firstNameInput= By.id("first-name");
    By lastNameInput= By.id("last-name");
    By zipCodeInput = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By orderSuccessMessage = By.xpath("//h2[text()='Thank you for your order!']");

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


    public void selectProductAndClickOnAddToCart(String productName)
    {
        //WebElement addToCart =  driver.findElement(By.xpath("//div[text()='"+productName+"']/ancestor::div[@class='inventory_item_label']/following-sibling::div//button"));
        List<WebElement> products =  driver.findElements(By.cssSelector(".inventory_item_name"));
        boolean flag=false;
        for(int i=0;i<products.size();i++)
        {
            System.out.println("Product Name = " + products.get(i).getText());
            if(productName.equalsIgnoreCase(products.get(i).getText()))
            {
                int num=i+1;
                WebElement addToCart = driver.findElement(By.xpath("(//button[text()='Add to cart'])["+num+"]"));
                Utils.clickByJs(driver,addToCart);
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            Assert.fail("Failed to add product into cart");
        }

    }

    public void verifyProductInCart(String product)
    {
        Utils.waitForLocaterToBeClickable(driver,cardLink,30);
        WebElement link = driver.findElement(cardLink);
        Utils.clickByJs(driver,link);
        String name= Utils.waitForVisible(driver,productInCart,15).getText();
        if(name.equalsIgnoreCase(product))
        {
            System.out.println("Product added into cart is " + product);
        }
        else {
            Assert.assertEquals(name,product);
        }
    }
    public void clickOnCheckOut() throws InterruptedException {

        Utils.clickByJs(driver, Utils.waitForLocaterToBeClickable(driver, checkOutButton, 30));
        Utils.waitForSomeTime(3000);

    }

    public void enterUserDetails()
    {
        Utils.waitForLocaterToBeClickable(driver,firstNameInput,10);
        driver.findElement(firstNameInput).sendKeys("Sachin");
        driver.findElement(lastNameInput).sendKeys("Zagade");
        driver.findElement(zipCodeInput).sendKeys("1234");
        driver.findElement(continueButton).click();
        Utils.waitForLocaterToBeClickable(driver,finishButton,10);
        driver.findElement(finishButton).click();
    }

    public void verifyOrderStatus()
    {
        Utils.waitForVisible(driver, orderSuccessMessage,10);
    }
}
