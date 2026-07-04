package DriverManagment;
import org.openqa.selenium.WebDriver;


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

    public BroweserDriverManager getDriverManager(String browser) {
        switch (browser) {
            case "chrome": {
                return new ChromeDriverManager();
            }
            case "edge": {
                return new EdgeDriverManager();
            }
            default: {
                throw new RuntimeException("provide correct browser name");
            }
        }
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
