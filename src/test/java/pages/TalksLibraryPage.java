package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
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
    private final ElementsCollection filteredCards = $$("div.evnt-talk-name");
    private final SelenideElement languageInFilteredCard = $("div.language");
    private final SelenideElement locationInFilteredCard = $("div.location");
    private final SelenideElement tagTestingInFilteredCard = $x("//label[normalize-space()='Testing']");
    private final SelenideElement elementForCheckLoading = $("div.evnt-action-icon");
    private final SelenideElement searchField = $("input.evnt-text-fields.form-control.evnt-search");
    private final ElementsCollection titleOfCard = $$("div.evnt-talk-name h1");

    private final SelenideElement loader = $("div.evnt-global-loader");

//Метод нажимает кнопку MoreFilters
    @Step("Нажатие на кнопку More Filters")
    public TalksLibraryPage clickMoreFilters() {
        moreFilters.click();
        logger.info("Нажата кнопка 'More Filters'");
        return this;
    }

    //Метод нажимает кнопку Category
    @Step("Нажатие на кнопку Category")
    public TalksLibraryPage clickCategoryFilter() {
        categoryFilter.click();
        logger.info("Нажата кнопка 'Category'");
        return this;
    }

//Метод выбирает значение Testing в списке категорий
    @Step("Выбор значения Testing в фильтре Category")
    public TalksLibraryPage selectCategoryTesting() {
        categoryTesting.click();
        clickCategoryFilter();
        logger.info("Выбрано значение 'Testing' в фильтре Category");
        return this;
    }

    //Метод нажимает кнопку Location
    @Step("Нажатие на кнопку Location")
    public TalksLibraryPage clickLocationFilter() {
        locationFilter.click();
        logger.info("Нажата кнопка 'Location'");
        return this;
    }

    //Метод выбирает значение Belarus в списке локаций
    @Step("Выбор значения Belarus в фильтре Location")
    public TalksLibraryPage selectLocationBelarus() {
        locationBelarus.click();
        clickLocationFilter();
        logger.info("Выбрано значение 'Belarus' в фильтре Location");
        return this;
    }

    //Метод нажимает кнопку Language
    @Step("Нажатие на кнопку Language")
    public TalksLibraryPage clickLanguageFilter() {
        languageFilter.click();
        logger.info("Нажата кнопка 'Language'");
        return this;
    }

    //Метод выбирает значение English в списке языков
    @Step("Выбор значения English в фильтре Language")
    public void selectLanguageEnglish() {
        languageEnglish.click();
        clickLanguageFilter();

        logger.info("Выбрано значение 'English' в фильтре Language");
    }

    //Метод открывает отфильтрованную карточку с порядковым номером index
    @Step("Открытие отфильтрованной карточки")
    public void clickOnFilteredCard (int index) {
        filteredCards.get(index).click();
        elementForCheckLoading.shouldBe(Condition.visible);
        logger.info("Открыта отфильтрованная карточка");
    }

    //Метод возвращает значение поля "Язык"
    @Step("Получение языка, указанного в отфильтрованной карточке")
    public String getLanguageInFilteredCard () {
        logger.info("Получено значение языка из карточки: "+ languageInFilteredCard.getText());
        return languageInFilteredCard.getText();
    }

    //Метод возвращает значение поля Адрес
    @Step("Получение адреса, указанного в отфильтрованной карточке")
    public String getLocationInFilteredCard () {
        logger.info("Получено значение адреса из карточки: "+ locationInFilteredCard.getText());
        return locationInFilteredCard.getText();
    }

    //Метод позволяет перейти по указанному ЮРЛ
    @Step("Переход по заданному URL")
    public TalksLibraryPage openUrl (String string) {
        open(string);
        logger.info("Произошёл переход по URL");
        return this;
    }

    //Метод возвращает число отображённых карточек
    @Step("Получение числа карточек мероприятий")
    public int getFilteredCardsCount() {
        return filteredCards.size();
    }

    //Метод проверяет, присутствует ли на карточке тэг и возвращает булево значение
    @Step("Проверка наличия тэга Testing в карточке мероприятия")
    public boolean checkTagTesting () {
        return tagTestingInFilteredCard.exists();
    }

    //Метод вводит в строку поиска значение QA
    @Step("Ввод в строку поиска значения 'QA'")
    public void enterQATextToSearchField() throws InterruptedException {
        searchField.sendKeys("QA"+ Keys.ENTER);
        Thread.sleep(2000);
        //КАК ЭФФЕКТИВНО БОРОТЬСЯ С ЗАГРУЗКОЙ РЕЗУЛЬТАТОВ?
        /*if (loader.isDisplayed()) {
            loader
                    .shouldBe(Condition.appear)
                    .shouldBe(Condition.disappear);
        }*/
        logger.info("Введено 'QA' в строку поиска");

    }

    // Метод возвращает значение строки заголовка карточки мероприятия
    public String getTitleOfCard (int index) {
        return titleOfCard.get(index).getText();
    }
}
