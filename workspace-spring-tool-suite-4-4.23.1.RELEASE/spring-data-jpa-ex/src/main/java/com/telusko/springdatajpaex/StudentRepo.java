package com.telusko.springdatajpaex;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.springdatajpaex.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {
	
		
		List<Student> findByName(String name);
		List<Student> findByMarks(int marks);
		
		//List<Student> findByEquals(int marks);
		
		@Query("select s from Student s where s.marks>?1")
		List<Student> findByGreaterThan(int marks);
}
