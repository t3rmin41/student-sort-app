package com.student.sort.algorithm;

import java.util.Arrays;
import java.util.List;
import com.student.sort.domain.Student;

public class Merge extends SortAlgorithm {

  @Override
  public List<Student> sortAscending(Student[] students) {
    sortMergeAscending(students, students.length);
    return Arrays.asList(students);
  }

  private void sortMergeAscending(Student[] students, int length) {
    if (length < 2) {
      return;
    }
    int middle = length / 2;
    Student[] leftArray = new Student[middle];
    Student[] rightArray = new Student[length - middle];
    
    for (int i = 0; i < middle; i++) {
      leftArray[i] = students[i];
    }
    for (int i = middle; i < length; i++) {
      rightArray[i - middle] = students[i];
    }
    
    sortMergeAscending(leftArray, middle);
    sortMergeAscending(rightArray, length - middle);
    
    merge(students, leftArray, rightArray, middle, length - middle);
  }
  
  private void merge(Student[] students, Student[] leftArray, Student[] rightArray, int left, int right) {
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
      if (leftArray[i].getScore() <= rightArray[j].getScore()) {
        students[k++] = leftArray[i++];
      } else {
        students[k++] = rightArray[j++];
      }
    }
    while (i < left) {
        students[k++] = leftArray[i++];
    }
    while (j < right) {
        students[k++] = rightArray[j++];
    }
  }

  @Override
  public List<Student> sortDescending(Student[] students) {
    // TODO Auto-generated method stub
    return null;
  }

  
}
