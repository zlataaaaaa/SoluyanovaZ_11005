import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class School {
    private static final Scanner in = new Scanner(System.in);
    private static final JSONObject obj = new JSONObject(); // JSONObject студентов
    private static final JSONArray list = new JSONArray(); // JSONArray учителей
    public static final ArrayList<Student> ar = new ArrayList<>(); // Массив студентов

    public static void main(String[] args) {
        Archieve archieve = new Archieve();
        start(archieve);
    }
    public static void start(Archieve archieve) {
        System.out.println("Введите учителя");
        Teacher teacher = new Teacher(in.next()); // Имя учителя
        list.put(teacher.toString());
        System.out.println("Введите имя " + 1 + " студента");
        Student student1 = new Student(in.next()); // Первый студент
        ar.add(student1);
        System.out.println("Введите имя " + 2 + " студента");
        Student student2 = new Student(in.next());
        ar.add(student2);
        System.out.println("Введите имя " + 3 + " студента");
        Student student3 = new Student(in.next());
        ar.add(student3);
        System.out.println("Введите имя " + 4 + " студента");
        Student student4 = new Student(in.next());
        ar.add(student4);
        // Если хотим добавить еще студентов -- добавляем сверху и кладем новую пару в метод talk(teacher, studentnew1, studentnew2)
        try { // Пытаемся положить в JSONObject студентов (берем их пары, как вариант)
            talk(teacher, student1, student2);
            talk(teacher, student3, student4);
        } catch (JSONException e) {
            e.printStackTrace(); // Обрабатываем ошибку, если не получилось =(
        }
        System.out.println("Хотите изменить оценку ученика? \"Y\" или \"N\"");
        String b = in.next().toUpperCase();
        if (b.charAt(0) == 'Y') {
            System.out.println("Введите имя ученика");
            b = in.next();
            Student current = null; // Требуется инициализация, ставим нулл, потом используем assert для переобозначения
            for (Student student : ar) {
                if (b.equals(student.getName())) {
                    current = student; // Берем текущего студента (если таковой есть в нашей базе)
                }
            }
            if (obj.has(b)) { // Есть ли студент, который идет с консоли?
                System.out.println("Введите оценку для него");
                int k = in.nextInt();
                assert current != null; // Показываем JVM, что current уже не null!!
                obj.put(current.toString(), new JSONObject().put(String.valueOf(current.getCourse()), teacher.setMark(k))); // Кладем новую оценку студенту

                System.out.println("Успешно!");
            }
        }
        System.out.println("Архив успешно сохранен!");
        JSONObject forArchieve = archieve.getJsonObject(); // Создаем JSONObject для записи в json файл
        System.out.println("Вывод архива: ");
        for (int j = 0; j < list.length(); j++) { // Бежим по учителям
            forArchieve.put(list.get(j).toString(), obj); // Кладем в качестве key - учителя, value - JSONObject из студентов
            System.out.println("Учитель: " + list.get(j));
            archieve.setJsonObject(forArchieve);  // Кладем в archieve JSONObject для дальнейшего вывода в json файл
            for (int i = 0; i < obj.names().length(); i++) { // Бежим по студентам
                System.out.println("Имя: | " + obj.names().getString(i) + " | Курс и оценка: | " + obj.get(obj.names().getString(i))); // Выводим студентов и их оценки
            }

        }
        System.out.println("Дополнить архив? \"Y\" или \"N\"");
        String z = in.next().toUpperCase();
        try (FileWriter file = new FileWriter("archieve.json")) { // Записываем Архив в json файл
            file.write(archieve.getJsonObject().toString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (z.charAt(0) == 'Y') {
            start(archieve);
        } else {
            System.exit(0);
        }

    }

    private static void talk(Teacher teacher, Student student3, Student student4) { // Метод добавления пары новых студентов (можно и по одному)
        System.out.println("Введите курс и оценку " + student3);
        obj.put(student3.toString(), new JSONObject().put(student3.setCourse(in.next()), teacher.setMark(in.nextInt())));
        System.out.println("Введите курс и оценку " + student4);
        obj.put(student4.toString(), new JSONObject().put(student4.setCourse(in.next()), teacher.setMark(in.nextInt())));
    }

}

