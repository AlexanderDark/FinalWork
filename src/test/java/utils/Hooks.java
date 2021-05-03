package utils;

import Parameters.GetBrowserName;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import pages.MainPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Hooks {
    protected MainPage mainPage = new MainPage();

    private Logger logger = LogManager.getLogger(Hooks.class);
    @BeforeAll
    public void setUp() {
        GetBrowserName.initBrowser();
        logger.info("Открыт браузер");
    }

 /*   @AfterEach
    public void setDownTest() {
        Selenide.clearBrowserLocalStorage();
        logger.info("Чистим браузер");
        Selenide.closeWebDriver();
        logger.info("Закрыт браузер");
        mainPage = new MainPage();

    }*/
    @AfterAll
    public void closeSelenide() {
        Selenide.closeWebDriver();
        logger.info("Закрыт браузер");
    }
}
