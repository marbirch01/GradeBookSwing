import java.util.Comparator;

public class Student implements Comparable {
    String name;
    String lastName;
    StudentCondition studentStatus;
    int birthDate;
    double points;
    String Address;

    public Student(String lastName) {
        this.lastName = lastName;
    }
    Student(String name, String laseName, StudentCondition studentStatus, int birthDate, double points, String address){
        this.name = name;
        this.lastName = laseName;
        this.studentStatus = studentStatus;
        this.birthDate = birthDate;
        this.points = points;
        this.Address = address;
    }

    String print(){
        return "Student: \n Imie: " + name + "\n Nazwisko: " + lastName + "\n Status: " + studentStatus + "\n Data urodzenia: " + birthDate + "\n Punkty: " + points;
    }
    @Override
    public boolean compare(Student compareStudent) {
        return compareStudent.lastName.equals(this.lastName);
    }
}