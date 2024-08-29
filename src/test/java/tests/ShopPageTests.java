package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.ShopPage;

import static io.qameta.allure.Allure.step;

@Tag("regression")
@DisplayName("Тесты магазина")
public class ShopPageTests extends TestBase {

    ShopPage shopPage = new ShopPage();

    @ParameterizedTest(name = "Успешное добавление товара {0} в корзину")
    @CsvSource(value = {
            "стикеры, 900",
            "говорящая кружка, 1 590"
    }, ignoreLeadingAndTrailingWhitespace = true)
    void addProductToCartTest(
            String name,
            String price
    ) {

        step("Открыть страницу магазина", () -> {
            shopPage.openPage();
        });
        step("Проверить, что корзина пустая", () -> {
            shopPage.checkCartIsEmpty();
        });
        step("Выбрать товар", () -> {
            shopPage.openSearchPopup()
                    .searchProduct(name);
        });
        step("Проверить карточку товара", () -> {
            shopPage.checkProductCardTitle(name)
                    .checkProductCardPrice(price);
        });
        step("Проверить добавление товара в корзину", () -> {
            shopPage.addProductToCart()
                    .openCart()
                    .checkProductPriceInCart(price)
                    .checkProductNameInCart(name);
        });
    }
}
