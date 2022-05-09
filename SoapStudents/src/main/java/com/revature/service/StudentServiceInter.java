package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.model.Student;

@WebService
public interface StudentServiceInter {
	
	public List<Student> findAllStudents();
	public Student saveStudent(Student student);
	public void deleteStudent(Long id);
	public Student updateStudent(Student student);
}
