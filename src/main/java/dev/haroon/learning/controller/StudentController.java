package dev.haroon.learning.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.haroon.learning.model.Student;

@RequestMapping("api/student")
@RestController
public class StudentController {
    
	
    
	ArrayList<Student> list = new ArrayList<Student>();
	
	@GetMapping("/get")
	public ResponseEntity<ArrayList<Student>> sayHello() {
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/get/{index}")
	public ResponseEntity<Student> getStudentByIndex(@PathVariable("index") Integer index) {
		return ResponseEntity.ok(list.get(index));
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Integer> addStudent(@RequestBody Student student) {
		list.add(student);
		return ResponseEntity.ok(student.getId());
	}
	
	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<Integer> deleteStudent(@PathVariable("studentId") Integer studentId) {
		list.remove(studentId);
		System.out.println(list.get(studentId));
		return ResponseEntity.ok(studentId);
	}
	
	

}
