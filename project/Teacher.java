public class Teacher {
    private String name; // Имя
    private int mark; // Оценка
    public Teacher(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    } // Getter имени

    public void setName(String name) {
        this.name = name;
    } // Setter имени


    public int getMark() {
        return mark;
    } // Getter оценки

    public String setMark(int mark) {
        return String.valueOf(mark);
    } // Сеттер оценки
}

