package com.example.demo.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.portal.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	  @Query("SELECT s FROM Student s WHERE s.subject = ?1 ORDER BY s.rank DESC")
	  List<Student> findTop2BySubjectOrderByRankDesc(String subject);
	  
}