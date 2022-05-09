package com.revature.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.revature.model.Student;

@WebService
public interface StudentService {
	
	@WebMethod
	public List<Student> findAll();
	
	@WebMethod
	public String saveStudent(String name, int age);
	
	@WebMethod
	public void deleteStudent(Long id);
	
}
