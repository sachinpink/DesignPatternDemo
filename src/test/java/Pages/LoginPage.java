package Pages;

import com.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class LoginPage {
    private WebDriver driver;

    By searchInput = By.xpath("//textarea[@title='Search']");
    By suggestionList = By.xpath("(//ul[@role='listbox'])[1]/li/descendant::div[@class='wM6W7d']/span");
    By loginButton = By.xpath(("//input[@name='login-button']"));
    By userNameInput = By.xpath("//input[@id='user-name']");
    By passwordInput = By.xpath("//input[@id='password']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public void searchTest(String text) throws InterruptedException {
        driver.findElement(searchInput).sendKeys(text);
        Thread.sleep(1000);

    }

    public void selectFromList(String text) {
        try {
            List<WebElement> elements = driver.findElements(suggestionList);
            for (WebElement element : elements) {
                if (element.getText().equalsIgnoreCase(text)) {
                    System.out.println(element.getText());
                    Actions act = new Actions(driver);
                    act.moveToElement(element).build().perform();
                    Thread.sleep(1000);
                    element.click();
                    break;
                }
            }
        } catch (StaleElementReferenceException e) {
            List<WebElement> elements = driver.findElements(suggestionList);
            for (WebElement element : elements) {
                if (element.getText().equalsIgnoreCase(text)) {
                    element.click();
                    System.out.println(element.getText());
                    break;
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void clickOnLinks(String link) {
        WebElement ele = driver.findElement(By.xpath("//a[text()='" + link + "']"));
        ele.click();
    }

    public void enterCredentials(String userName, String password) {
        WebElement userNameEle = driver.findElement(userNameInput);
        userNameEle.sendKeys(userName);
        WebElement passwordEle = driver.findElement(passwordInput);
        passwordEle.sendKeys(password);
        driver.findElement(loginButton).click();
    }


}
