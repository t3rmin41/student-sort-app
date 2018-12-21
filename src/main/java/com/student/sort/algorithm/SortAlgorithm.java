package com.student.sort.algorithm;

import java.util.Arrays;
import java.util.List;
import com.student.sort.domain.Student;
import com.student.sort.enums.SortDirection;

public abstract class SortAlgorithm {

  public List<Student> sort(List<Student> students, SortDirection direction) {
    Student[] studentArray = new Student[students.size()];
    studentArray = students.toArray(studentArray);
    if (SortDirection.ASCENDING.equals(direction)) {
      return sortAscending(studentArray);
    } else if (SortDirection.DESCENDING.equals(direction)) {
      return sortDescending(studentArray);
    }
    return Arrays.asList(studentArray);
  }
  
  abstract public List<Student> sortAscending(Student[] students);
  
  abstract public List<Student> sortDescending(Student[] students);
}
