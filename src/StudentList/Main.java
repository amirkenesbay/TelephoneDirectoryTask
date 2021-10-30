package StudentList;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> hashSet = new HashSet<>();
        StudentCheck studentCheck = new StudentCheck();
        System.out.println("Введите информацию о студенте: ФИО, номер группы, номер студенческого билета");
        while (true) {
            String nameInput = scanner.nextLine();
            if (!nameInput.equals("no")) {
                System.out.println("Введите информацию о студенте( для завершения работы программы введите \"end\")");
                String[] array = nameInput.split(", ");
                String name = array[0];
                String group = array[1];
                String studentId = array[2];
                Student student = new Student(name, group, studentId);
                studentCheck.hashSet.add(student);
            } else {
                break;
            }
        }
        studentCheck.printStudents();
    }
}
