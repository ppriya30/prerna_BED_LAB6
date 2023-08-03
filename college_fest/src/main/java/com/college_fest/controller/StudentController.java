package com.college_fest.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.college_fest.Service.StudentServiceImpl;
import com.college_fest.model.Student;

import net.bytebuddy.asm.Advice.Return;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentServiceImpl serviceImpl;
	
	@RequestMapping("/list")
	public String getlist(Model themodel) {
		List<Student > studentlist = serviceImpl.getAll();
		themodel.addAttribute("stu_list", studentlist);
		return "list_students";
	}
	
	@RequestMapping("/new")
	public String addStudent(Model themodel) {
		Student student1 = new Student();
		themodel.addAttribute("stu", student1);
		return "student_form";
	}
	
	@RequestMapping("/update")
	public String updateStudent(@RequestParam("s_id")int sid, Model themodel ) {
		Student student1= serviceImpl.findbyID(sid);
		themodel.addAttribute("stu", student1);
		return "student_form";
	}
	
	@PostMapping("/save")
	public String  saveStudent(@ModelAttribute("stu") Student student3) {
		serviceImpl.saveStudent(student3);
		
		return "redirect:/student/list";
	}
	
	@RequestMapping("/delete")
	public String deleteStudent(@RequestParam("del_id") int id) {
		
		serviceImpl.deletebyID(id);
		
		return "redirect:/student/list";
	}
	
	@RequestMapping(value= "/403")
	public ModelAndView accessDenied(Principal user) {
		
		ModelAndView model = new ModelAndView();
		
		if(user != null) {
			model.addObject("msg","Hi" + user.getName()+", You do not have permission to access this page!");
		}
		else {
			model.addObject("msg", " You do not have permission to access this page!" );
		}
		model.setViewName("403");
		
		return model;
	}
	
	

}
