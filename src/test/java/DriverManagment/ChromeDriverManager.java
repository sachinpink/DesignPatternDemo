package DriverManagment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverManager implements  BroweserDriverManager
{
    public WebDriver createDriver()
    {
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.geolocation", 2);
        prefs.put("profile.default_content_setting_values.media_stream", 2);
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("safebrowsing.enabled", false);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs",prefs);
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.setAcceptInsecureCerts(true);
        return new ChromeDriver(options);
    }
}
