package work.part07;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import work.part07.pages.SearchPageFloat;
import work.part07.pages.statusCodes;

public class TheInternettests3 {
    public static void main(String[] args) {
        // Установка пути к драйверу и инициализация драйвера
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/floating_menu"); // Замените на URL вашей страницы

        // 1. Прокрутка до конца страницы
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
        @Test
        void test09() {
            // Страница логина
            SearchPageFloat SearchPage = new SearchPageFloat();
            SearchPage.HOME();
            SearchPage.NEWS();
            SearchPage.Contact();
            SearchPage.About();

        }



}