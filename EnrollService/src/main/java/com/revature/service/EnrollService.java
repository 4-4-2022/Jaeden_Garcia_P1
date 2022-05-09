package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Enroll;
import com.revature.repository.EnrollRepository;

@Service
public class EnrollService {
	
	@Autowired
	private RestTemplate restTemplate2;
	
	@Autowired
	private EnrollRepository enrollRepository;
	
	public List<Enroll> findAll() {
		return this.enrollRepository.findAll();
	}
	
	public void save(Enroll enroll) {
		this.enrollRepository.save(enroll);
	}
	
	public void delete(Enroll enroll) {
		this.enrollRepository.delete(enroll);
	}
	
}
