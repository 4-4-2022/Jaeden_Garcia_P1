package com.revature.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.model.Student;
import com.revature.repository.StudentRepository;

@WebService(endpointInterface = "com.revature.service.StudentServiceInter", name="student")
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	/////////////////////////
	
	
	/////////////////////////
	@WebMethod
	public Student findStudentById(Long id) {
		for(Student i: this.studentRepository.findAll()) {
			if(i.getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	@WebMethod
	public List<Student> findAllStudents() {
		return this.studentRepository.findAll();
	}
	
	@WebMethod
	public Student saveStudent(Student student) {
		return this.studentRepository.save(student);
	}
	
	@WebMethod
	public void deleteStudent(Long id) {
		this.studentRepository.deleteById(id);
	}
	
	@WebMethod
	public Student updateStudent(Student student) {
		if(studentRepository.existsById(student.getId())) {
			studentRepository.deleteById(student.getId());
			return studentRepository.save(student);
		}
		return null;
	}
}
