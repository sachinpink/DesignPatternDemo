package DriverManagment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory
{
    private static DriverFactory instance;
    private  DriverFactory() {}
    private static final ThreadLocal<WebDriver> tdriver= new ThreadLocal<>();
    public static DriverFactory getInstance()
    {
        if (instance == null)
        {
            instance = new DriverFactory();
        }
        return instance;
    }
    public  BroweserDriverManager getDriverManager(String browser)
    {
        return switch (browser) {
            case "chrome" -> new ChromeDriverManager();
            case "edge" -> new EdgeDriverManager();
            default -> throw new RuntimeException("provide correct browser name");
        };

    }
     public void setDriver(WebDriver driver)
     {

         tdriver.set(driver);
     }

     public WebDriver getDriver()
     {

         return tdriver.get();
     }
}
