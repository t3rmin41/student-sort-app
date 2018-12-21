package com.student.sort.parser;

import com.student.sort.domain.Student;

public interface LineParser {

  Student parseLine(String line);
}
