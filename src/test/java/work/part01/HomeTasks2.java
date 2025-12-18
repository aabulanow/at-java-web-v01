package work.part01;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import io.qameta.allure.Allure;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import java.util.Objects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class HomeTasks2 {
    @BeforeEach
    void setUp() {
        Configuration.browser = "firefox";
    }

    @Test
    void test01SimpleModal() {
        Configuration.pageLoadStrategy = "eager";
        open("https://www.specialist.ru/");
        $x("//*[@id='cookieConsent__ok']").shouldBe(exist);
        $x("//*[@id='cookieConsent__ok']").click();
        $x("//a[contains(text(),'Форматы обучения')]").click();
        $x("//a[contains(text(),'Свободное обучение')]").click();
        $x("//a[@class='page-button banner-button']").click();
        $x("//select[@id='Filter_CategoriesDirectionFilter']").click();
        $x("//button[@id='sendBtn']").click();
        $x("//a[contains(text(),'Тестирование ПО. Уровень 1. Тестировщик программно')]").shouldBe(exist);
    }
    @Test
    void test01() {
        Configuration.pageLoadStrategy = "eager";
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $x("//input[@name='age']").sendKeys("12");
        String dateValue = "16-12-2025";
        $x("//input[@name='date']").setValue(dateValue);
        $x("//input[@value='8']").click();
        $x("//input[@value='back']").click();
        $x("//input[@value='Рассчитать']").click();
        $x("//div[contains(text(),':')]").shouldHave(text("Стоимость билета: 400 рублей."));
        sleep(1000);
    }
    @Test
    void test02() {
        Configuration.pageLoadStrategy = "eager";
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $x("//input[@name='age']").sendKeys("18");
        String dateValue = "16-12-2025";
        $x("//input[@name='date']").setValue(dateValue);
        $x("//input[@value='10']").click();
        $x("//input[@value='crime']").click();
        $x("//input[@value='Рассчитать']").click();
        $x("//div[contains(text(),':')]").shouldHave(text("Стоимость билета: 400 рублей."));
    }
    @Test
    void test03() {
        Configuration.pageLoadStrategy = "eager";
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $x("//input[@name='age']").sendKeys("12");
        String dateValue = "16-12-2025";
        $x("//input[@name='date']").setValue(dateValue);
        $x("//input[@value='10']").click();
        $x("//input[@value='crime']").click();
        $x("//input[@value='Рассчитать']").click();
        $x("//div[contains(text(),':')]").shouldHave(text("Стоимость билета: *Этот фильм можно смотреть только с 18 лет*"));
    }

    @Test
    void test04() {
        Configuration.pageLoadStrategy = "eager";
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $x("//input[@name='age']").sendKeys("12");
        String dateValue = "16-12-2025";
        $x("//input[@name='date']").setValue(dateValue);
        $x("//input[@value='1']").click();
        $x("//input[@value='king']").click();
        $x("//input[@value='Рассчитать']").click();
        $x("//div[contains(text(),':')]").shouldHave(text("Стоимость билета: 350 рублей."));
    }
    @Test
    void test05() {
        Configuration.pageLoadStrategy = "eager";
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $x("//input[@name='age']").sendKeys("17");
        $x("//input[@name='date']").sendKeys("25");
        $x("//input[@value='1']").click();
        $x("//input[@value='tango']").click();
        $x("//input[@value='Рассчитать']").click();
        $x("//div[contains(text(),':')]").shouldHave(text("Стоимость билета: *Этот фильм можно смотреть только с 18 лет*"));
    }



    @ParameterizedTest
    @CsvFileSource(resources = "data.csv", numLinesToSkip = 1)
    void test02_param_cinema(String age, String dateValue, String start, String film, String priceMessage) {
        open("http://92.51.36.108:7777/sl.qa/cinema/index.php");
        $("input[name=age]").setValue(age);
        $("input[name='date']").setValue(dateValue); // Дата в формате YYYY-MM-DD
        $("input[name=session][value='" + start + "']").click();
        $("input[name=film][value=" + film + "]").click();
        $("input[type=submit").click();
        $("div").shouldHave(text(priceMessage));
        sleep(1_000);
}