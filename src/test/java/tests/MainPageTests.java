package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

import static io.qameta.allure.Allure.step;

@Tag("regression")
@DisplayName("Тесты главной страницы")
public class MainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка важных составляющих главной страницы")
    void importantPartsOfMainPageTest() {
        step("Открыть главную страницу", () -> {
            mainPage.openPage()
                    .checkPageTitle();
        });
        step("Проверить наличие клиентской формы", () -> {
            mainPage.clickBecomeClientBtn()
                    .checkClientFormVisible();
        });
        step("Проверить наличие блока с магазином", () -> {
            mainPage.checkShopBlock();
        });
        step("Проверить юридическую информацию в футере", () -> {
            mainPage.checkContactsLink()
                    .checkRequisitesLink()
                    .checkDownloadAppButton();
        });
    }

    @ParameterizedTest(name = "Тест негативной авторизации {0}")
    @ValueSource(strings = {
            "admin",
            "123"
    })
    void negativeAuthorizationTest(String value) {
        step("Открыть главную страницу", () -> {
            mainPage.openPage();
        });
        step("Открыть страницу авторизации по кнопке в шапке", () -> {
            mainPage.openAuthPageByButton()
                    .checkAuthPageUrl();
        });
        step("Проверить отображение попапа с ошибкой после неуспешной авторизации", () -> {
            mainPage.checkAlertDoesntExist()
                    .auth(value)
                    .checkAlertappear();
        });
    }
}
