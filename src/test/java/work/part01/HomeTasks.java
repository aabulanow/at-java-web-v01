package work.part01;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

class HomeTasks {
    @Test
    public void test01LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).type("stand_pass1");
        $(By.id("loginButton")).click();
        $(By.className("greeting")).shouldHave(text("Добро пожаловать, Иванов Иван Иванович!"));

    }
    @Test
    public void test02LoginWrongPassword() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $(By.id("username")).sendKeys("standard_user");
        $(By.id("password")).type("stand_pass11");
        $(By.id("loginButton")).click();
        $("body").shouldHave(text("Неверное имя пользователя или пароль."));
    }

    @Test
    public void testPageH1() {
        open("https://slqamsk.github.io/tmp/xPath01.html");
        $x("//h1").shouldHave(text("Учебная страница для XPath"));
        $x("//h1").shouldHave(exactText("Учебная страница для XPath"));
    }

    @Test
    public void testSpecialParagraph() {
        open("https://slqamsk.github.io/tmp/xPath01.html");
        $x("//p[@class='special-paragraph']").shouldHave(exactText("Этот параграф особенный - он единственный на странице с таким классом."));
        $x("//p[@class='info-text']").shouldHave(exactText("Это первый информационный текст."));
    }

    @Test
    public void testFindByText3() {
        open("https://slqa.ru/cases/xPathSimpleForm/");
        $x("//*[starts-with(.,'Казахстан')]").shouldHave(text("площадь 2 724 902"));

    }
    @Test
    public void testFindByText2() {
        open("https://slqa.ru/cases/xPathSimpleForm/");
        $x("//*[contains(.,'Питер')]").shouldHave(text("180 единиц"));

    }
    @Test
    public void testFindByText1() {
        open("https://slqa.ru/cases/xPathSimpleForm/");
        $(withText("Москва")).shouldHave(text("250 единиц"));

    }
}

