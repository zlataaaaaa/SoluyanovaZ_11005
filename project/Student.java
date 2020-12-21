public class Student {
    private String name;
    private String course;

    public Student(String name) {
        this.name = name;
    }
    public String getCourse() {
        return course;
    } // Getter курса


    public String getName() {
        return name;
    } // Getter имени

    public void setName(String name) {
        this.name = name;
    } // Setter имени

    public String setCourse(String course) { // Setter курса
        this.course = course;
        return course;
    }
}

