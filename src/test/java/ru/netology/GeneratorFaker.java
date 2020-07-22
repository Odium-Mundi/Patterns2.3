package ru.netology;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GeneratorFaker {


    public GeneratorFaker() {

    }

    public static String getCity() {
        List<String> givenList = Arrays.asList("Краснодар", "Йошкар-Ола", "Майкоп", "Санкт-Петербург", "Москва", "Новосибирск");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));
        return randomElement;
    }

    public static String getName() {
        List<String> givenList = Arrays.asList("Виолетта Паршикова", "Ха Ха", "Иван Иванов", "Катя Иванова", "Инь-янь Иванов", "Иван Инь-янов");
        Random rand = new Random();
        String randomElement = givenList.get(rand.nextInt(givenList.size()));
        return randomElement;
    }

    public static String getPhone() {
       Faker faker = new Faker(new Locale("ru"));
       return faker.phoneNumber().phoneNumber();
    }

    public static String getDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}