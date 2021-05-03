package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utils.Hooks;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты на раздел Past Events")
public class TestSelenideTest extends Hooks {

    @Test
    void asdasdadTest () {
        open("https://otus.ru");

    }
    @Test
    @DisplayName("Проверка параметров карточек раздела Past Events")
    @Description("Тест проверяет параметры карточек событий раздела Past Events")
    public void checkPastEventsCardsTest() {
        mainPage.acceptCookies();
               /* .acceptCookies()
                .clickEventsLink();*/
    }


}
