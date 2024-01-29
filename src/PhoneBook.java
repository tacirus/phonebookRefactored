import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, String> phoneBook = new TreeMap<>();


    public static void main(String[] args) {
        phoneBook.put("Жека", "89312802629");
        phoneBook.put("Nikitos", "+7977776777");
        while (true) {

            System.out.println("\nВведите имя или номер телефона: ");
            String nameOrNumber = scanner.nextLine().trim();

            if (nameOrNumber.equals("LIST")) {
                printList(phoneBook);
            } else if (isName(nameOrNumber)) {
                String name = getName(nameOrNumber);
                if (phoneBook.containsKey(name)) {
                    System.out.println("Имя: " + name + "\nНомер: " + phoneBook.get(name));
                } else {
                    System.out.println("Ведите номер телефона: ");
                    String numberNew = scanner.nextLine().trim();
                    if (isNumber(numberNew)) {
                        numberNew = getNumber(numberNew);
                        phoneBook.put(name, numberNew);
                    }
                }
            } else if (isNumber(nameOrNumber)) {
                String number = getNumber(nameOrNumber);
                if (phoneBook.containsValue(number)) {
                    for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                        if (entry.getValue().equals(number)) {
                            System.out.println("Имя: " + entry.getKey() + "\nНомер: " + number);
                        }
                    }
                } else {
                    System.out.println("Ведите имя: ");
                    String name = scanner.nextLine().trim();
                    if (isName(name)) {
                        name = getName(name);
                        phoneBook.put(name, number);
                    }
                }
            }
        }

    }

    private static void printList(Map<String, String> print) {
        for (Map.Entry<String, String> entry : print.entrySet()) {
            String contactName = entry.getKey();
            String contactNumber = entry.getValue();
            System.out.println("\nИмя: " + contactName + ", Номер телефона: " + contactNumber);
        }

    }

    private static boolean isName(String nameOrNumber) {
        return nameOrNumber.matches("[a-zA-Zа-яА-Я]+");
    }

    private static boolean isNumber(String nameOrNumber) {
        return nameOrNumber.matches("\\+?\\d{10,16}");
    }

    private static String getName(String str) {
        Matcher match = Pattern.compile("[ a-zA-ZА-Яа-яёЁ]+").matcher(str);
        match.find();
        return match.group();
    }

    // Метод для извлечения номера телефона из ввода пользователя
    private static String getNumber(String str) {
        Matcher match = Pattern.compile("[+0-9]{10,16}").matcher(str);
        match.find();
        return match.group();
    }
}
