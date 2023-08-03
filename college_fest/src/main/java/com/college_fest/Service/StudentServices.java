package com.college_fest.Service;

import java.util.List;

import com.college_fest.model.Student;

public interface StudentServices {

	List<Student> getAll();

	Student saveStudent(Student student);

	Student findbyID(int id);

	void deletebyID(int theid);

}