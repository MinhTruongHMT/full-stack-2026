package com.howtojava.demo.cruddemo.service;

import com.howtojava.demo.cruddemo.dto.StudentCreateDTO;
import com.howtojava.demo.cruddemo.dto.StudentDTO;
import com.howtojava.demo.cruddemo.model.Student;

import java.util.List;

public interface StudentSercice {
    Student findById(int id);
    List<Student> getAllStudents();
    StudentDTO addStudent(StudentCreateDTO createDTO);
    StudentDTO updateStudent(StudentCreateDTO updateDTO, int id);
    void deleteStudent(int id);
}
