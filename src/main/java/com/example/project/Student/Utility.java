package com.example.project.Student;
import java.util.ArrayList;
import java.util.Arrays;

public class Utility {

    public static ArrayList<Student> sortStudents(ArrayList<Student> studentsToSort) {
        return sort(studentsToSort, 0, studentsToSort.size() - 1);
    }
  
    private static ArrayList<Student> sort(ArrayList<Student> list, int low, int high) {
        if (low < high) {
            Student pivot = list.get(high);
            int i = low - 1;
            for (int j = low; j < high; j++) {
                int lastNameCompare = list.get(j).getLastName().compareTo(pivot.getLastName());
                int firstNameCompare = list.get(j).getFirstName().compareTo(pivot.getFirstName());
                int gpaCompare = Double.compare(pivot.getGpa(), list.get(j).getGpa()); // Higher GPA first
                
                if (lastNameCompare < 0 ||
                    (lastNameCompare == 0 && firstNameCompare < 0) ||
                    (lastNameCompare == 0 && firstNameCompare == 0 && gpaCompare < 0)) {
                    i++;
                    Student temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
            Student temp = list.get(i + 1);
            list.set(i + 1, list.get(high));
            list.set(high, temp);
            
            int partitionIndex = i + 1;
            sort(list, low, partitionIndex - 1);
            sort(list, partitionIndex + 1, high);
        }
        return list;
    }
}
