package stepDefinitions;

import DriverManagment.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

public  class Hooks
{
    private WebDriver driver;
    @Before(order = 0)
    public void beforeHooks() throws MalformedURLException, URISyntaxException {
        String browser = System.getProperty("browser");
        String localExecution = System.getProperty("localExecution","yes");
        String UI_Execution = System.getProperty("UI_Execution","yes");
        if(UI_Execution.equalsIgnoreCase("yes"))
        {
            if(localExecution.equalsIgnoreCase("yes"))
            {
                driver = DriverFactory.getInstance().getDriverManager(browser).createDriver();
                DriverFactory.getInstance().setDriver(driver);
                driver = DriverFactory.getInstance().getDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.get("https://www.saucedemo.com/");

            }
            else
            {
                DesiredCapabilities capabilities=new DesiredCapabilities();
                capabilities.setBrowserName("chrome");
                String urlString="http://localhost:4444/wd/hub";
                URL url =new URI(urlString).toURL();
                driver=new RemoteWebDriver(url,capabilities);
                DriverFactory.getInstance().setDriver(driver);
                //DriverManager.setDriver(driver);
                driver = DriverFactory.getInstance().getDriver();
                driver.get("https://www.google.com");
            }
        }
    }

    @AfterStep
    public void captureSnap(Scenario scenario)
    {
        if(scenario.isFailed())
        {
             byte[]  snap = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
             scenario.attach(snap,"image/png", scenario.getName());
        }
    }

    @After()
    public void afterHooks() {
        if (driver != null) {
            driver.quit();
        }
    }
}
