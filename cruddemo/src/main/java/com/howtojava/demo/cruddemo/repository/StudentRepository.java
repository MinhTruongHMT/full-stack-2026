package com.howtojava.demo.cruddemo.repository;

import com.howtojava.demo.cruddemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
