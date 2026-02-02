package com.howtojava.demo.cruddemo.dto;

import com.howtojava.demo.cruddemo.model.Student;
import org.springframework.stereotype.Component;


@Component
public class StudentMapper {

    public Student toEntity(StudentDTO dto) {
        Student student = new Student();
        student.setEmail(dto.getEmail());
        student.setFirstname(dto.getFirstName());
        student.setLastname(dto.getLastName());
        return student;
    }
    public Student toEntity(StudentCreateDTO dto) {
        Student student = new Student();
        student.setEmail(dto.getEmail());
        student.setFirstname(dto.getFirstName());
        student.setLastname(dto.getLastName());
        return student;
    }

    public StudentDTO toDTO(Student entity) {
        StudentDTO student = new StudentDTO();
        student.setEmail(entity.getEmail());
        student.setFirstName(entity.getFirstname());
        student.setLastName(entity.getLastname());
        return student;
    }
}