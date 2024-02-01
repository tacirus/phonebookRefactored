package com.example.phonebook.service;

import java.util.Map;
import java.util.Scanner;

public class ScannerInputProcessing {
  private final PhoneBook phoneBook = new PhoneBook();

  public boolean proccess(Scanner scanner) {
    System.out.println("\nЧтобы увидеть всех абонентов книги, введите: list \nЧтобы увидеть конкретного абонента, введите его имя или номер \nЧтобы добавить абонента, введите: new \nЕсли хотите хакончить работу с приложением, введите: q");
    String userInput = scanner.nextLine().trim();

    if (userInput.equalsIgnoreCase("q")) {
      return false;
    }

    if (userInput.equalsIgnoreCase("LIST")) {
      phoneBook.printList();
      return true;
    }

    if (phoneBook.isName(userInput)) {
      if (phoneBook.getPhoneBookCatalog().containsKey(userInput)) {
        System.out.println("Имя: " + userInput + "\nНомер: " + phoneBook.getPhoneBookCatalog().get(userInput));
      } else {
        System.out.println("В телефонной книге нет такого абонента. \n Хотите добавить его в книгу? y/n");

        addEntry(scanner);
        return true;
      }
    }

    if (phoneBook.isPhoneNumber(userInput)) {
        phoneBook.getPhoneBookCatalog().entrySet().stream()
                                            .filter(obj -> obj.getValue().equals(userInput))
                                            .findFirst()
                                            .ifPresentOrElse(this::printIfNumberFound,
                                                                  () -> {System.out.println("В телефонной книге нет абонента с таким номером. \n Хотите добавить его в книгу? y/n");
                                                                            addEntry(scanner);});
    } else {
      System.out.println("Вы ввели номер в некорректном формате.");
    }
    return true;
  }

  private void printIfNumberFound(Map.Entry<String, String> entry) {
    System.out.println("Имя абонента: " + entry.getKey() + "\nНомер абонента: " + entry.getValue());
  }

  public void addEntry(Scanner scanner) {
    String userInput = scanner.nextLine().trim();

    if (userInput.equals("n")) {
        return;
    }

    if (!userInput.equals("y")) {
      System.out.println("Вы ввели некорректный вариант ответа. Если хотите прервать добавление абонента, введите любую букву кроме: y. Если хотите добавить абонента, введит: y");
      if (!scanner.nextLine().trim().equals("y")) {
        return;
      }
    }

    System.out.println("Введите имя абонента");
    String name = getName(scanner);

    System.out.println("Введите номер абонента");
    String number = getNumber(scanner);

    phoneBook.addEntry(name, number, phoneBook.getPhoneBookCatalog());
    System.out.println("Абонент " + name + " " + number + " добавлен в телефонную книгу");
  }

  private String getName(Scanner scanner) {
    String userInput = scanner.nextLine().trim();

    if (!phoneBook.isName(userInput)) {
      System.out.println("Вы ввели некорректный вариант имени. Имя может состоять только из букв. Введите правильный вариант");
      userInput = getName(scanner);
    }
    return userInput;
  }

  private String getNumber(Scanner scanner) {
    String userInput = scanner.nextLine().trim();

    if (!phoneBook.isPhoneNumber(userInput)) {
      System.out.println("Вы ввели некорректный вариант номера. Номер может начинаться со знака + и состоять из от 10 до 16 цифр. Введите правильный вариант");
      userInput = getNumber(scanner);
    }
    return userInput;
  }
}
