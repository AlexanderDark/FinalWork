# FinalWork
Финальная проектная работа
 от EPAM

### В проекте используется:

Java + Maven + Junit 5
Подключен Allure2
Настроено логирование с помощью log4j
Реализована возможность кроссбаузерного тестирования и удаленного запуска тестов
Реализована возможность параллельного запуска тестов с помощью Selenoid
Для работы со страницами используется паттерн Page Object

*Дополнительно: Настроена интеграция с CI и запуск тестов по расписанию - В Процессе


### Окружение
Для запуска проекта необходим настроенный Docker.
Также необходимо установить и настроить Selenoid. Можно воспользоваться файлом Selenoid.bat в папке Selenoid в текущем проекте.

### Как запускать
Для запуска тестом в терминале нужно ввести команду:

mvn clean test -Dbrowser="chrome" allure:serve

После выполнения всех тестов будет сформирован allure отчёт по пройденным тестам.