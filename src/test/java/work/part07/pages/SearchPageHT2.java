package work.part07.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPageHT2 {
    SelenideElement
            cityFrom = $("//td[normalize-space()='From:']"),
            cityTo = $("//select[@name='toPort']"),
            departureDate = $("//select[@id='departDay']"),
            departureMonth = $("//select[@id='departMonth']"),
            returnDate = $("//select[@id='returnDay']"),
            returnMonth = $("//select[@id='returnMonth']"),
            findButton = $x("//button[.='Continue']"),
            message = $("#searchMessage");
    SelenideElement
            departureCity = $x("//label[@for='departureCity']"),
            arrivalCity = $x("//label[@for='arrivalCity']"),
            departureDate1 = $x("//label[@for='departureDate']");



    @Step("Поиск рейсов (задаём только дату)")
    public void search(String departureDate) {

        this.departureDate.setValue(makeDateCorrect(departureDate));
        this.findButton.click();
    }

    @Step("Поиск рейсов")
    public void search(String from, String to, String departureDate,String departureMonth,String returnDate, String returnMonth) {
        this.cityFrom.selectOption(from);
        this.cityTo.selectOption(to);
        this.departureDate.setValue(makeDateCorrect(departureDate));
        this.departureMonth.setValue(makeDateCorrect(String.valueOf(departureMonth)));
        this.returnDate.setValue(makeDateCorrect(String.valueOf(returnDate)));
        this.returnMonth.setValue(makeDateCorrect(String.valueOf(returnMonth)));
        this.findButton.click();

    }

    @Step("Проверка, что дата не указана")
    public void isDepartureDateEmpty() {
        this.message.shouldHave(text("Пожалуйста, укажите дату вылета."));
    }

    private String makeDateCorrect(String date) {
        //Передаём дату в формате DD.MM.YYYY
        if (Configuration.browser == "firefox" && date != null && date.length() == 10) {
            return date.substring(6, 10) + "-" +
                    date.substring(3, 5) + "-" +
                    date.substring(0, 2);
        }
        return date;
    }

    @Step("Проверка, что дата уже прошла")
    public void isDateInPast() {this.message.shouldHave(text("Невозможно осуществить поиск: выбранная дата уже прошла."));
    }


}