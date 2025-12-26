package work.part07.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class statusCodes {

    public SelenideElement
            twohundred  = $("a[href='status_codes/200']");
    SelenideElement theehundred = $("a[href='status_codes/301']");
    SelenideElement fourhundred = $("a[href='status_codes/404']");
    SelenideElement fivehundred = $("a[href='status_codes/500']");
    SelenideElement returns = $(" a[href='/status_codes']")  ;
    SelenideElement
            message  = $("div[class='example'] p");


    @Step("Вход в систему")
    public void codes200() {
        this.twohundred.click();
    }
    @Step("Вход в систему")
    public void codes300() {
        this.theehundred.click();
    }
    @Step("Вход в систему")
    public void codes400() {
        this.fourhundred.click();
    }
    @Step("Вход в систему")
    public void codes500() {
        this.fivehundred.click();
    }


    @Step("Вход из системы")
    public void returns() {
        this.returns.click();
    }

    public void isCode200() {this.message.shouldHave(text("This page returned a 200 status code."));
    }
    public void isCode300() {this.message.shouldHave(text("This page returned a 301 status code."));
    }
    public void isCode400() {this.message.shouldHave(text("This page returned a 404 status code."));
    }
    public void isCode500() {this.message.shouldHave(text("This page returned a 500 status code."));
    }


}