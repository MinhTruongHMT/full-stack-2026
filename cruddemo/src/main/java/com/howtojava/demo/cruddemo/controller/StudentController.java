package com.howtojava.demo.cruddemo.controller;

import com.howtojava.demo.cruddemo.dto.StudentCreateDTO;
import com.howtojava.demo.cruddemo.dto.StudentDTO;
import com.howtojava.demo.cruddemo.model.Student;
import com.howtojava.demo.cruddemo.service.StudentSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentSercice studentSercice;

    @GetMapping
    public List<Student> getAllStudents() {
        return  studentSercice.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") int studentId){
        Student student = studentSercice.findById(studentId);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public StudentDTO addStudent(@RequestBody StudentCreateDTO studentCreate) {
        return studentSercice.addStudent(studentCreate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable(value = "id") int studentId, @RequestBody StudentCreateDTO studentUpdate){
        return ResponseEntity.ok(studentSercice.updateStudent(studentUpdate, studentId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") int studentId) {
        studentSercice.deleteStudent(studentId);
        return ResponseEntity.ok().build();
    }
}
