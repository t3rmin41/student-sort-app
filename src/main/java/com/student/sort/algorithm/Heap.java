package com.student.sort.algorithm;

import java.util.Arrays;
import java.util.List;
import com.student.sort.domain.Student;
import com.student.sort.enums.SortDirection;

public class Heap extends SortAlgorithm {

  @Override
  public List<Student> sortAscending(Student[] students) {
    int length = students.length;
    for (int i = length / 2 - 1; i >= 0; i--) {
      heapifyAscending(students, length, i);
    }
    for (int i = length - 1; i >= 0; i--) {
      Student temp = students[0];
      students[0] = students[i];
      students[i] = temp;
      heapifyAscending(students, i, 0);
    }
    return Arrays.asList(students);
  }
 
  private void heapifyAscending(Student[] arr, int n, int i) {
    int largest = i; // Initialize largest as root 
    int l = 2*i + 1; // left = 2*i + 1 
    int r = 2*i + 2; // right = 2*i + 2 

    // If left child is larger than root 
    if (l < n && arr[l].getScore() > arr[largest].getScore()) {
      largest = l;
    }

    // If right child is larger than largest so far 
    if (r < n && arr[r].getScore() > arr[largest].getScore()) {
      largest = r; 
    }

    // If largest is not root 
    if (largest != i) {
      Student swap = arr[i]; 
      arr[i] = arr[largest]; 
      arr[largest] = swap; 
      // Recursively heapify the affected sub-tree 
      heapifyAscending(arr, n, largest); 
    } 
  }
  
  @Override
  public List<Student> sortDescending(Student[] students) {
    int length = students.length;
    for (int i = length / 2 - 1; i >= 0; i--) {
      heapifyDescending(students, length, i);
    }
    for (int i = length - 1; i >= 0; i--) {
      Student temp = students[0];
      students[0] = students[i];
      students[i] = temp;
      heapifyDescending(students, i, 0);
    }
    return Arrays.asList(students);
  }

  private void heapifyDescending(Student[] arr, int n, int i) {
    int smallest = i; // Initialize smallest as root 
    int l = 2*i + 1; // left = 2*i + 1 
    int r = 2*i + 2; // right = 2*i + 2 

    // If left child is smaller than root 
    if (l < n && arr[l].getScore() < arr[smallest].getScore()) {
      smallest = l;
    }

    // If right child is smaller than smallest so far 
    if (r < n && arr[r].getScore() < arr[smallest].getScore()) {
      smallest = r; 
    }

    // If smallest is not root 
    if (smallest != i) {
      Student swap = arr[i]; 
      arr[i] = arr[smallest]; 
      arr[smallest] = swap; 
      // Recursively heapify the affected sub-tree 
      heapifyDescending(arr, n, smallest); 
    } 
  }

}
