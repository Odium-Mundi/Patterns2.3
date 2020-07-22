package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static ru.netology.GeneratorFaker.*;

public class CardTest {

    private String city = getCity();
    private String name = getName();
    private String phone = getPhone();
    private String date = getDate(3);
    private String date2 = getDate(-3);
    private String date3 = getDate(55);


    @Test
    void shouldReplanWhenClientExist() {

        User user1 = new User(name, phone, city, date3);

        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(user1.city);
        $("[placeholder='Дата встречи'").sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.DELETE);
        $("[placeholder='Дата встречи'").setValue(date3);
        $("[data-test-id=\"name\"] .input__control").setValue(user1.name);
        $("[name='phone']").setValue(user1.phone);
        $(".checkbox__box").click();
        $(byText("Запланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);

        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(user1.city);
        $("[placeholder='Дата встречи'").sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.DELETE);
        $("[placeholder='Дата встречи'").setValue(date3);
        $("[data-test-id=\"name\"] .input__control").setValue(user1.name);
        $("[name='phone']").setValue(user1.phone);
        $(".checkbox__box").click();
        $(byText("Запланировать")).click();
        $(withText("Перепланировать")).click();


    }

    @Test
    void validDateWithRandom() {
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
    void validDatePlus55WithRandom() {
        open("http://localhost:9999");
        $("[placeholder='Город']").setValue(city);
        $("[placeholder='Дата встречи'").sendKeys(Keys.LEFT_SHIFT, Keys.HOME, Keys.DELETE);
        $("[placeholder='Дата встречи'").setValue(date3);
        $("[data-test-id=\"name\"] .input__control").setValue(name);
        $("[name='phone']").setValue(phone);
        $(".checkbox__box").click();
        $(byText("Запланировать")).click();
        $(withText("Успешно!")).waitUntil(Condition.visible, 15000);
    }

    @Test
    void invalidDateWithRandom() {
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
