package com.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entities.Student;
import com.springboot.service.StudentService;

@RestController
@RequestMapping(path = "/student")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping
	public List<Student> hello() {
		return studentService.getStudents();
	}
	@PostMapping
	public void addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
	}
	@DeleteMapping(path = "{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	}
	@PutMapping(path="{id}")
	public void updateStudent(@PathVariable("id")Long id,@RequestParam(required = false)String name) {
		studentService.updateStudent(id, name);
	}

}
