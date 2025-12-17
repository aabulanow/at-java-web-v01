package work.part01;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;
public class HomeTasks2 {
    @Test
    void test01SimpleModal() {
        Configuration.pageLoadStrategy = "eager";
        open("https://www.specialist.ru/");
        $x("//*[@id='cookieConsent__ok']").shouldBe(exist);
        $x("//*[@id='cookieConsent__ok']").click();
        sleep(1000);
        $x("//a[contains(text(),'Форматы обучения')]").click();
        sleep(1000);
        $x("//a[contains(text(),'Свободное обучение')]").click();
        sleep(1000);
        $x("//a[@class='page-button banner-button']").click();
        sleep(1000);
        $x("//select[@id='Filter_CategoriesDirectionFilter']").click();
        sleep(1000);
        $x("//button[@id='sendBtn']").click();
        $x("//a[contains(text(),'Тестирование ПО. Уровень 1. Тестировщик программно')]").shouldBe(exist);
    }

    //a[contains(text(),'Тестирование ПО. Уровень 1. Тестировщик программно')]
    @Test
    void test02SimpleModal() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/modals/");
        $x("//div[@id='popmake-1318']").shouldBe(exist);
        $("#simpleModal").click();
        sleep(1000);
        $x("//div[@id='popmake-1318']//button")
                .shouldBe(visible)
                .shouldBe(clickable)
                .click();

        $x("//div[@id='popmake-1318']//button").shouldBe(visible);
        $x("//div[@id='popmake-1318']//button").shouldBe(clickable);
        $x("//div[@id='popmake-1318']//button").click();



        sleep(2_000);
        $x("//a[text()='Home']").click();
        sleep(2_000);
    }
}