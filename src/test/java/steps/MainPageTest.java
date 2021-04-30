package steps;

import com.codeborne.selenide.Selenide;
import configuration.Config;
import configuration.MainPage;
import io.cucumber.java.ru.Когда;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class MainPageTest {

    MainPage mainPage = new MainPage();
    @Test
    @Когда("и я тестирую")
    public void test1 () {
        Config.init();
        Selenide.open("https://otus.ru");
        Selenide.open("/faq");
    }
}
