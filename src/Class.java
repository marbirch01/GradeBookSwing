import java.util.*;
import java.util.stream.Collectors;

public class Class {
    String groupName;
    List<Student> studentList;
    int maxNumberOfStudents;
    Class(String groupName, List<Student> studentList, int maxNumberOfStudents) {
        this.groupName = groupName;
        this.studentList = studentList;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public void addStudent(Student student) {
        if (studentList.size() < maxNumberOfStudents) {
            if (!studentList.contains(student)) {
                studentList.add(student);
                System.out.println("Dodano studenta");
            } else {
                System.out.println("Student jest już na liście");
            }
        } else {
            System.err.println("Error przekroczona ilosć studentów w Grupie");
        }
    }
    public void addPoints(Student student, double points){
        student.points += points;
    }
    public void getStudent(Student student) {
        studentList.removeIf(s -> s == student && s.points == 0);
//        for (Student s : studentList) {
//            if (s == student && s.points == 0) {
//                studentList.remove(s);
//            }
//        }
    }
    public void changeCondition(Student student, StudentCondition studentCondition){
        for (Student s : studentList){
            if (s == student){
                s.studentStatus = studentCondition;
            }
        }
    }
    public void removePoints(Student student, double points){
        student.points -= points;
    }
    Student search(String lastName) {
        Student searchedStudent = new Student(lastName);
        for(Student currentStudent : studentList) {
            if (searchedStudent.compare(currentStudent)) {
                System.out.println("Znaleniono w klasie %s studenta %s\n".formatted(groupName, currentStudent));
                return currentStudent;
            }
        }
        System.out.println("Nie znaleziono w klasie %s studenta o nazwisku %s\n".formatted(groupName,lastName));
        return searchedStudent;
    }

    public List<Student> searchPartial (String partial){
        List<Student> students = new ArrayList<>();
        for (Student s : studentList){
            if (s.lastName.contains(partial)) {
                students.add(s);
                System.out.println(s.lastName);
            }
        }
        return students;
    }

    public List<Student> searchPartialStreamApi (String partial){
        return studentList
                .stream()
                .filter(s -> s.lastName.contains(partial))
                .collect(Collectors.toList());
    }

    int countByCondition(StudentCondition searchedCondition) {
        int numberOfStudents = 0;
        for(Student currentStudent : studentList) {
            if (currentStudent.studentStatus == searchedCondition) numberOfStudents++;
        }
        return numberOfStudents;
    }
    String summary() {
        String message = "";
        for(Student currentStudent : studentList) {
            message += currentStudent.print();
        }
        return message;
    };
    void sortByLastName() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        });
    }

//    public void summary(){
//        for (Student s : studentList){
//            s.print();
//        }
//    }

    public  List<Student> sortByName(){
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        });
        return studentList;
    }
    public List<Student> sortByPoints(){
        studentList.sort(new Komparator());
        Collections.reverse(studentList);
        return studentList;
    }
    String max()
    {
        System.out.println(Collections.max(studentList, new KomparatorPunkty()));
        return Collections.max(studentList, new KomparatorPunkty()).toString();
    }
    private class KomparatorPunkty implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.points > o2.points) return 1;
            else return -1;
        }
    }
    public static class Komparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.points > o2.points) return 1;
            else return -1;
        }
    }
    String removeStudent(String lastname) {
        String message;
        boolean isExist = false;
        Student removedStudent = new Student(lastname);
        for (Student element : studentList) {
            if (element.compare(removedStudent)) {
                isExist = true;
                removedStudent = element;
            }
        }
        if(isExist) {
            message = "";
            this.studentList.remove(removedStudent);
        }
        else message = "Delete failed. Student with this lastname doesnt exist";
        return message;
    }
    String changeStudent(String searchedStudentLastname, String firstname, String lastname, StudentCondition condition, Integer birthYear, Double points, String address) {
        String msg="";
        Student student = new Student(firstname, lastname, condition, birthYear, points, address);
        if (searchedStudentLastname.equals(lastname)) removeStudent(searchedStudentLastname);
        addStudent(student);
        if (msg.isEmpty() && !searchedStudentLastname.equals(lastname)) removeStudent(searchedStudentLastname);
        return msg;
    }
}



