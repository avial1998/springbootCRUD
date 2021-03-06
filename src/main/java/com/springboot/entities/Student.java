package com.springboot.entities;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Student {
	@Id
	@SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
	private Long id;
	private String name;
	private LocalDate dob;
	@Transient
	private int age;

	public Student(Long id, String name, LocalDate dob, int age) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public int getAge() {
		return Period.between(this.dob, LocalDate.now()).getYears();
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dob=" + dob + ", age=" + age + "]";
	}

	public void setAge() {
		this.age =Period.between(this.dob, LocalDate.now()).getYears();
	}
public Student() {}
	public Student(String name, LocalDate dob) {
		super();
		this.name = name;
		this.dob = dob;
		
	}

}
