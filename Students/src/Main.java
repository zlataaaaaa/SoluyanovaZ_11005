import entities.Lesson;
import entities.Student;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main extends UtilMethods {
    public static void main(String[] args) throws ParseException, IOException {
        final String studentsFilePath = "src/resources/students.txt";
        final String lessonsFilePath = "src/resources/lessons.txt";
        final String studentOutputFilePath = "src/output/students.txt";
        final String lessonOutputFilePath = "src/output/lessons.txt";


        final Student student1 = new Student(15, "Иван", "Васильев", "11-001");
        final Student student2 = new Student(5, "Антон", "Нестеров", "11-002");
        final Student student3 = new Student(17, "Елизавета", "Воронина", "11-003");
        ArrayList<Student> myNewUsers = new ArrayList<>();
        myNewUsers.add(student1);
        myNewUsers.add(student2);
        myNewUsers.add(student3);

        final String lesson1StartDate = "02.09.2021 08:30";
        final String lesson1EndDate = "02.09.2021 10:00";
        final Lesson lesson1 = new Lesson(10, "История", dateFormat.parse(lesson1StartDate), dateFormat.parse(lesson1EndDate), "1505");
        final String lesson2StartDate = "02.09.2021 08:30";
        final String lesson2EndDate = "02.09.2021 10:00";
        final Lesson lesson2 = new Lesson(11, "Математический анализ", dateFormat.parse(lesson2StartDate), dateFormat.parse(lesson2EndDate), "1510");
        final String lesson3StartDate = "03.09.2021 08:30";
        final String lesson3EndDate = "03.09.2021 10:00";
        final Lesson lesson3 = new Lesson(12, "Психология", dateFormat.parse(lesson3StartDate), dateFormat.parse(lesson3EndDate), "1511");
        ArrayList<Lesson> myNewLessons = new ArrayList<>();
        myNewLessons.add(lesson1);
        myNewLessons.add(lesson2);
        myNewLessons.add(lesson3);


        getDataFromFile(studentsFilePath, 0);
        for (Student stud : myNewUsers) {
            addNewStudentIfNotExist(stud);
        }

        getDataFromFile(lessonsFilePath, 1);
        for (Lesson sub : myNewLessons) {
            addNewLessonIfTimeIsGood(sub);
        }

        Student studentForRemoving = new Student(5, "Олеся", "Гаврилова", "11-810");
        deleteStudentFromStudentsList(studentForRemoving);

        String lessonForRemovingStartDate = "02.09.2021 08:30";
        String lessonForRemovingEndDate = "02.09.2021 10:00";
        Lesson lessonForRemoving = new Lesson(
                10,
                "История",
                dateFormat.parse(lessonForRemovingStartDate),
                dateFormat.parse(lessonForRemovingEndDate),
                "1505");
        deleteLessonFromLessonsList(lessonForRemoving);

        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("================================================== \n" +
                "Список команд: \n" +
                "\\student - добавить нового студента \n" +
                "\\lesson - добавить новую пару \n" +
                "\\delete_student - удалить студента \n" +
                "\\delete_lesson - удалить пару \n" +
                "\\students - отобразить список всех студентов \n" +
                "\\lessons - отобразить список всех пар \n" +
                "==================================================");
        System.out.println();
        System.out.println("Введите команду:");
        String command = scan.next();
        if (!getCommands().contains(command)) {
            System.out.println("Команда не найдена. Завершение программы...");
        } else {
            doMethodByCommand(command);
        }

        writeToFile(studentOutputFilePath, 0);
        writeToFile(lessonOutputFilePath, 1);
    }
}