package TelephoneDirectory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneContacts phoneContacts = new PhoneContacts();

        System.out.println("Введите название группы контактов:");
        while (true) {
            String groupName = scanner.nextLine();                              // Создание имя группы через ввод с клавиатуры
            if (!groupName.equals("нет")) {                                     // Если ввод не равен 'нет', то
                phoneContacts.addGroup(groupName);                              // Выполняется метод addGroup который добавляет в HashMap как ключ groupName, а в значение добавляет новый ArrayList, так как при каждом добавлении группы, группа заносится в ключ, а новый списочный массив в значение мапы.
                System.out.println("Добавить еще одну группу (введите название либо нет)");
            } else {
                break;                                                          // Если ввод равен 'нет', то будет выход из цикла
            }
        }

        while (true) {
            System.out.println("\nДобавить контакт (введите имя и номер телефона или введите нет)");
            String name = scanner.nextLine();                                   // Создание контакта через ввод с клавиатуры
            if (name.equals("нет")) {                                           // Если имя введенная с клавиатуры равна 'нет', то
                break;                                                          // Будет выполнен выход из цикла
            }
            String[] arr = name.split(" ");                               // Так как мы передаем сперва имя и через пробел номер телефона, то разделяем эту строку на 2 ячейки массива после пробела
            String name1 = arr[0];                                              // Первый элемент(имя) заносится в массив строк
            String phoneNumber = arr[1];                                        // Второй элемент(телефон) заносится в массив строк
            Contact contact = new Contact(name1, phoneNumber);                  // В экземпляр класса передаем 2 аргумента (имя и телефон) который разделили на 2 части
            System.out.println("Укажите группы контакта через пробел");
            String groupName = scanner.nextLine();                              // Вводим название групп через ввод клавиатуры
            String[] strings = groupName.split(" ");                            // Название групп разделяем на массивы после каждого пробела
            phoneContacts.addContactToGroup(contact, strings);                  /* В классе PhoneContacts в метод addContactGroup заносятся
                                                                                 2 аргумента, в первый аргумент объект контакт в котором раннее передавали 2 значения name и phoneNumber, а второй аргумент название групп разделенный после каждого пробела  */
        }
        System.out.println("Группы: ");
        phoneContacts.printGroups();                                            // Выводим группы и контакты относящиеся к соответствующим группам

        System.out.println("\nОтсортированные группы по имени");
        phoneContacts.printSortedContacts();                                    // Вывод отсортированных имен

        System.out.println("\nОтсортированные группы по телефону");
        phoneContacts.printSortedContactsPhone();                               // Вывод отсортированных телефонных номеров
    }
}
