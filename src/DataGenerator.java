import java.util.ArrayList;

public class DataGenerator {
    public static final String[] classes = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
    public static final String[] firstNames = {"Rafał", "Tomek", "Patryk", "Piotrek", "Marcin", "Ola"};
    public static final String[] lastName = {"Nowak", "Kowalski", "Gut", "Kocjan", "Zajega", "Misiek"};
    public static final String[] addresses = {"Urzędnicza 20", "Piastowska 4", "Studencka 2", "Ceglarska 30", "Piwna 6", "Lipowa 30"};
    ClassContainer container = new ClassContainer();

    public DataGenerator() {
        Integer n = getRandomInteger(10, 1);
        for (int i = 1; i <= n; i++) {
            Class generatedClass = generateClass(i);
            container.addClass(generatedClass.groupName, generatedClass);
        }
    }
    Class generateClass(Integer i) {
        Integer max = getRandomInteger(10, 1);
        Integer classLetter = getRandomInteger(10, 1);
        Class students = new Class(i.toString() + classes[classLetter], new ArrayList<>(), max);
        Integer numberOfStudents = max/2;
        for (int j = 0; j <= numberOfStudents; j++) {
            Student generatedStudent = generateStudent(j);
            students.addStudent(generatedStudent);
        }
        return students;
    }
    Student generateStudent(Integer j) {
        Integer firstname = getRandomInteger(5, 1);
        Integer lastname = getRandomInteger(5, 1);
        Integer address = getRandomInteger(5, 1);
        Student student = new Student(firstNames[firstname], lastName[lastname], StudentCondition.Odrabiajacy, getRandomInteger(2005, 1997), getRandomInteger(6, 1), addresses[address]);
        return student;
    }
    public static int getRandomInteger(int maximum, int minimum){
        return ((int) (Math.random()*(maximum - minimum))) + minimum;
    }
}