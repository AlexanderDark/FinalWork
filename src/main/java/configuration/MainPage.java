package configuration;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement elLoginBtn = $x("//span[@class='header2__auth-req']");

    public MainPage clickLoginBtn () {
        elLoginBtn.should(Condition.visible).click();
        return this;
    }
}
