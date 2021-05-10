package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

public class EventsPage extends BasePage {

    private final ElementsCollection eventsCards = $$(".evnt-event-card");
    private final SelenideElement upcomingEventsNumber = $x("//span[contains(text(), 'Upcoming')]/../span[3]");
    private final SelenideElement pastEventsNumber = $x("//span[contains(text(), 'Past Events')]/../span[3]");
    private final ElementsCollection eventCardsDate = $$("span.date");
    private final SelenideElement pastEventsLink = $x("//span[contains(text(),'Past Events')]");
    private final SelenideElement loader = $("div.evnt-global-loader");
    private final By languageOnCards = By.cssSelector("p.language");
    private final By nameEventsOnCards = By.cssSelector("div.evnt-event-name h1");
    private final By dateOnCards = By.cssSelector("span.date");
    private final By registrationOnCards = By.cssSelector("span.status");
    private final By speakerOnCards = By.cssSelector("div.evnt-speaker");
    private final SelenideElement locationFilter = $("div#filter_location");
    private final SelenideElement locationCanada = $("label[data-value='Canada']");



    //Метод возвращает число отображенных карточек мероприятий
    @Step("Получение числа карточек мероприятий")
    public int getEventsCardsCount() {
        return eventsCards.size();
    }

    //Метод возвращает число, указанное на счетчике Upcoming Events
    @Step("Получение значения счетчика на кнопке UpcomingEvents ")
    public String getUpcomingEventsNumber() {
        return upcomingEventsNumber.getText();
    }

    //Метод возвращает число, указанное на счетчике Past Events
    @Step("Получение значения счетчика на кнопке PastEvents ")
    public String getPastEventsNumber() {
        return pastEventsNumber.getText();
    }


    //Метод получает дата с формы карточка мероприятия, парсит её в формат Date и возвращает это значение
    @Step("Получение значения даты с карточки мероприятия ")
    public Date getCardDateByNumber(int index) {
        String stringDate = eventCardsDate.get(index).getText();
        return dateParcer.parcerDate(stringDate);
    }

    //Метод возвращает текущую дату
    @Step("Получение значения текущей даты ")
    public Date getDateNow () {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        return new Date();
}
    //Метод нажимает на кнопку Past Events и дожидается загрузки
    @Step("Нажатие кнопки Past Events")
    public EventsPage clickToPastEvents () {
        pastEventsLink.click();
        logger.info("Нажата кнопка Past Events");
        loader
                .shouldBe(Condition.appear)
                .shouldBe(Condition.disappear);
        logger.info("Загрузка Past Events закончилась");
        return this;
    }

    //Метод возвращает значение language с карты мероприятия
    @Step("Получение зачения language с карты мероприятия")
    public String checkLang (int index) {
        return eventsCards.get(index).$(languageOnCards).getText();
    }

    //Метод возвращает значение заголовка мероприятия с карты мероприятия
    @Step("Получение зачения заголовка мероприятия с карты мероприятия")
    public String checkNameEvents (int index) {
        return eventsCards.get(index).$(nameEventsOnCards).getText();
    }

    //Метод возвращает значение даты с карты мероприятия
    @Step("Получение зачения даты с карты мероприятия")
    public String checkDate (int index) {
        return eventsCards.get(index).$(dateOnCards).getText();
    }

    //Метод возвращает значение информации о регистрации с карты мероприятия
    @Step("Получение зачения информации о регистрации с карты мероприятия")
    public String checkRegistrationInfo (int index) {
        return eventsCards.get(index).$(registrationOnCards).getText();
    }

    //Метод возвращает булево значение, существуют ли на карте меропрриятия элементы спикеров
    @Step("Получение зачения существуют ли на карте меропрриятия элементы спикеров")
    public boolean checkSpeaker (int index) {
        return eventsCards.get(index).$(speakerOnCards).exists();
    }

    //Метод выбирает локацию Канада
    @Step("Выбор локации 'Канада'")
    public EventsPage choiceLocation () {
        locationFilter.click();
        locationCanada.click();
        locationFilter.click();
        return this;
    }

}
