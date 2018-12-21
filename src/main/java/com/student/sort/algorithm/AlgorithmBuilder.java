package com.student.sort.algorithm;

import java.util.List;
import com.student.sort.domain.Student;
import com.student.sort.enums.Algorithm;
import com.student.sort.enums.SortDirection;

public class AlgorithmBuilder {

  public SortAlgorithm buildAlgorithm(Algorithm algorithm) {
    switch(algorithm) {
      case BUBBLE: return new Bubble();
      case HEAP  : return new Heap();
      case MERGE : return new Merge();
      default    : return new SortAlgorithm() {
                                @Override
                                public void sort(List<Student> students, SortDirection direction) {}
                                @Override
                                public void reverseSort(List<Student> students, SortDirection direction) {}
                              };
    }
  }
  
}
