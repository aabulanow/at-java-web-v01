package work.part01;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class AuthorizationTests {
    @Test
    public void test01LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        SelenideElement myElement = $("input[name+username]");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).type("stand_pass1");
        $(By.id("loginButton")).click();
        $(By.className("greeting")).shouldHave(text("Добро пожаловать, Иванов Иван Иванович!"));

    }
    @Test
    public void test02LoginWrongPassword() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        SelenideElement myElement = $("input[name+username]");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).type("stand_pass11");
        $(By.id("loginButton")).click();
        $("body").shouldHave(text("Неверное имя пользователя или пароль."));
    }
}