package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {

    private final SelenideElement
            title = $("h1"),
            becomeClientBtn = $(byTagAndText("button", "Стать клиентом")),
            universalClientForm = $("#universal-form-component"),
            universalClientFormInput = $("#universal-form-component")
                    .$("[data-at='tochka-ui/label']"),
            shopBlock = $$("[class=container]").findBy(text("Универмаг")),
            contactsLink = $("footer")
                    .$(byTagAndText("a", "Контакты")),
            requisitesLink = $("footer")
                    .$(byTagAndText("a", "Реквизиты Точки")),
            downloadAppBtn = $("footer")
                    .$(byTagAndText("button", "Скачать приложение Точки")),
            authBtn = $(byTagAndText("a", "Войти")),
            loginInput = $("[data-at='LoginForm/Login']"),
            passwordInput = $("[data-at='LoginForm/Password']"),
            loginBtn = $("[data-at='LoginForm/Submit']"),
            alertPopup = $("[data-at='DAlert']");

    public MainPage openPage() {
        open("https://tochka.com/");
        return this;
    }

    public MainPage checkPageTitle() {
        title.shouldHave(exactText("Банк для предпринимателей и предприятий"));
        return this;
    }

    public MainPage clickBecomeClientBtn() {
        becomeClientBtn.click();
        sleep(3000);
        return this;
    }

    public MainPage checkClientFormVisible() {
        universalClientForm.shouldHave(text("Пора открывать счёт. Чего же ты ждёшь?"));
        universalClientFormInput.should(exist).shouldBe(visible);
        return this;
    }

    public MainPage checkShopBlock() {
        shopBlock.scrollIntoView(true)
                .shouldHave(text("Одежда и аксессуары от Точки"));
        return this;
    }

    public MainPage checkContactsLink() {
        contactsLink.scrollIntoView(true)
                .shouldHave(attribute("href", "https://tochka.com/contact/"));
        return this;
    }

    public MainPage checkRequisitesLink() {
        requisitesLink.shouldHave(attribute("href",
                "https://tochka.com/contact/requisites/"));
        return this;
    }

    public MainPage checkDownloadAppButton() {
        downloadAppBtn.parent()
                .shouldHave(tagName("a"))
                .shouldHave(attribute("href",
                        "https://tochka.com/rko/app/"));
        return this;
    }

    public MainPage openAuthPageByButton() {
        authBtn.click();
        return this;
    }

    public MainPage checkAuthPageUrl() {
        webdriver().shouldHave(url("https://id.tochka.com/"));
        return this;
    }

    public MainPage auth(String value) {
        loginInput.setValue(value);
        passwordInput.setValue(value);
        loginBtn.click();
        return this;
    }

    public MainPage checkAlertDoesntExist() {
        alertPopup.shouldNot(exist);
        return this;
    }

    public MainPage checkAlertappear() {
        alertPopup.should(appear)
                .shouldHave(text("Неверный логин или пароль. Попробуйте ещё раз или восстановите пароль."));
        return this;
    }
}
