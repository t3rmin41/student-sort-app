package com.student.sort.enums;

public enum SortDirection {

  ASCENDING(1, "Ascending"),
  DESCENDING(2, "Descending");
  
  private int id;
  private String title;
  
  private SortDirection(int id, String title) {
    this.id = id;
    this.title = title;
  }
  
  public int getId() {
    return this.id;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public static SortDirection getDirectionById(int id) {
    for (SortDirection direction : SortDirection.values()) {
      if (direction.id == id) {
        return direction;
      }
    }
    return null;
  }
}
