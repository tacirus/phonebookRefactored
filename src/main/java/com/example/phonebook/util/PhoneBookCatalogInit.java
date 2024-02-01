package com.example.phonebook.util;

import java.util.Map;
import java.util.TreeMap;

public class PhoneBookCatalogInit {

  private static final Map<String, String> phoneBook = new TreeMap<>();

  static {
    phoneBook.put("Жека", "89312802629");
    phoneBook.put("Nikitos", "+7977776777");
  }

  public static Map<String, String> getPhoneBook() {
    return phoneBook;
  }

  private PhoneBookCatalogInit(){};
}
