package com.college_fest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college_fest.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
