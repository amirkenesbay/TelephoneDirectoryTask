package StudentList;

import java.util.HashSet;

public class StudentCheck {
    HashSet<Student> hashSet = new HashSet<>();

    public void printStudents() {
        System.out.println("Список студентов");
        for (Student s : hashSet) {
            System.out.println("\t -" + s.getName() + ", " + s.getGroup() + ", " + s.getStudentId());
        }
    }
}
