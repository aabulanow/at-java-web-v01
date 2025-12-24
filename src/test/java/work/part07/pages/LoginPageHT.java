package work.part07.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.w3c.dom.html.HTMLInputElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageHT {

    SelenideElement username; // = $("#username");
    SelenideElement password = $("#password");
    SelenideElement
        loginButton = $("#loginButton");
    SelenideElement errorMessage = $("#message");
    SelenideElement greeting = $("#greeting");
    public SelenideElement logoutButton = $("#logoutButton");


    public LoginPageHT() {
        // Конструктор писать не обязательно
        // Так используют, когда, например, надо из базы данных взять
        // информацию о локаторе
        this.username = $("#username");
    }

    @Step("Вход в систему")
    public void login(String username, String password) {
        // $("#username").setValue("standard_user");
        this.username.setValue(username);
        this.password.setValue(password);
        this.loginButton.click();
    }

    @Step("Неуспешный логин")
    public void isLoginUnsuccessful() {
        this.errorMessage.shouldBe(visible);
        this.errorMessage.shouldHave(Condition.cssClass("error"));
        this.errorMessage.shouldHave(text("Неверное имя пользователя или пароль."));
    }

    @Step("Успешный логин")
    public void isLoginSuccessful(String fio) {

        this.greeting.shouldHave(text("Добро пожаловать, " + fio + "!"));
    }

    @Step("Проверка, что заблокированный пользователь - заблокирован")
    public void isUserIsLocked()
    { this.errorMessage.shouldBe(visible);
        this.errorMessage.shouldHave(Condition.cssClass("error"));
        this.errorMessage.shouldHave(text("Пользователь заблокирован."));
    }

    @Step("Вход из системы")
    public void logout() {
        this.logoutButton.click();
    }
}