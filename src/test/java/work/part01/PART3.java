package work.part01;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
public class PART3 {   @Test
public void testElementSearchMethods() {
    open("https://slqamsk.github.io/demo/search-demo/");
    $(By.id("submit-button")).shouldBe(visible);
}

}
