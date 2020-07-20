package ru.netology;

import com.codeborne.selenide.Condition;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

import static ru.netology.GeneratorFaker.*;

public class CardTest {

    private String city = getCity();
    private String name = getName();
    private String phone = getPhone();
    private String date = getDate(3);
    private String date2 = getDate(-3);
    private String date3 = getDate(55);

    private String name1 = "Роман Романов";
    private String city1 = "Краснодар";
    private String phone1 = "+79180000000";


    @Test
    void shouldReservationCardWhenValidMinData() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(city1);
        $("[placeholder='Дата встречи'").sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.DELETE);
        $("[placeholder='Дата встречи'").setValue(date);
        $("[data-test-id=\"name\"] .input__control").setValue(name1);
        $("[name='phone']").setValue(phone1);
        $(".checkbox__box").click();
        $(byText("Запланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void shouldReservationCardWhenValidMoreData() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(city1);
        $("[placeholder='Дата встречи'").sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.DELETE);
        $("[placeholder='Дата встречи'").setValue(date3);
        $("[data-test-id=\"name\"] .input__control").setValue(name1);
        $("[name='phone']").setValue(phone1);
        $(".checkbox__box").click();
        $(byText("Запланировать")).click();
        $(withText("Перепланировать")).click();
    }

    @Test
    void shouldReservationCardWhenInvalidLess3DaysData() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(city1);
        $("[placeholder='Дата встречи'").sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.DELETE);
        $("[placeholder='Дата встречи'").setValue(date2);
        $("[data-test-id=\"name\"] .input__control").setValue(name1);
        $("[name='phone']").setValue(phone1);
        $(".checkbox__box").click();
        $(byText("Запланировать")).click();
        $(withText("Заказ на выбранную дату невозможен")).waitUntil(Condition.visible, 2000);
    }

    @Test
    void shouldReservationCardWhenValidMinDataWithRandom() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(city);
        $("[placeholder='Дата встречи'").sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.DELETE);
        $("[placeholder='Дата встречи'").setValue(date);
        $("[data-test-id=\"name\"] .input__control").setValue(name);
        $("[name='phone']").setValue(phone);
        $(".checkbox__box").click();
        $(byText("Запланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void shouldReservationCardWhenValidMoreDataWithRandom() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(city1);
        $("[placeholder='Дата встречи'").sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.DELETE);
        $("[placeholder='Дата встречи'").setValue(date3);
        $("[data-test-id=\"name\"] .input__control").setValue(name);
        $("[name='phone']").setValue(phone);
        $(".checkbox__box").click();
        $(byText("Запланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void shouldReservationCardWhenInvalidLess3DaysDataWithRandom() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(city);
        $("[placeholder='Дата встречи'").sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.DELETE);
        $("[placeholder='Дата встречи'").setValue(date2);
        $("[data-test-id=\"name\"] .input__control").setValue(name);
        $("[name='phone']").setValue(phone);
        $(".checkbox__box").click();
        $(byText("Запланировать")).click();
        $(withText("Заказ на выбранную дату невозможен")).waitUntil(Condition.visible, 2000);
    }


}
