package selenideTest;

import com.codeborne.selenide.Selenide;
import configuration.Config;
import configuration.MainPage;
import io.cucumber.java.it.Ma;
import org.junit.Test;

public class MainPageTest {
    MainPage mainPage = new MainPage();

    @Test
    public void test1 () {
        Config.init();
        Selenide.open("https://otus.ru");
        Selenide.open("/faq");
    }
}
