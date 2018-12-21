package com.student.sort.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import com.student.sort.domain.Student;
import com.student.sort.parser.LineParser;

public class TextFileReader implements InputReader, LineParser {

  @Override
  public List<Student> readFromFile(File file) {
    List<Student> students = new LinkedList<Student>();
    BufferedReader bufferedReader = null;
    try {
      FileReader fileReader = new FileReader(file);
      bufferedReader = new BufferedReader(fileReader);
      
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        students.add(parseLine(line));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        bufferedReader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return students;
  }

  @Override
  public Student parseLine(String line) {
    Student student = new Student();
    String[] stringArr = line.split(",");
    student.setTitle(stringArr[0]);
    student.setScore(new Double(stringArr[1]));
    return student;
  }

}
