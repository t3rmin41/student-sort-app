package com.student.sort.algorithm;

import java.util.List;
import com.student.sort.domain.Student;
import com.student.sort.enums.Algorithm;

public class AlgorithmBuilder {

  public SortAlgorithm buildAlgorithm(Algorithm algorithm) {
    switch(algorithm) {
      case BUBBLE: return new Bubble();
      case HEAP  : return new Heap();
      case MERGE : return new Merge();
      default    : return new SortAlgorithm() {

        @Override
        public List<Student> sortAscending(Student[] students) {
          // TODO Auto-generated method stub
          return null;
        }

        @Override
        public List<Student> sortDescending(Student[] students) {
          // TODO Auto-generated method stub
          return null;
        }
        
      };
    }
  }
  
}
