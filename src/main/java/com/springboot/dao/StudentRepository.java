package com.springboot.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entities.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	Optional<Student>findStudentByName(String name);
}
