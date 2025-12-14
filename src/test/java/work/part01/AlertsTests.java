package work.part01;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.net.HttpURLConnection;
import java.net.URL;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;



    public class AlertsTests {
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

}

