package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;

public class TalksLibraryPage extends BasePage{
    private final SelenideElement moreFilters = $("div.show-more");
    private final SelenideElement categoryFilter = $("div#filter_category");
    private final SelenideElement categoryTesting = $x("//label[@data-value=\"Testing\"]");
    private final SelenideElement locationFilter = $("div#filter_location");
    private final SelenideElement locationBelarus = $("label[data-value='Belarus']");
    private final SelenideElement languageFilter = $("div#filter_language");
    private final SelenideElement languageEnglish = $("label[data-value='ENGLISH']");
    private final ElementsCollection filteredCards = $$("div.evnt-talks-column");
    private final SelenideElement languageInFilteredCard = $("div.language");
    private final SelenideElement locationInFilteredCard = $("div.location");
    private final SelenideElement tagTestingInFilteredCard = $x("//label[normalize-space()='Testing']");
    private final SelenideElement elementForCheckLoading = $("div.evnt-action-icon");



    private final ElementsCollection filterTags = $$("div.evnt-filters-content div.evnt-tags-cell label");
    private final ElementsCollection eventsCards = $$("div.evnt-talk-card");
    private final ElementsCollection eventCardsLanguage = $$("div.evnt-talk-card p.language");
    private final SelenideElement searchField = $("div.evnt-search-filter input.evnt-search");
    private final ElementsCollection eventCardsTitle = $$("div.evnt-talk-name span");
    private final SelenideElement loader = $("div.evnt-global-loader");

    @Step("Нажатие на кнопку More Filters")
    public TalksLibraryPage clickMoreFilters() {
        moreFilters.click();
        logger.info("Нажата кнопка 'More Filters'");
        return this;
    }

    @Step("Нажатие на кнопку Category")
    public TalksLibraryPage clickCategoryFilter() {
        categoryFilter.click();
        logger.info("Нажата кнопка 'Category'");
        return this;
    }

    @Step("Выбор значения Testing в фильтре Category")
    public TalksLibraryPage selectCategoryTesting() {
        categoryTesting.click();
        clickCategoryFilter();
        logger.info("Выбрано значение 'Testing' в фильтре Category");
        return this;
    }

    @Step("Нажатие на кнопку Location")
    public TalksLibraryPage clickLocationFilter() {
        locationFilter.click();
        logger.info("Нажата кнопка 'Location'");
        return this;
    }

    @Step("Выбор значения Belarus в фильтре Location")
    public TalksLibraryPage selectLocationBelarus() {
        locationBelarus.click();
        clickLocationFilter();
        logger.info("Выбрано значение 'Belarus' в фильтре Location");
        return this;
    }

    @Step("Нажатие на кнопку Language")
    public TalksLibraryPage clickLanguageFilter() {
        languageFilter.click();
        logger.info("Нажата кнопка 'Language'");
        return this;
    }

    @Step("Выбор значения English в фильтре Language")
    public TalksLibraryPage selectLanguageEnglish() {
        languageEnglish.click();
        clickLanguageFilter();

        logger.info("Выбрано значение 'English' в фильтре Language");
        return this;
    }


    @Step("Открытие отфильтрованной карточки")
    public TalksLibraryPage clickOnFilteredCard (int index) {
        filteredCards.get(index).click();
        elementForCheckLoading.shouldBe(Condition.visible);
        logger.info("Открыта отфильтрованная карточка");
        return this;
    }


    @Step("Получение языка, указанного в отфильтрованной карточке")
    public String getLanguageInFilteredCard () {
        logger.info("Получено значение языка из карточки: "+ languageInFilteredCard.getText());
        return languageInFilteredCard.getText();
    }

    @Step("Получение адреса, указанного в отфильтрованной карточке")
    public String getLocationInFilteredCard () {
        logger.info("Получено значение адреса из карточки: "+ locationInFilteredCard.getText());
        return locationInFilteredCard.getText();
    }

    @Step("Переход по заданному URL")
    public TalksLibraryPage openUrl (String string) {
        open(string);


        logger.info("Произошёл переход по URL");
        return this;
    }

    @Step("Получение числа карточек мероприятий")
    public int getFilteredCardsCount() {
        return filteredCards.size();
    }

    @Step("Проверка наличия тэга Testing в карточке мероприятия")
    public boolean checkTagTesting () {
        return tagTestingInFilteredCard.exists();
    }


    @Step("Ввод значения '{text}' в строку для поиска")
    public TalksLibraryPage enterTextToSearchField(String text) {
        searchField
                .shouldBe(Condition.enabled)
                .setValue(text);
        loader
                .shouldBe(Condition.appear)
                .shouldBe(Condition.disappear);

        logger.info(String.format("Введено значение '%s' в строку для поиск", text));

        return this;
    }

    public int getFilterTagsCountByText(String tagText) {
        return filterTags
                .filter(Condition.text(tagText))
                .size();
    }

    public int getEventsCardsCount() {
        return eventsCards.size();
    }

    public String getCardLanguageByNumber(int index) {
        return eventCardsLanguage.get(index).getText();
    }

    public String getCardTitleByNumber(int index) {
        return eventCardsTitle.get(index).getText();
    }
}
