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
    public void videoFiltersTest() throws InterruptedException {
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
        String currentUrl = getWebDriver().getCurrentUrl();

        for (int i = 0; i < talksLibraryPage.getFilteredCardsCount()-1; i++) {
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
    @Description("Тест вводит слово  QA в строку поиска и проверяет отображение карточек мероприятий соответствующих поиску")
    public void searchFieldTest() throws InterruptedException {
        mainPage
                .goToEpam()
                .selectLang()
                .clickVideo();
        talksLibraryPage.enterQATextToSearchField();

      for (int i = 0; i < talksLibraryPage.getFilteredCardsCount(); i++) {
            Assertions.assertTrue(talksLibraryPage.getTitleOfCard(i).contains("QA"));
        }
    }

}
