package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Student;
import com.revature.soap.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private RestTemplate restTemplate1;
	
	private StudentServiceImpl ssi;
	
	@PostMapping()
	public void saveStudent(@RequestBody Student student) {
		this.ssi.saveStudent(student.getName(), student.getAge());
	}
}
