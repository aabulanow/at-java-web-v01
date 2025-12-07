package work.part01;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FeeCalculationTests {
    @Test
    public void test01() {
        open("https://slqa.ru/cases/fc/v01/");
        SelenideElement myElement = $("input[name+sum]");

        $(By.name("sum")).sendKeys("test");
        $(By.name("submit")).click();
        $(By.name("sum")).setValue("hhhhggh");
        $(By.name("submit")).click();
        $(By.name("sum")).type("ТЕКСТ111222222222222222222222222");
        $(By.name("submit")).click();
        $(By.name("sum")).type("1000");
        $(By.name("submit")).click();
    }
}