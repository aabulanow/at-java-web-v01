package work.part01;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import org.openqa.selenium.Alert;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.clickable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.net.HttpURLConnection;
import java.net.URL;
import static com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.net.HttpURLConnection;
import java.net.URL;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;



public class PART4 {
    @Test
    void test01IFrame() {
        //Configuration.pageLoadTimeout = 120_000;
        Configuration.pageLoadStrategy = "eager";

        open("https://practice-automation.com/iframes/");
        getWebDriver().manage().window().maximize();

        $x("//*[@class='wp-block-spacer'][2]").scrollTo(); //для демонстрации
        sleep(5_000);
        switchTo().frame($x("//div[@class='entry-content']/iframe[@id='iframe-2']"));
        $x("//a[contains(.,'About')]").click();
        sleep(5_000);
        $x("//a[contains(.,'About Selenium')]").click();
        sleep(5_000);

        switchTo().defaultContent();
        $x("//body").scrollTo(); //для демонстрации
        sleep(5_000);
        $x("//a[text()='Home']").click();
        sleep(10_000);
    }

    @Test
    void test02IFrame() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/frames");
        sleep(3000);
        getWebDriver().manage().window().maximize();
        switchTo().frame($x("//iframe[@id='frame1']"));
        $("#sampleHeading").shouldHave(text("This is a sample page"));
        switchTo().defaultContent();
        $x("//header/a").click();
        sleep(3000);
    }
    @Test
    void test01SimpleAlert() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/popups/");
        $("#alert").click();
        sleep(2_000);
        switchTo().alert().accept();
        sleep(2_000);
    }
    @Test
    void test02ConfirmOk() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/popups/");
        $("#confirm").click();
        Alert alert = switchTo().alert();
        System.out.println(alert.getText());
        sleep(2_000);
        alert.accept();
        sleep(2_000);
    }
    @Test
    void test03ConfirmCancel() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/popups/");
        $("#confirm").click();
        Alert alert = switchTo().alert();
        System.out.println(alert.getText());
        sleep(2_000);
        alert.dismiss();
        sleep(2_000);
    }
    @Test
    void test04PromptOk() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/popups/");
        $("#prompt").click();
        Alert alert = switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys("Сергей");
        sleep(2_000);
        alert.accept();
        sleep(2_000);
    }
    @Test
    void test05PromptCancel() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/popups/");
        $("#prompt").click();
        Alert alert = switchTo().alert();
        System.out.println(alert.getText());
        sleep(2_000);
        alert.dismiss();
        sleep(2_000);
    }
    @Test
    void test01SimpleModal() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/modals/");
        $x("//div[@id='popmake-1318']").shouldBe(exist);
        $("#simpleModal").click();
        sleep(2_000);
        $x("//div[@id='popmake-1318']").shouldBe(visible);
        $x("//div[@id='popmake-1318']//button").shouldBe(clickable);
        $x("//div[@id='popmake-1318']//button").click();
        sleep(2_000);
    }

    @Test
    void test02SimpleAlert() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/alerts");
        $("#timerAlertButton").click();
        sleep(2_000);
        switchTo().alert().accept();
        sleep(2_000);
    }

    @Test
    void test02SimpleModal() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/modal-dialogs");
        $x("//button[@id='showLargeModal']").shouldBe(exist);
        sleep(2_000);
        $x("//button[@id='showLargeModal']").shouldBe(visible);
        $x("//button[@id='showLargeModal']").shouldBe(clickable);
        $x("//button[@id='showLargeModal']").click();
        sleep(2_000);
    }

    @Test
    void test03SimpleModal() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/modal-dialogs");
        $x("//button[@id='showSmallModal']").shouldBe(exist);
        sleep(2_000);
        $x("//button[@id='showSmallModal']").shouldBe(visible);
        $x("//button[@id='showSmallModal']").shouldBe(clickable);
        $x("//button[@id='showSmallModal']").click();
        sleep(2_000);
        $x("//button[@id='showLargeModal']").click();
        sleep(2_000);
    }

    @Test
    void test04SimpleModal() {
        Configuration.pageLoadStrategy = "eager";
        open("https://demoqa.com/modal-dialogs");
        $x("//button[@id='showSmallModal']").shouldBe(exist);
        sleep(2_000);
        $x("//button[@id='showSmallModal']").shouldBe(visible);
        $x("//button[@id='showSmallModal']").shouldBe(clickable);
        $x("//button[@id='showSmallModal']").click();
        sleep(2_000);
        open("https://demoqa.com/home");
        sleep(2_000);
    }
    @Test
    void test02AllLinksV2() {
        open("https://ru.wikipedia.org/wiki/Selenium");
        //open("https://slqa.ru/cases/");
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        int i = 0;
        for (SelenideElement se : $$("a").filter(clickable).filter(visible).filter(enabled)) {
            i++;
            System.out.println(i + ". " + se.getText() + ", " + se.getDomAttribute("href")
                    + ", размер: " + se.getSize());
            if ((se.getSize().height <= 1) || (se.getSize().width <= 1)) {
                System.out.println("Элемент слишком маленький, по нему невозможно кликнуть.");
                continue;
            }
            actions.keyDown(Keys.LEFT_CONTROL).build().perform();
            se.click();
            switchTo().window(1);
            $("body").shouldBe(exist);
            String str_url = WebDriverRunner.driver().url();
            try {
                URL url = new URL(str_url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
                int code = connection.getResponseCode();
                System.out.println(str_url + " - " + code);
            } catch (Exception e) {
                System.out.println(str_url + " - некорректная ссылка");
            }
            closeWindow();
            switchTo().window(0);
        }
    }

}

