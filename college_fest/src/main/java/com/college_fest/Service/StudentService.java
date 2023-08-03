package com.college_fest.Service;

import java.util.List;

import com.college_fest.model.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public Student findById(int theId);
	public void save(Student stu);
	public void deleteById(int deId);

}
