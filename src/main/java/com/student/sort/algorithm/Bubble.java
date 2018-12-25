package com.student.sort.algorithm;

import java.util.Arrays;
import java.util.List;
import com.student.sort.domain.Student;
import com.student.sort.enums.SortDirection;

public class Bubble extends SortAlgorithm {

  @Override
  public List<Student> sortAscending(Student[] students) {
    for (int i = 0; i < students.length; i++) {
      for (int j = 1; j < students.length-i; j++) {
        if (students[j-1].getScore() > students[j].getScore()) {
          Student temp = students[j-1];
          students[j-1] = students[j];
          students[j] = temp;
        }
      }
    }
    return Arrays.asList(students);
  }

  @Override
  public List<Student> sortDescending(Student[] students) {
    for (int i = 0; i < students.length; i++) {
      for (int j = 1; j < students.length-i; j++) {
        if (students[j-1].getScore() < students[j].getScore()) {
          Student temp = students[j-1];
          students[j-1] = students[j];
          students[j] = temp;
        }
      }
    }
    return Arrays.asList(students);
  }

}
