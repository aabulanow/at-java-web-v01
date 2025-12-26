package work.part07.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPageFloat {
    SelenideElement
            HOME = $("a[href='#home']"),
            NEWS = $("a[href='#news']"),
            Contact = $("//a[normalize-space()='Contact']"),
            About = $x("a[href='#about']");


    @Step("Проверка, что дата уже прошла")
    public void HOME() {this.HOME.shouldHave(text("Home"));
    }
    @Step("Проверка, что дата уже прошла")
    public void NEWS() {this.NEWS.shouldHave(text("News"));
    }
    @Step("Проверка, что дата уже прошла")
    public void Contact() {this.Contact.shouldHave(text("Contact"));
    }
    @Step("Проверка, что дата уже прошла")
    public void About() {this.About.shouldHave(text("About"));
    }


}