package com.example.phonebook.service;

import com.example.phonebook.util.PhoneBookCatalogInit;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    private final Map<String, String> phoneBookCatalog = PhoneBookCatalogInit.getPhoneBook();

    public void printList() { // the example how to do it using Stream API
        this.phoneBookCatalog.forEach((key, value) -> System.out.println("\nИмя: " + key + ", Номер телефона: " + value));
        }

    public boolean isName(String userInput) {
        return userInput.matches("[a-zA-Zа-яА-Я]+");
    }

    public boolean isPhoneNumber(String userInput) {
        return userInput.matches("\\+?\\d{10,16}");
    }

    public String getName(String str) {
        Matcher match = Pattern.compile("[ a-zA-ZА-Яа-яёЁ]+").matcher(str);
        match.find();
        return match.group();
    }

    public void addEntry(String name, String number, Map<String, String> phonebook) {
        phonebook.put(name, number);
    }

    public Map<String, String> getPhoneBookCatalog() {
        return this.phoneBookCatalog;
    }
}
