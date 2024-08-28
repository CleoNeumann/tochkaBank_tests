package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ContractorsPage {
    private final SelenideElement
            contractorSearchInput = $("#check-company-search-autocomplete"),
            contractorSearchResult = $("[class*='autocomplete-option_option__id']"),
            contractorEmptySearchResult = $("[class*='autocomplete-view_content']"),
            contractorTitle = $("h1"),
            contractorStatus = $("h1").sibling(0);

    public ContractorsPage openPage() {
        open("https://check.tochka.com/#CheckContractorTopBlockId");
        sleep(2000);
        return this;
    }

    public ContractorsPage searchContractor(String value) {
        contractorSearchInput.setValue(value);
        contractorSearchResult.click();
        return this;
    }

    public ContractorsPage checkContractorTitle(String name) {
        sleep(2000);
        contractorTitle.shouldHave(text(name));
        return this;
    }

    public ContractorsPage checkContractorStatus(String status) {
        contractorStatus.shouldHave(text(status));
        return this;
    }

    public ContractorsPage searchNullContractor() {
        contractorSearchInput.setValue("123123123!@#$%^&*(");
        return this;
    }

    public ContractorsPage checkErrorResult() {
        contractorEmptySearchResult.shouldHave(text("Ничего похожего не нашли. Попробуйте написать по-другому."));
        return this;
    }
}
