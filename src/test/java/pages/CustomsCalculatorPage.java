package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CustomsCalculatorPage {
    private final SelenideElement
            productInput = $("#product"),
            productSelector = $("[class*='autocomplete-option_option']"),
            productCountry = $("#country"),
            productCurrency = $("#currency"),
            productCurrencyContent = $("[class*='autocomplete-view_content']"),
            productCost = $("#cost"),
            productWeight = $("#G38"),
            productVat = $("#rate_3"),
            calculatorBtn = $("[class*='calculator_button']"),
            calculatorTitle = $(byTagAndText("h5", "Ваши затраты")),
            tableResult = $("tfoot tr");

    public CustomsCalculatorPage openPage() {
        open("https://tochka.com/foreignpayments/customs-calculator/");
        return this;
    }

    public CustomsCalculatorPage selectProduct(String name) {
        productInput.setValue(name);
        sleep(3000);
        while (!productInput.text().equalsIgnoreCase(name)) {
            productInput.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.CLEAR));
            productInput.setValue(name);
            sleep(3000);
        }
        productSelector.click();
        return this;
    }

    public CustomsCalculatorPage selectProductCountry(String country) {
        productCountry.setValue(country);
        sleep(1000);
        productSelector.click();
        return this;
    }

    public CustomsCalculatorPage selectProductCurrency(String currency) {
        productCurrency.click();
        productCurrencyContent.$(byText(currency)).click();
        return this;
    }

    public CustomsCalculatorPage selectProductCost(String cost) {
        productCost.setValue(cost);
        return this;
    }

    public CustomsCalculatorPage selectProductWeight(String weight) {
        productWeight.setValue(weight);
        return this;
    }

    public CustomsCalculatorPage selectProductVat() {
        productVat.click();
        sleep(1000);
        productSelector.click();
        return this;
    }

    public CustomsCalculatorPage calculateTheCost() {
        calculatorBtn.click();
        return this;
    }

    public CustomsCalculatorPage checkResultTable(String result) {
        calculatorTitle.scrollIntoView(true);
        tableResult.shouldHave(text(result));
        return this;
    }
}
