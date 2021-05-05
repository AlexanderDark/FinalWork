package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utils.Hooks;

import java.util.Date;

import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Тесты раздела Events")
public class EventsTest extends Hooks {

    @Test
    @DisplayName("Просмотр количества предстоящих мероприятий:")
    @Description("Тест проверяет, что количество карточек равно счетчику на кнопке Upcoming Events")
    public void checkUpcomingEventsCardsTest() {
        mainPage.goToEpam()
                .selectLang()
                .clickEvents();
        Assertions.assertEquals(Integer.parseInt(eventsPage.getUpcomingEventsNumber()), eventsPage.getEventsCardsCount());
    }

    @Test
    @DisplayName("Просмотр дат предстоящих мероприятий:")
    @Description("Тест проверяет, что даты карточек в Upcoming Events больше, чем текущая дата")
    public void checkUpcomingEventsCardsDateTest() {
        mainPage.goToEpam()
                .selectLang()
                .clickEvents();
        for (int i =0; i<eventsPage.getEventsCardsCount(); i++) {
            Assertions.assertTrue(eventsPage.getCardDateByNumber(i).after(eventsPage.getDateNow()));
        }
    }

    @Test
    @DisplayName("Просмотр дат у карточек прошедших мероприятий:")
    @Description("Тест проверяет, что в отображенных карточках дата меньше, чем текущая дата")
    public void checkPastEventsCardsDateTest() {
        mainPage.goToEpam()
                .selectLang()
                .clickEvents();
        eventsPage.clickToPastEvents();
        for (int i =0; i<eventsPage.getEventsCardsCount(); i++) {
            Assertions.assertTrue(eventsPage.getCardDateByNumber(i).before(eventsPage.getDateNow()));
        }
    }

    @Test
    @DisplayName("Просмотр заполненности карточек прошедших мероприятий:")
    @Description("Тест проверяет, что карточки имеют следующие реквизиты: язык, заголовок, дату, и" +
            "нформацию о регистрации, информация о спикерах")
    public void checkPastEventsCardsForFillTest() {
        mainPage.goToEpam()
                .selectLang()
                .clickEvents();
            eventsPage.clickToPastEvents();
        for (int i =0; i<eventsPage.getEventsCardsCount(); i++) {
            Assertions.assertFalse(eventsPage.checkLang(i).isEmpty());
            Assertions.assertFalse(eventsPage.checkNameEvents(i).isEmpty());
            Assertions.assertFalse(eventsPage.checkDate(i).isEmpty());
            Assertions.assertFalse(eventsPage.checkRegistrationInfo(i).isEmpty());
            Assertions.assertTrue(eventsPage.checkSpeaker(i));
        }
    }

    @Test
    @DisplayName("Просмотр карточек прошедших мероприятий по Канаде:")
    @Description("Тест проверяет, что количество карточек\n" +
            " равно счетчику на кнопке Past Events. Даты проведенных мероприятий меньше текущей даты.")
    public void checkPastEventsCardsForCanada() {
        mainPage.goToEpam()
                .selectLang()
                .clickEvents();
        eventsPage.clickToPastEvents()
                .choiceLocation();
        Assertions.assertEquals(Integer.parseInt(eventsPage.getPastEventsNumber()), eventsPage.getEventsCardsCount());
        for (int i =0; i<eventsPage.getEventsCardsCount(); i++) {
            Assertions.assertTrue(eventsPage.getCardDateByNumber(i).before(eventsPage.getDateNow()));
        }    }

}
