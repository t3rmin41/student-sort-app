package com.student.sort.enums;

public enum Algorithm {

  BUBBLE(1, "Bubble"),
  HEAP(2, "Heap"),
  MERGE(3, "Merge");
  
  private int id;
  private String title;
  
  private Algorithm(int id, String title) {
    this.id = id;
    this.title = title;
  }
  
  public int getId() {
    return this.id;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public static Algorithm getAlgorithmById(int id) {
    for (Algorithm algorithm : Algorithm.values()) {
      if (algorithm.id == id) {
        return algorithm;
      }
    }
    return null;
  }
  
}
