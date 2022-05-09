package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Enroll;
import com.revature.service.EnrollService;

@RestController
public class EnrollController {
	@Autowired
	private EnrollService enrollService;
	
	@GetMapping("/enroll")
	public List<Enroll> getAllEnrolls() {
		return this.enrollService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/enroll")
	public void addEnroll(@RequestBody Enroll enroll) {
		this.enrollService.save(enroll);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/enroll")
	public void deleteCourse(@RequestBody Enroll enroll) {
		this.enrollService.delete(enroll);
	}
	

}
