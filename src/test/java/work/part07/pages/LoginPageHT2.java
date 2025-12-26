package work.part07.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageHT2 {
    SelenideElement username  = $("#username");
    SelenideElement password = $("#password");
    SelenideElement
            loginButton = $(".fa.fa-2x.fa-sign-in"),
            logoutButton = $(".icon-2x.icon-signout"),
            errorMessage = $("#flash"),
            greeting = $("#flash");


    @Step("Вход в систему")
    public void login(String username, String password) {
        // $("#username").setValue("standard_user");
        this.username.setValue(username);
        this.password.setValue(password);
        this.loginButton.click();
    }

    @Step("Вход в систему")
    public void logout() {
        this.logoutButton.click();
    }

        @Step("Неуспешный логин")
    public void isPassUnsuccessful() {
        this.errorMessage.shouldHave(text("Your password is invalid!"));
    }

    @Step("Успешный логин")
    public void isLoginSuccessful() {
        this.greeting.shouldHave(text("You logged into a secure area!"));
    }

    @Step("Проверка, что заблокированный пользователь - заблокирован")
    public void isUserIsLocked() {
        this.errorMessage.shouldHave(text("Пользователь заблокирован."));
    }


}