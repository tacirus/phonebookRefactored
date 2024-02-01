package com.example.phonebook.service;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

    private Map<String, String> phoneBook = Utils.getPhoneBook();

    public void printList() {
        for (Map.Entry<String, String> entry : this.phoneBook.entrySet()) {
            String contactName = entry.getKey();
            String contactNumber = entry.getValue();
            System.out.println("\nИмя: " + contactName + ", Номер телефона: " + contactNumber);
        }

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

    public Map<String, String> getPhoneBook() {
        return this.phoneBook;
    }
}
