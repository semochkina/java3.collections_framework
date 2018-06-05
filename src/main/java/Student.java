//5. *Создайте класс Student, производный от Human, новое поле — название факультета
public class Student extends Human {
    // название факультета
    private String faculty;

    public Student(Human human, String faculty) {
        super(human);
        this.faculty = faculty;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
