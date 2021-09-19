package TelephoneDirectory;

import java.util.*;

public class PhoneContacts {
    HashMap<String, List<Contact>> groups;                                          // Объявление HashMap с ключем типа String и значением типа списка контактов

    public PhoneContacts() {
        this.groups = new HashMap<>();                                              // Объявление конструктора в котором каждый раз создается новый HashMap
    }

    public void addGroup(String name) {                                             // Метод для создание группы, передаем параметр со значением типа String
        if (!groups.containsKey(name)) {                                            // Делаем проверку, если введенное имя не повторяется то
            groups.put(name, new ArrayList<>());                                    // Добавляем это в ключ и каждый раз при создании ключа, создается новый списочный массив в котором дальнейшем туда будем добавлять наши контакты
        }
    }

    public void addContactToGroup(Contact contact, String[] strings) {              // Метод добавление контакта в группу, передаем 2 параметра значениями объекта типа Contact и массив строк
        for (String group : strings) {                                              // Цикл в котором создана переменная group типа String, где будут итерироваться значение контактов(имя и телефон)
            if (groups.containsKey(group)) {                                        // Если в ключе HashMap группа которая ввели с клавиатуры, то
                groups.get(group).add(contact);                                     // Достаем эту же группу и добавляем значении контактов
            }
        }
    }

    public void printGroups() {                                                     // Вывод групп и их соответствующих контактов
        for (Map.Entry<String, List<Contact>> entry : groups.entrySet()) {          // Циклично проходим по всей мапе
            System.out.println("- " + entry.getKey());                              // Выводим ключи HashMap (название групп)
            for (Contact contact : entry.getValue()) {                              // И с присванием к значению ключа типа List<Contact> по циклу проходимся по всеми данными контактов
                System.out.println("\t Имя: " + contact.getName() + "\tНомер: " + contact.getPhoneNumber());  // Соответственно через геттеры выводим имена и фамилии контактов
            }
        }
    }

    public void printSortedContacts() {                                             // Вывод сортированных имен контактов
        List<Contact> allContacts = new ArrayList<>();                              // Создается список контактов
        for (Map.Entry<String, List<Contact>> entry : groups.entrySet()) {          // Циклично проходим по всей мапе
            for (Contact contact : entry.getValue()) {                              // Выводим ключи HashMap (название групп)
                if (!allContacts.contains(contact)) {                               // Делаем проверку если список контактов не будет содержать данные контактов то
                    allContacts.add(contact);                                       // Добавляем данные контактов в этот список
                }
            }
        }
        allContacts.sort(Comparator.naturalOrder());                                // Через метод sort сортируем список
        for (Contact contact : allContacts) {                                       // Цикл для вывода данных контактов
            System.out.println("\t Имя: " + contact.getName() + "\tНомер: " + contact.getPhoneNumber());
        }
    }

    public void printSortedContactsPhone() {                                        // Вывод сортированных телефон контактов
        List<Contact> allContacts = new ArrayList<>();                              // Создается список контактов
        for (Map.Entry<String, List<Contact>> entry : groups.entrySet()) {          // Циклично проходим по всей мапе
            for (Contact contact : entry.getValue()) {                              // Выводим ключи HashMap (название групп)
                if (!allContacts.contains(contact)) {                               // Делаем проверку если список контактов не будет содержать данные контактов то
                    allContacts.add(contact);                                       // Добавляем данные контактов в этот список
                }
            }
        }

        allContacts.sort(new ContactPhoneComparator());                             // Через метод sort сортируем список, а в этот метод передаем экземпляр класса ContactPhoneComparator где прописано логика сортировки
        for (Contact contact : allContacts) {                                       // Цикл для вывода данных контактов
            System.out.println("\t Имя: " + contact.getName() + "\tНомер: " + contact.getPhoneNumber());
        }
    }

}
