package com.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.StudentRepository;
import com.springboot.entities.Student;


@Service
public class StudentService {
	@Autowired
	private  StudentRepository studentRepository;
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	public void addStudent(Student student) {
		Optional<Student>stud= studentRepository.findStudentByName(student.getName());
		if(stud.isPresent()) {
			throw new IllegalStateException("user already registered");
		}
		studentRepository.save(student);
	}
	public void deleteStudent(Long studentId) {
		boolean exists=studentRepository.existsById(studentId);
		if(!exists) {
			throw new IllegalStateException("Id does not exists");
		}
		studentRepository.deleteById(studentId);
	}
	@Transactional
	public void updateStudent(Long id,String name) {
		Student stud=studentRepository.findById(id).orElseThrow(()->new IllegalStateException("Id is incorrect"));
		
			if(name==null) {
				throw new IllegalStateException("Name is required");
			}
			else {
				stud.setName(name);
			}
	}
}
