package com.student.sort.algorithm;

import java.util.Arrays;
import java.util.List;
import com.student.sort.domain.Student;
import com.student.sort.enums.SortDirection;

public class Bubble extends SortAlgorithm {

  @Override
  public List<Student> sortAscending(Student[] students) {
    Student temp = new Student();
    for (int i = 0; i < students.length; i++) {
      for (int j = 1; j < students.length-1; j++) {
        if (students[j - 1].getScore() > students[j].getScore()) {
          temp = students[j-1];
          students[j-1] = students[j];
          students[j] = temp;
        }
      }
    }
    return Arrays.asList(students);
  }

  @Override
  public List<Student> sortDescending(Student[] students) {
    Student temp = new Student();
    for (int i = 0; i < students.length; i++) {
      for (int j = 1; j < students.length-1; j++) {
        if (students[j - 1].getScore() < students[j].getScore()) {
          temp = students[j - 1];
          students[j - 1] = students[j];
          students[j] = temp;
        }
      }
    }
    return Arrays.asList(students);
  }

}
