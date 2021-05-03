package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage {
    private final SelenideElement eventsLink = $("li.events-icon a");
    private final SelenideElement videoLink = $("li.talks-library-icon a");
    private final SelenideElement acceptCookiesBtn = $("button#onetrust-accept-btn-handler");

    @Step("Нажатие кнопки 'Принять' в окне использования cookies")
    public MainPage acceptCookies() {
        Selenide.open("https://events.epam.com/ ");
        acceptCookiesBtn
                .shouldBe(Condition.visible)
                .click();

        return this;
    }

}
