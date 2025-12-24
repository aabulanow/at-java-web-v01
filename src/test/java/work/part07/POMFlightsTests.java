package work.part07;

import com.codeborne.selenide.logevents.SelenideLogger;
import demo.part07.pages.FlightsListPage;
import demo.part07.pages.RegistrationPage;
import demo.part07.pages.SearchPage;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import work.part07.pages.FlightsListPageHT;
import work.part07.pages.LoginPageHT;
import work.part07.pages.RegistrationPageHT;
import work.part07.pages.SearchPageHT;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;



@TestMethodOrder(MethodOrderer.DisplayName.class)
public class POMFlightsTests {
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
    // 1. Неуспешный логин
    @Test
    void test01WrongPassword() {
        LoginPageHT loginPage = new LoginPageHT();
        loginPage.login("standard_user", "WrongPassword");
        loginPage.isLoginUnsuccessful();
    }

    // 2. Не задана дата
    @Test
    void test02NoDate() {
        LoginPageHT loginPage = new LoginPageHT();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        SearchPage searchPage = new SearchPage();
        searchPage.search("");
        searchPage.isDepartureDateEmpty();
    }
    // 3. Не найдены рейсы
    @Test
    void test03FlightsNotFound() {
        LoginPageHT loginPage = new LoginPageHT();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        SearchPage searchPage = new SearchPage();
        searchPage.search("16.03.2026", "Казань", "Париж");

        FlightsListPage flightsList = new FlightsListPage();
        flightsList.isNoFlights();
    }

    //4. Успешная регистрация с данными по умолчанию
    @Test
    void test04SuccessRegistrationDefault() {
        // Страница логина
        LoginPageHT loginPage = new LoginPageHT();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        // Страница поиска рейсов
        SearchPage searchPage = new SearchPage();
        searchPage.search("16.03.2026", "Москва", "Нью-Йорк");

        // Страница со списком найденных рейсов
        FlightsListPageHT flightsList = new FlightsListPageHT();
        flightsList.registerToFirstFlight();

        // Страница регистрации на рейс
        RegistrationPageHT registrationPage = new RegistrationPageHT();
        registrationPage.isFlightDataCorrect("Москва", "Нью-Йорк");
        registrationPage.successDefaultRegistration();
        // Кнопка логоаута
        LoginPageHT logout = new LoginPageHT();
        loginPage.logout();

    }

    // 5. Пустые поля
    @Test
    void test05EmptyField() {
        // Страница логина
        LoginPageHT loginPage = new LoginPageHT();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        // Страница поиска рейсов
        SearchPage searchPage = new SearchPage();
        searchPage.search("16.03.2026", "Москва", "Нью-Йорк");

        // Страница со списком найденных рейсов
        FlightsListPage flightsList = new FlightsListPage();
        flightsList.registerToFirstFlight();

        // Страница регистрации на рейс
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.isFlightDataCorrect("Москва", "Нью-Йорк");
        registrationPage.registration("", "", "", "");
        registrationPage.isErrorFillAllFied();
    }
    @Test
    void test06() {
        LoginPageHT loginPage = new LoginPageHT();
        loginPage.login("standard_user", "stand_pass1");
        loginPage.isLoginSuccessful("Иванов Иван Иванович");

        SearchPage searchPage = new SearchPage();
        searchPage.search("01.01.2024");
        searchPage.isDateInPast();
    }

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




