package TelephoneDirectory;

import java.util.Comparator;

public class ContactPhoneComparator implements Comparator<Contact> {    // Используем интерфейс компаратор для универсальной сортировки телефон контактов
    @Override
    public int compare(Contact o1, Contact o2) {                        // Переопределяем метод compare где в параметры передаем 2 значение o1 и o2 типа Contact
        int n1 = Integer.parseInt(o1.getPhoneNumber());                 // Так как поле phoneNumber в классе Contact является типом String, тут мы преобразуем в тип int и присваиваем в новую переменную типа int
        int n2 = Integer.parseInt(o2.getPhoneNumber());                 // Так же и для второго объекта
        if(n1>=n2){                                                     // Выполняется проверка на равенства
            return 1;
        }
        return -1;
    }
}
