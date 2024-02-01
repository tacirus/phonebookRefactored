package com.example.phonebook;

import com.example.phonebook.service.PhoneBook;
import com.example.phonebook.service.ScannerInputProcessing;

import java.util.Scanner;

public class PhoneApplication {
  public static void main(String[] args) {
    private final ScannerInputProcessing scanProccessing = new ScannerInputProcessing();

    try(Scanner scanner = new Scanner(System.in)) {
      boolean isNotFinished = true;

      while (isNotFinished) {
          isNotFinished = scanProccessing.proccess(scanner);
        }
      }
    }
  }
