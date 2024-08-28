package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ShopPage {
    private final SelenideElement
            cartWidgetBtn = $("[class*='header_buttonGroup']").$("[type*='button']"),
            cartWidgetContent = $("[class*='cart_paddingCart']"),
            cartWidgetCloseBtn = $("[class*='cart_cartHeaderButton']"),
            searchBtn = $("[class*='search_searchButton']"),
            searchInput = $("form input[placeholder='Введите слово для поиска']"),
            searchResult = $("dd").$("a"),
            productTitle = $("h1"),
            productPrice = $("[class*='product-card-price']"),
            addToCartBtn = $("[class*='product-item-page_description']").$("[type='submit']"),
            moveToCartBtn = $("a[href='/cart/']");
    private final ElementsCollection productBlockGroup = $$("[class*='box_variant-outline']");

    public ShopPage openPage() {
        open("https://shop.tochka.com/");
        return this;
    }

    public ShopPage openSearchPopup() {
        searchBtn.click();
        return this;
    }

    public ShopPage searchProduct(String name) {
        searchInput.setValue(name);
        sleep(3000);
        searchResult.click();
        return this;
    }

    public ShopPage checkProductCardTitle(String name) {
        productTitle.shouldHave(text(name));
        return this;
    }

    public ShopPage checkProductCardPrice(String price) {
        productPrice.shouldHave(text(price));
        return this;
    }

    public ShopPage addProductToCart() {
        sleep(2000);
        addToCartBtn.click();
        return this;
    }

    public ShopPage checkCartIsEmpty() {
        cartWidgetBtn.click();
        sleep(1000);
        cartWidgetContent.shouldHave(text("Ваша корзина пуста"));
        cartWidgetCloseBtn.click();
        return this;
    }

    public ShopPage openCart() {
        moveToCartBtn.click();
        return this;
    }

    public ShopPage checkProductPriceInCart(String price) {
        productBlockGroup.filterBy(text(price))
                .shouldHave(size(3));
        return this;
    }

    public ShopPage checkProductNameInCart(String name) {
        productBlockGroup.filterBy(text(name))
                .shouldHave(size(1));
        return this;
    }
}
