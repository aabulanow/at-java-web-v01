package work.part01;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.files.DownloadAction;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;
import static org.openqa.selenium.bidi.script.LocalValue.setValue;

public class LoginPage
{
    SelenideElement username = $("#username");
    SelenideElement password = $("#password");
    SelenideElement
            LoginButton = $("#LoginButton"),
            errorMessage = $("#errorMessage"),
            greeting = $("#greeting");
    private DownloadAction loginButton;

    public LoginPage() {

        this.username = $("#uername");
    }
@Step ("Вход в систему")
    public void login(String username,String password)
{this.username = setValue(username);
    this.password = setValue(password);
    this.loginButton = click();
}
@Step("Неуспешный логин")
    this.errorMessage.shouldHave(text("Неверное имя пользователя или пароль"));

}