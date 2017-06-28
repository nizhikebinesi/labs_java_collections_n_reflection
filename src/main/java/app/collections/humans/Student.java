package app.collections.humans;

import app.collections.humans.Human;

/**
 * Created by 1 on 10.05.2017.
 */
public class Student extends Human {
    String facultyName;

    public Student(String first_name, String second_name, String last_name, int age, String facultyName) {
        super(first_name, second_name, last_name, age);
        this.facultyName = facultyName;
    }

    public Student(String first_name, String last_name, int age, String facultyName) {
        super(first_name, last_name, age);
        this.facultyName = facultyName;
    }

    public Student(String first_name, String second_name, String last_name, int age) {
        super(first_name, second_name, last_name, age);
    }

    public Student(String first_name, String last_name, int age) {
        super(first_name, last_name, age);
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object object = super.clone();
        ((Student)object).setFacultyName(facultyName);
        return object;
        //return super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + (facultyName == null ? "" : "; facultyName = " + facultyName);
    }
}
