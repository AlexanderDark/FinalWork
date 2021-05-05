package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Hooks;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@DisplayName("Тесты на раздел Video")
public class TalksLibraryTest extends Hooks {
    @Test
    @DisplayName("Проверка фильтрации на странице Talks Library")
    @Description("Тест задает фильтры Category, Location, Language и проверяет теги и язык в найденных карточках")
    public void videoFiltersTest() {
        mainPage
                .goToEpam()
                .selectLang()
                .clickVideo();
        talksLibraryPage
                .clickMoreFilters()
                .clickCategoryFilter()
                .selectCategoryTesting()
                .clickLocationFilter()
                .selectLocationBelarus()
                .clickLanguageFilter()
                .selectLanguageEnglish();
        int j = talksLibraryPage.getFilteredCardsCount();
        String currentUrl = getWebDriver().getCurrentUrl();
        for (int i = 0; i < j-1; i++) {
            talksLibraryPage
                    .openUrl(currentUrl)
                    .clickOnFilteredCard(i);
            Assertions.assertEquals(talksLibraryPage.getLanguageInFilteredCard(),"ENGLISH");
            Assertions.assertTrue(talksLibraryPage.getLocationInFilteredCard().contains("Belarus"));
            Assertions.assertTrue(talksLibraryPage.checkTagTesting());
        }
    }

    @Test
    @DisplayName("Проверка поиска на странице Talks Library")
    @Description("Тест вводит ключевые слова в строку поиска и проверяет их отображение в найденных карточках")
    public void searchVideosTest() {
        String textForSearch = "QA";

        mainPage
                .goToEpam()
                .selectLang()
                .clickVideo();
        talksLibraryPage.enterTextToSearchField(textForSearch);


        for (int i = 0; i < talksLibraryPage.getEventsCardsCount(); i++) {
            softAssertions.assertThat(talksLibraryPage.getCardTitleByNumber(i))
                    .contains(textForSearch);
        }
        softAssertions.assertAll();
    }

}
