package work.part07;

import org.junit.jupiter.api.*;
import work.part07.pages.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@TestMethodOrder(MethodOrderer.DisplayName.class)
public class TheInternettests {

    @BeforeEach
    void setUp() {
        open("https://the-internet.herokuapp.com/login");
        getWebDriver().manage().window().maximize();
    }
    // ... Автотесты
    // ... Корректный логин
    @Test
    void test01() {
        // Страница логина
        LoginPageHT2 loginPage = new LoginPageHT2();
        loginPage.login("tomsmith", "SuperSecretPassword!");
        loginPage.isLoginSuccessful();
        loginPage.logout();
}
    // ... Неорректный логин
    @Test
    void test02() {
        // Страница логина
        LoginPageHT2 loginPage = new LoginPageHT2();
        loginPage.login("tomsmith", "wrongpassword!");
        loginPage.isPassUnsuccessful();
    }



}




