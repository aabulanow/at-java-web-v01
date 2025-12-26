package work.part07;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import work.part07.pages.FlightsListPageHT;
import work.part07.pages.LoginPageHT;
import work.part07.pages.RegistrationPageHT;
import work.part07.pages.SearchPageHT;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@TestMethodOrder(MethodOrderer.DisplayName.class)
public class POMFlightsTestsHT {
    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    void setUp() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        getWebDriver().manage().window().maximize();
    }
    // ... Автотесты



    // 1. проверка залоченного пользователя
    @Test
    void test01() {
        LoginPageHT loginPage = new LoginPageHT();
        loginPage.login("locked_out_user", "lock_pass2");
        loginPage.isUserIsLocked();

    }

    // 2. Регистрация на рейс с изменением параметров пользователя + логаут
    @Test
    void test02() {
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

    // 3. Регистрация на рейс с изменением параметров пользователя с некоректным email + логаут
    @Test
    void test03() {
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




