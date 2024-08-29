# Проект по автоматизации тестовых сценариев для <a href="https://tochka.com/"> Точка-Банк</a></h1>
****
## ☑️ Содержание:
- Использованные технологии и инструменты
    - Содержание Allure Report
- Запуск автотестов
    - Запуск тестов из терминала
    - Запуск тестов на удаленном браузере
    - Параметры сборки
- Визуализация
    - Сборка в Jenkins
    - Пример Allure Report
    - Интеграция с Allure TestOps
    - Интеграция с Jira
    - Уведомление в Telegram
    - Демо видео запуска тестов
****

## ☑️ Использованные технологии и инструменты

<p align="center">
<img width="7%" title="IntelliJ IDEA" src="media/logo/Idea.svg">
<img width="7%" title="Java" src="media/logo/Java.svg">
<img width="7%" title="Gradle" src="media/logo/Gradle.svg">
<img width="7%" title="JUnit5" src="media/logo/Junit5.svg">
<img width="7%" title="Selenide" src="media/logo/Selenide.svg">
<img width="7%" title="Jenkins" src="media/logo/Jenkins.svg">
<img width="7%" title="Selenoid" src="media/logo/Selenoid.svg">
<img width="7%" title="Allure Report" src="media/logo/Allure.svg">
<img width="7%" title="Allure TestOps" src="media/logo/Allure_TO.svg">
<img width="7%" title="GitHub" src="media/logo/GitHub.svg">
<img width="7%" title="Telegram" src="media/logo/Telegram.svg">
<img width="7%" title="Jira" src="media/logo/Jira.svg">
</p>

- В данном проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования <code>Selenide</code>.
- В качестве сборщика был выбран - <code>Gradle</code>.
- Использован фреймворк модульного тестирования <code>JUnit 5</code>.
- При прогоне тестов запуск браузера происходит в <code>Selenoid</code>.
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием <code>Allure Report</code>.
- После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом в специальную группу.
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>

### Содержание Allure Report:
- Шаги теста;
- Скриншот страницы на последнем шаге;
- Page Source;
- Логи браузерной консоли;
- Видео выполнения автотеста.
****

## ☑️ Запуск автотестов
### Запуск тестов из терминала

```bash  
gradle clean regression_test
```
### Запуск тестов на удаленном браузере
```bash  
clean ${TASK}
-Dbrowser=${BROWSER}
-DbrowserSize=${BROWSER_SIZE}
-DbrowserVersion=${VERSION}
-Dremote=${REMOTE_SERVER}
```
### Параметры сборки:
- REMOTE_SERVER (адрес удаленного сервера Selenoid)
- BROWSER (браузер, по умолчанию chrome)
- VERSION (версия браузера, по умолчанию 126.0)
- BROWSER_SIZE (размер окна браузера, по умолчанию 1920x1080)
- TASK (набор кейсов для запуска, по умолчанию regression_test)
- BRANCH (ветка, на которой надо запустить тесты, по умолчанию master)
****

## ☑️ Визуализация
Ниже представлены скриншоты основных инструментов и процессов, используемых в ходе разработки и тестирования проекта.
<details>
  <summary>Сборка в Jenkins</summary>
<p align="center">
<img width="100%" title="Jenkins" src="media/screenshots/Jenkins.png">
</p>
</details>

<details>
  <summary>Пример Allure Report</summary>

#### Превью

<p align="center">
<img width="100%" title="AllureReportPreview" src="media/screenshots/AllureReportPreview.png">
</p>

#### Результат выполнения теста

<p align="center">
<img width="100%" title="AllureReport" src="media/screenshots/AllureReport.png">
</p>

#### Графики

<p align="center">
<img width="100%" title="AllureReportGraphs" src="media/screenshots/AllureReportGraphs.png">
</p>

</details>

<details>
  <summary>Интеграция с Allure TestOps</summary>
<p align="center">
<img width="100%" title="AllureTestOps" src="media/screenshots/AllureTestOps.png">
</p>
</details>

<details>
  <summary>Интеграция с Jira</summary>
<p align="center">
<img width="100%" title="Jira" src="media/screenshots/Jira.png">
</p>
</details>

<details>
  <summary>Уведомление в Telegram</summary>
<p align="center">
<img width="60%" title="Telegram" src="media/screenshots/Telegram.png">
</p>
</details>

<details>
  <summary>Демо видео запуска тестов</summary>
<p align="center">
  <img width="100%" title="Selenoid Video" src="media/video/video.gif">
</p>
</details>

****