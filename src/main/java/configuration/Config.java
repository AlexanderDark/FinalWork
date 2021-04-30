package configuration;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;

//Конфигурация селенида
public class Config {
    public static void  init () {
        Configuration.startMaximized = true;
        //для дебага
        Configuration.holdBrowserOpen = true;
        Configuration.browser = Browsers.CHROME;
        Configuration.baseUrl="https://otus.ru";
    }
}
