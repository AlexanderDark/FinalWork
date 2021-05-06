package utils;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;


import java.net.URL;

public class Driver {
    public static WebDriver getDriver (String browserName) {

        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.reportsFolder = "target/surefire-reports";
        Configuration.downloadsFolder = "target/downloads";
        Configuration.baseUrl = "https://events.epam.com/";


        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browserName) {
            case Browsers.FIREFOX:
                capabilities.setBrowserName("firefox");
                capabilities.setVersion("88.0");
                break;
            case Browsers.CHROME:
            default:
                capabilities.setBrowserName("chrome");
                capabilities.setVersion("89.0");
        }
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableLog", true);
        Configuration.browserCapabilities = capabilities;
        return new RemoteWebDriver(capabilities);
    }
}
