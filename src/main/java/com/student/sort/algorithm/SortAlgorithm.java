package com.student.sort.algorithm;

import java.util.List;
import com.student.sort.domain.Student;
import com.student.sort.enums.SortDirection;

public interface SortAlgorithm {

  void sort(List<Student> students, SortDirection direction);
  
  void reverseSort(List<Student> students, SortDirection direction);
}
