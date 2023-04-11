package com.example.demo.portal.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.portal.entities.Student;
import com.example.demo.portal.repositories.StudentRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/students")
public class StudentController<Subject> {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            Student updatedStudent = existingStudent.get();
            updatedStudent.setSubject(student.getSubject());
            updatedStudent.setSection(student.getSection());
            studentRepository.save(updatedStudent);
            return ResponseEntity.ok(updatedStudent);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
//    @GetMapping("/top2")
//    public Map<Subject, List<Student>> getTop2StudentsBySubject() {
//        Map<Subject, List<Student>> top2StudentsBySubject = new HashMap<>();
//
//        // Group students by subject
//        Map<String, List<Student>> studentsBySubject = studentRepository.findAll()
//                .stream()
//                .collect(Collectors.groupingBy(Student::getSubject));
//
//        // For each subject, find the top 2 students by rank
//        List<Subject> subjects = Arrays.asList("Physics", "Chemistry", "Mathematics");
//        for (Subject subject : subjects) {
//            List<Student> studentsForSubject = studentsBySubject.getOrDefault(subject, Collections.emptyList());
//
//            List<Student> top2StudentsForSubject = studentsForSubject.stream()
//                    .sorted(Comparator.comparingInt(Student::getRank))
//                    .limit(2)
//                    .collect(Collectors.toList());
//
//            top2StudentsBySubject.put(subject, top2StudentsForSubject);
//        }
//
//        return top2StudentsBySubject;
//    }
}
    
