package com.student.sort.algorithm;

import java.util.Arrays;
import java.util.List;
import com.student.sort.domain.Student;
import com.student.sort.enums.SortDirection;

public class Merge extends SortAlgorithm {

  @Override
  public List<Student> sortAscending(Student[] students) {
    sortMerge(students, students.length, SortDirection.ASCENDING);
    return Arrays.asList(students);
  }

  private void sortMerge(Student[] students, int length, SortDirection direction) {
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
    
    sortMerge(leftArray, middle, direction);
    sortMerge(rightArray, length - middle, direction);

    if (SortDirection.ASCENDING.equals(direction)) {
      mergeAscending(students, leftArray, rightArray, middle, length - middle);
    } else if (SortDirection.DESCENDING.equals(direction)) {
      mergeDescending(students, leftArray, rightArray, middle, length - middle);
    }
    
  }
  
  private void mergeAscending(Student[] students, Student[] leftArray, Student[] rightArray, int left, int right) {
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
    sortMerge(students, students.length, SortDirection.DESCENDING);
    return Arrays.asList(students);
  }

  private void mergeDescending(Student[] students, Student[] leftArray, Student[] rightArray, int left, int right) {
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
      if (leftArray[i].getScore() >= rightArray[j].getScore()) {
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
  
}
