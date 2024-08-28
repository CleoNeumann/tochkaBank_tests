package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.ContractorsPage;

import static io.qameta.allure.Allure.step;

@Tag("regression")
@DisplayName("Тесты страницы контрагентов")
public class ContractorsPageTests extends TestBase {

    ContractorsPage contPage = new ContractorsPage();

    @ParameterizedTest(name = "Успешный поиск контрагента {2}")
    @CsvFileSource(resources = "/csv/searchContractorsTest.csv", delimiter = ';')
    void searchContractorsTest(
            String inn,
            String name,
            String status
    ) {
        step("Открыть страницу поиска контрагента", () -> {
            contPage.openPage();
        });
        step("Найти контрагента", () -> {
            contPage.searchContractor(inn);
        });
        step("Проверить данные контрагента", () -> {
            contPage.checkContractorTitle(name)
                    .checkContractorStatus(status);
        });
    }

    @Test
    @DisplayName("Поиск несуществующего контрагента")
    void searchContractorsNegativeTest() {
        step("Открыть страницу поиска контрагента", () -> {
            contPage.openPage();
        });
        step("Найти несуществующего контрагента", () -> {
            contPage.searchNullContractor();
        });
        step("Проверить сообщение ошибки", () -> {
            contPage.checkErrorResult();
        });
    }
}
