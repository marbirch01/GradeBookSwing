import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ClassContainer {
    String className;
    HashMap<String, Class> classMap = new HashMap<>();
    public void addClass (String name, Class studentClass){
        if(classMap.containsKey(name)){
            System.out.println("Grupa znajduję się już w klasie.");
        }else {
            classMap.put(name, studentClass);
            System.out.println("Dodano grupę " + name + " do klasy");
        }
    }
    public void removeClass(String name){
        if (classMap.containsKey(name)) classMap.remove(name);
        System.out.println("Usunięto grupe z klasy.");
    }
    public List<String> findEmpty(){
        List<String> empty = new ArrayList<>();
        for (Map.Entry<String, Class> entry : classMap.entrySet()) {
            if (entry.getValue().studentList.isEmpty()){
                empty.add(entry.getKey());
            }
        }
        return empty;
    }
    public void summary(){
        for (Map.Entry<String, Class> entry : classMap.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            int max = entry.getValue().maxNumberOfStudents;
            int i = entry.getValue().studentList.size();
            int x = (100 * i)/max;
            System.out.println(x + "%");
        }
    }
    String changeClass(String searchedClassName, String className, Integer maxNumberOfPoints) {
        Class students = new Class(className, new ArrayList<>(), maxNumberOfPoints);
        final boolean[] isExist = {false};
        classMap.forEach((key, value) -> {
            if (className.equals(key)) isExist[0] = true;
        });
        if (isExist[0] && !className.equals(searchedClassName))
            return "You cant change name of class, class with this name already exist";
        else {
            classMap.forEach((key, value) -> {
                if (searchedClassName.equals(key)) {
                    students.studentList = value.studentList;
                }
            });
            removeClass(searchedClassName);
            addClass(students.groupName, students);
            return "";
        }
    }
    ArrayList searchStudent(String lastname) {
        ArrayList searchedStudent = new ArrayList<Student>();
        classMap.forEach((key, value) -> {
            try {
                searchedStudent.add(value.search(lastname));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return searchedStudent;
    }

}
