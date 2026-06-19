package DriverManagment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverManager implements  BroweserDriverManager{

    public WebDriver createDriver()
    {
        EdgeOptions options=new EdgeOptions();
        options.setAcceptInsecureCerts(true);
        options.setEnableDownloads(true);
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(options);
    }
}
