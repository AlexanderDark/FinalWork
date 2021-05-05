package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.net.URL;

import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage {
    private final SelenideElement langList = $("#languageDropdown");
    private final SelenideElement choiceLang = $x("//a[contains(text(), 'Eng')]");
    private final String epamLink = "https://events.epam.com";
    private final SelenideElement eventsLink = $(".events-icon");
    private final SelenideElement videoLink = $("li.talks-library-icon a");
    private final SelenideElement acceptCookies = $("button#onetrust-accept-btn-handler");

    @Step("Переключение языка на Eng")
    public MainPage selectLang() {
        langList.click();
        choiceLang.click();
        logger.info("Выбран язык интерфейса 'English'");
        return this;
    }

    @Step("Клик на меню Events")
    public MainPage clickEvents() {
        eventsLink.click();
        logger.info("Нажата ссылка 'Events' На главной странице в верхнем меню");
        return this;
    }

    @Step("Переход на сайт EPAM")
    public MainPage goToEpam() {
        Selenide.open(epamLink);
        acceptCookies
                .shouldBe(Condition.visible)
                .click();
        return this;
    }

    @Step("Клик на меню Video")
    public MainPage clickVideoLink() {
        videoLink.click();
        logger.info("Нажата ссылка 'Video' в верхнем меню");

        return this;
    }
}
