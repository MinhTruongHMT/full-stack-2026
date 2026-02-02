package com.howtojava.demo.cruddemo.service.impl;

import com.howtojava.demo.cruddemo.dto.StudentCreateDTO;
import com.howtojava.demo.cruddemo.dto.StudentDTO;
import com.howtojava.demo.cruddemo.dto.StudentMapper;
import com.howtojava.demo.cruddemo.model.Student;
import com.howtojava.demo.cruddemo.repository.StudentRepository;
import com.howtojava.demo.cruddemo.service.StudentSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentSercice {

    private final StudentMapper studentMapper;
    private final StudentRepository stuRepository;

    public StudentServiceImpl(
            StudentMapper studentMapper,
            StudentRepository stuRepository
    ) {
        this.studentMapper = studentMapper;
        this.stuRepository = stuRepository;
    }

    @Override
    public Student findById(int id) {
        return stuRepository.findById(id).orElseThrow(() -> new RuntimeException("student not found"));
    }

    @Override
    public List<Student> getAllStudents() {
        return stuRepository.findAll();
    }

    @Override
    public StudentDTO addStudent(StudentCreateDTO createDTO) {
        return studentMapper.toDTO(stuRepository.save(studentMapper.toEntity(createDTO)));
    }

    @Override
    public StudentDTO updateStudent(StudentCreateDTO dto, int id) {

        Student student = this.getStudentById(id);
        student.setFirstname(dto.getFirstName());
        student.setLastname(dto.getLastName());
        student.setEmail(dto.getEmail());

        Student savedStudent = stuRepository.save(student);

        return studentMapper.toDTO(savedStudent);
    }

    @Override
    public void deleteStudent(int id) {
        Student student = this.getStudentById(id);
        stuRepository.delete(student);

    }

    public Student getStudentById(int id) {
        return stuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }

}
