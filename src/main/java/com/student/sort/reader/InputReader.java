package com.student.sort.reader;

import java.io.File;
import java.util.List;
import com.student.sort.domain.Student;

public interface InputReader {

  List<Student> readFromFile(File file);
  
}
