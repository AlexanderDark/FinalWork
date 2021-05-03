package Parameters;

import utils.Driver;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class GetBrowserName {
    private static String browserName;
    private static Logger logger = LogManager.getLogger(GetBrowserName.class);

    public static void initBrowser() {
        try {
            browserName = System.getProperty("browser").trim().toLowerCase();
        } catch (Exception exception) {
            logger.info("Браузер не был указан. Будет запущен Chrome.");
            browserName = "chrome";
        }
        logger.info("BROWSER = " + browserName);

        WebDriver driver = Driver.getDriver(browserName);
        WebDriverRunner.setWebDriver(driver);
        driver.manage().window().maximize();
    }
}
