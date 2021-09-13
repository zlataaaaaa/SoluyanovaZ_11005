import entities.Lesson;
import entities.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UtilMethods {
    final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm");
    private static final List<Student> studentsList = new ArrayList<>();
    private static final List<Lesson> lessonsList = new ArrayList<>();
    private final static long lessonTime = 1000 * 60 * 90;
    private static final List<String> commands = Stream.of("\\student", "\\lesson", "\\delete_student", "\\delete_lesson", "\\students", "\\lessons")
            .collect(Collectors.toList());

    public static List<String> getCommands() {
        return commands;
    }

    public static void doMethodByCommand(String command) throws ParseException {
        switch (command) {
            case "\\student":
                addNewStudentByCommand();
                break;
            case "\\lesson":
                addNewLessonByCommand();
                break;
            case "\\delete_student":
                deleteStudentByCommand();
                break;
            case "\\delete_lesson":
                deleteLessonByCommand();
                break;
            case "\\students":
                getAllStudents();
                break;
            case "\\lessons":
                getAllLessons();
                break;
        }
    }

    public static void addNewStudentIfNotExist(Student student) {
        if (checkStudentInList(student)) {
            studentsList.add(student);
        }
    }

    public static void addNewLessonIfTimeIsGood(Lesson Lesson) throws ParseException {
        if (checkLessonByTime(Lesson)) {
            lessonsList.add(Lesson);
        }
    }

    public static void deleteStudentFromStudentsList(Student student) {
        studentsList.removeIf(studentFromList -> studentFromList.equals(student) && studentFromList.getGroup().equals(student.getGroup()));
    }

    public static void deleteLessonFromLessonsList(Lesson Lesson) {
        lessonsList.removeIf(lessonFromList -> lessonFromList.equals(Lesson));
    }

    //type 0 - студент,type 1 - пары

    public static void getDataFromFile(String path, Integer type) throws IOException {
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                if (type == 0) {
                    final Student newStudent = getStudentFromLine(line);
                    addNewStudentIfNotExist(newStudent);
                    // если пара
                } else if (type == 1) {
                    final Lesson newLesson = getLessonFromLine(line);
                    addNewLessonIfTimeIsGood(newLesson);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkStudentInList(Student checkStudent) {
        if (!studentsList.isEmpty()) {
            for (Student student : studentsList) {
                if (student.getId() == checkStudent.getId()) {
                    System.out.println("[Студенты] Студент с id " + checkStudent.getId() + " уже присутствует в списке");
                    return false;
                }
                if (checkStudent.equals(student)) {
                    System.out.println("[Студенты] Студент " + checkStudent.getFullName() + " уже присутствует в группе " + student.getGroup());
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean checkLessonByTime(Lesson checkLesson) throws ParseException {
        if (!lessonsList.isEmpty()) {
            for (Lesson Lesson : lessonsList) {
                if (Lesson.getId() == checkLesson.getId()) {
                    System.out.println("[Пары] Пара с id " + checkLesson.getId() + " уже присутствует в списке");
                    return false;
                }
                if (Lesson.getAuditorium().equals(checkLesson.getAuditorium())) {
                    if (Math.abs(checkLesson.getStartDate().getTime() - Lesson.getStartDate().getTime()) < lessonTime) {
                        System.out.println("[Пары] «" + checkLesson.getName() +
                                "» не будет добавлена в список, т.к. время пары пересекается по времени с парой «" +
                                Lesson.getName() + "» (" + dateFormat.format(checkLesson.getStartDate()) + " и " +
                                dateFormat.format(Lesson.getStartDate()) + ") в аудитории " + Lesson.getAuditorium());
                        return false;
                    }
                }
            }
        }

        return true;
    }


    public static void writeToFile(String filePath, Integer type) {
        File file = new File(filePath);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            if (type == 0) {
                final int studentsListSize = studentsList.size();

                for (int i = 0; i < studentsListSize; i++) {
                    fr.write(String.valueOf(getLineWithStudentInfo(studentsList.get(i))));
                    if (i < studentsListSize - 1) {
                        fr.write("\n");
                    }
                }
            } else if (type == 1) {
                final int lessonsListSize = lessonsList.size();

                for (int i = 0; i < lessonsListSize; i++) {
                    fr.write(String.valueOf(getLineWithLessonInfo(lessonsList.get(i))));
                    if (i < lessonsListSize - 1) {
                        fr.write("\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static Student getStudentFromLine(String line) {
        final String[] studentInfo = line.split(",");
        final String[] studentNames = studentInfo[1].trim().replaceAll("[\\t\\n\\r\\s]", " ").split(" ");
        final String studentGroup = studentInfo[2].trim();
        final int studentNumber = Integer.parseInt(studentInfo[0].trim());

        return new Student(studentNumber, studentNames[1], studentNames[0], studentGroup);
    }

    private static Lesson getLessonFromLine(String line) throws ParseException {
        final String[] lessonInfo = line.split(",");
        final int lessonId = Integer.parseInt(lessonInfo[0].trim());
        final String lessonName = lessonInfo[1].trim();
        final Date lessonStartDate = dateFormat.parse(lessonInfo[2].trim());
        final Date lessonEndDate = dateFormat.parse(lessonInfo[3].trim());
        final String lessonAuditorium = lessonInfo[4].trim();

        return new Lesson(lessonId, lessonName, lessonStartDate, lessonEndDate, lessonAuditorium);
    }

    private static StringBuilder getLineWithStudentInfo(Student student) {
        StringBuilder studentInfoLine = new StringBuilder();

        studentInfoLine.append(student.getId());
        studentInfoLine.append(", ");
        studentInfoLine.append(student.getSecondName());
        studentInfoLine.append(" ");
        studentInfoLine.append(student.getFirstName());
        studentInfoLine.append(", ");
        studentInfoLine.append(student.getGroup());

        return studentInfoLine;
    }

    private static StringBuilder getLineWithLessonInfo(Lesson Lesson) {
        StringBuilder lessonInfoLine = new StringBuilder();

        lessonInfoLine.append(Lesson.getId());
        lessonInfoLine.append(", ");
        lessonInfoLine.append(Lesson.getName());
        lessonInfoLine.append(", ");
        lessonInfoLine.append(dateFormat.format(Lesson.getStartDate()));
        lessonInfoLine.append(", ");
        lessonInfoLine.append(dateFormat.format(Lesson.getEndDate()));
        lessonInfoLine.append(", ");
        lessonInfoLine.append(Lesson.getAuditorium());

        return lessonInfoLine;
    }

    private static void addNewStudentByCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Имя: ");
        String name = scanner.next().trim();
        System.out.print("Фамилия: ");
        String secondName = scanner.next().trim();
        System.out.print("Группа: ");
        String group = scanner.next().trim();

        Student newStudent = new Student(getNewStudentId(), name, secondName, group);
        addNewStudentIfNotExist(newStudent);
    }

    private static void addNewLessonByCommand() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Название: ");
        String name = scanner.next().trim();
        System.out.print("Дата начала (в формате ДД.ММ.ГГГГ): ");
        String startDate = scanner.next().trim();
        System.out.print("Время начала (в формате ЧЧ:ММ): ");
        String fullStartDate = startDate + " " + scanner.next().trim();
        System.out.print("Дата окончания (в формате ДД.ММ.ГГГГ): ");
        String endDate = scanner.next().trim();
        System.out.print("Время окончания (в формате ЧЧ:ММ): ");
        String fullEndDate = endDate + " " + scanner.next().trim();
        System.out.print("Аудитория: ");
        String auditorium = scanner.next().trim();
        Date lessonStartDate = getDateIfItIsCorrect(fullStartDate, "Дата/время начала пары введены некорректно");
        Date lessonEndDate = getDateIfItIsCorrect(fullEndDate, "Дата/время окончания пары введены некорректно");

        if (lessonStartDate != null && lessonEndDate != null) {
            if (lessonStartDate.getTime() <= lessonEndDate.getTime()) {
                System.out.println("Дата начала должна быть меньше даты окончания");
                System.exit(0);
            }
        }
        Lesson newLesson = new Lesson(getNewLessonId(), name, lessonStartDate, lessonEndDate, auditorium);
        addNewLessonIfTimeIsGood(newLesson);
    }

    private static void deleteStudentByCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Удалить по имени (1), по id (2) или по номеру в списке (3)?");
        String subCommand = scanner.next().trim();

        switch (subCommand) {
            case "1":
                System.out.print("Введите имя: ");
                String name = scanner.next().trim();
                System.out.print("Введите фамилию: ");
                String secondName = scanner.next().trim();

                studentsList.removeIf(student -> student.getFirstName().equals(name) && student.getSecondName().equals(secondName));
                break;
            case "2":
                System.out.print("Введите id: ");
                int studentId = Integer.parseInt(scanner.next().trim());
                Student student = null;

                for (Student stud : studentsList) {
                    if (stud.getId() == studentId) {
                        student = stud;
                        break;
                    }
                }
                if (student != null) {
                    deleteStudentFromStudentsList(student);
                } else {
                    System.out.println("Студент с id=" + studentId + " не найден");
                    System.exit(0);
                }
                break;
            case "3":
                System.out.print("Введите номер: ");
                int itemNum = Integer.parseInt(scanner.next().trim());

                if (itemNum < 1 || itemNum > studentsList.size() - 1) {
                    System.out.println("Некорректный номер");
                    System.exit(0);
                } else {
                    studentsList.remove(studentsList.get(itemNum));
                }
                break;
            default:
                System.out.println("Некорректная команда");
                System.exit(0);
        }
    }

    private static void deleteLessonByCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Удалить по id (1), по номеру в списке (2), или по другим полям (3)?");
        String subCommand = scanner.next().trim();

        switch (subCommand) {
            case "1":
                System.out.print("Введите id: ");
                int lessonId = Integer.parseInt(scanner.next().trim());
                Lesson lesson = null;

                for (Lesson les : lessonsList) {
                    if (les.getId() == lessonId) {
                        lesson = les;
                        break;
                    }
                }
                if (lesson != null) {
                    deleteLessonFromLessonsList(lesson);
                } else {
                    System.out.println("Пара с id=" + lessonId + " не найдена");
                    System.exit(0);
                }
                break;
            case "2":
                System.out.print("Введите номер: ");
                int itemNum = Integer.parseInt(scanner.next().trim());

                if (itemNum < 1 || itemNum > lessonsList.size() - 1) {
                    System.out.println("Некорректный номер");
                    System.exit(0);
                } else {
                    lessonsList.remove(lessonsList.get(itemNum));
                }
                break;
            case "3":
                System.out.print("Введите название: ");
                String name = scanner.next().trim();
                System.out.print("Введите номер аудитории: ");
                String auditorium = scanner.next().trim();
                System.out.print("Введите дату начала (ДД.ММ.ГГГГ): ");
                String startDate = scanner.next().trim();
                System.out.print("Введите время начала (ЧЧ:ММ): ");
                String fullDate = startDate + " " + scanner.next().trim();

                final Date lessonDate = getDateIfItIsCorrect(fullDate, "Дата/время начала пары введены некорректно");
                lessonsList.removeIf(lessonItem -> lessonItem.getName().equals(name)
                        && lessonItem.getStartDate().equals(lessonDate)
                        && lessonItem.getAuditorium().equals(auditorium));
                break;
            default:
                System.out.println("Некорректная команда");
                System.exit(0);
        }
    }

    private static void getAllStudents() {
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println("(" + i + ") " + getLineWithStudentInfo(studentsList.get(i)));
        }
    }


    private static void getAllLessons() {
        for (int i = 0; i < lessonsList.size(); i++) {
            System.out.println("(" + i + ") " + getLineWithLessonInfo(lessonsList.get(i)));
        }
    }

    private static int getNewStudentId() {
        int maxId = 0;
        if (studentsList.isEmpty() || studentsList.size() == 1 && studentsList.get(0).getId() == 0) {
            return 1;
        }
        for (Student student : studentsList) {
            if (student.getId() > maxId) {
                maxId = student.getId();
            }
        }

        return ++maxId;
    }

    private static int getNewLessonId() {
        int maxId = 0;
        if (lessonsList.isEmpty() || lessonsList.size() == 1 && lessonsList.get(0).getId() == 0) {
            return 1;
        }
        for (Lesson lesson : lessonsList) {
            if (lesson.getId() > maxId) {
                maxId = lesson.getId();
            }
        }

        return ++maxId;
    }

    private static Date getDateIfItIsCorrect(String stringDate, String errorMessage) {
        Date correctDate;

        try {
            correctDate = dateFormat.parse(stringDate);
        } catch (ParseException e) {
            System.out.println(errorMessage);
            System.exit(0);
            return null;
        }

        return correctDate;
    }
}