package work.part07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import work.part07.pages.LoginPageHT2;
import work.part07.pages.statusCodes;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@TestMethodOrder(MethodOrderer.DisplayName.class)
public class TheInternettests2 {

    @BeforeEach
    void setUp() {
        open("https://the-internet.herokuapp.com/status_codes");
        getWebDriver().manage().window().maximize();
    }
    // ... Автотесты

    @Test
    void test09() {
        // Страница логина
        statusCodes statusCodes = new statusCodes();
        statusCodes.codes200();
        statusCodes.isCode200();
        statusCodes.returns();
        statusCodes.codes300();
        statusCodes.isCode300();
        statusCodes.returns();
        statusCodes.codes400();
        statusCodes.isCode400();
        statusCodes.returns();
        statusCodes.codes500();
        statusCodes.isCode500();
        statusCodes.returns();

}

}




