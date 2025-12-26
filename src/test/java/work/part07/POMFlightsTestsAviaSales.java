package work.part07;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import demo.part07.pages.FlightsListPage;
import demo.part07.pages.LoginPage;
import demo.part07.pages.RegistrationPage;
import demo.part07.pages.SearchPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import work.part07.pages.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@TestMethodOrder(MethodOrderer.DisplayName.class)
public class POMFlightsTestsAviaSales {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.browser = "firefox";
    }

    @BeforeEach
    void setUp() {
        open("http://travel.agileway.net/login");
        getWebDriver().manage().window().maximize();
    }
    // ... Автотесты

    @Test
    void test07() {
        LoginPageHT loginPage = new LoginPageHT();
        loginPage.login("locked_out_user", "lock_pass2");
        loginPage.isUserIsLocked();

    }

    // 5. проверка параметров
    @Test
    void test09() {
        // Страница логина
        LoginPageHT loginPage = new LoginPageHT();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        // Страница поиска рейсов
        SearchPageHT searchPage = new SearchPageHT();
        searchPage.search("16.03.2026", "Москва", "Нью-Йорк");

        // Страница со списком найденных рейсов
        FlightsListPageHT flightsList = new FlightsListPageHT();
        flightsList.registerToFirstFlight();

        // Страница регистрации на рейс
        RegistrationPageHT registrationPage = new RegistrationPageHT();
        registrationPage.isFlightDataCorrect("Москва", "Нью-Йорк");
        registrationPage.changeRegistrationParams("Буланов Андрей Анатольевич","1111 111111", "a.a.bulanow@gmail.com","89170304453");
        registrationPage.successDefaultRegistration();

        // Кнопка логоаута
        LoginPageHT logout = new LoginPageHT();
        loginPage.logout();

    }

    // 5. проверка параметров
    @Test
    void test10() {
        // Страница логина
        LoginPageHT loginPage = new LoginPageHT();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        // Страница поиска рейсов
        SearchPageHT searchPage = new SearchPageHT();
        searchPage.search("16.03.2026", "Москва", "Нью-Йорк");

        // Страница со списком найденных рейсов
        FlightsListPageHT flightsList = new FlightsListPageHT();
        flightsList.registerToFirstFlight();

        // Страница регистрации на рейс
        RegistrationPageHT registrationPage = new RegistrationPageHT();
        registrationPage.isFlightDataCorrect("Москва", "Нью-Йорк");
        registrationPage.changeRegistrationParams("Буланов Андрей Анатольевич","1111 111111", "a.a.bulanowgmail.com","89170304453");
        registrationPage.isErrorFillEmail();

        // Кнопка логоаута
        LoginPageHT logout = new LoginPageHT();
        loginPage.logout();

    }

}