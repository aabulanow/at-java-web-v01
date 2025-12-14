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

