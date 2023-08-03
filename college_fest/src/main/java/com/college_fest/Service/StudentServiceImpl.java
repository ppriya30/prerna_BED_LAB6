package com.college_fest.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college_fest.model.Student;
import com.college_fest.repository.StudentRepo;

@Service
public class StudentServiceImpl {
	
	@Autowired
	StudentRepo repo;
	
	public List<Student> getAll() {
		List<Student> students= repo.findAll();
		return students;
	}
	
	
	
	public Student saveStudent(Student student) {
		return repo.save(student);
	}
	
	
	
	public Student findbyID(int id) {
		return repo.findById(id).get();
	}
	
	
	public void deletebyID(int theid) {
		repo.deleteById(theid);
	}
	

}
