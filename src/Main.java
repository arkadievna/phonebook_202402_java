//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

class PhoneBook {
    private HashMap<String, List<String>> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        List<String> phoneList = contacts.getOrDefault(name, new ArrayList<>());
        phoneList.add(phone);
        contacts.put(name, phoneList);
    }

    public void printPhoneBook() {
        // создание списка записей, содержащих имя и количество телефонов
        List<Map.Entry<String, List<String>>> entries = new ArrayList<>(contacts.entrySet());

        // сортировка списка по убыванию количества телефонов
        Collections.sort(entries, (e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        // вывод результата
        for (Map.Entry<String, List<String>> entry : entries) {
            System.out.println(entry.getKey() + " - " + entry.getValue().size() + " телефон(а)");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем контакты
        phoneBook.addContact("Иванова", "89171111111");
        phoneBook.addContact("Петрова", "89172222222");
        phoneBook.addContact("Иванова", "89173333333");
        phoneBook.addContact("Сидорова", "89174444444");

        // Вывод телефонной книги
        phoneBook.printPhoneBook();
    }
}