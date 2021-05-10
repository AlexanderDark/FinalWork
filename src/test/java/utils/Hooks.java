package utils;

import Parameters.GetBrowserName;
import com.codeborne.selenide.Selenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import pages.EventsPage;
import pages.MainPage;
import pages.TalksLibraryPage;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Hooks {
    protected MainPage mainPage = new MainPage();
    protected EventsPage eventsPage = new EventsPage();
    protected TalksLibraryPage talksLibraryPage = new TalksLibraryPage();




    private Logger logger = LogManager.getLogger(Hooks.class);

    @Execution(ExecutionMode.CONCURRENT)
    @BeforeAll
    public void setUp() {
        GetBrowserName.initBrowser();
        logger.info("Открыт браузер");
    }

    @Execution(ExecutionMode.CONCURRENT)
    @AfterEach
    public void setDownTest() {
        Selenide.clearBrowserLocalStorage();
        logger.info("Чистим браузер");
        Selenide.closeWebDriver();
        logger.info("Закрыт браузер");

    }

    @Execution(ExecutionMode.CONCURRENT)
    @AfterAll
    public void closeSelenide() {
        Selenide.closeWebDriver();
        logger.info("Закрыт браузер");
    }
}
