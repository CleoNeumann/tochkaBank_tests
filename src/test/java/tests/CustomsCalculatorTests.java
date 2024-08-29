package tests;

import data.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pages.CustomsCalculatorPage;

import static io.qameta.allure.Allure.step;

@Tag("regression")
@DisplayName("Тесты калькулятора таможенных платежей")
public class CustomsCalculatorTests extends TestBase {

    CustomsCalculatorPage ccp = new CustomsCalculatorPage();

    @ParameterizedTest(name = "Успешный расчет в калькуляторе таможенных платежей {0}")
    @EnumSource(Calculator.class)
    void customsCalculatorResultTableTest(Calculator calculator) {
        step("Открыть страницу таможенного калькулятора", () -> {
            ccp.openPage();
        });
        step("Заполнить форму", () -> {
            ccp.selectProduct(calculator.getProduct())
                    .selectProductCountry(calculator.getCountry())
                    .selectProductCurrency(calculator.getCurrency())
                    .selectProductCost(calculator.getCost())
                    .selectProductWeight(calculator.getWeight())
                    .selectProductVat();
        });
        step("Рассчитать расходы по форме", () -> {
            ccp.calculateTheCost();
        });
        step("Проверить результаты работы калькулятора", () -> {
            ccp.checkResultTable(calculator.getResult());
        });
    }
}
