package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.revature.model.Course;
import com.revature.model.Topic;



@RestController
public class CourseController {
	
	@Autowired
	private RestTemplate restTemplate1;
	
	@RequestMapping(value="/topics", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Topic> getAllTopics() {
		ResponseEntity<List<Topic>> httpResponse = restTemplate1.exchange("http://localhost:8080/topics", 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Topic>>() {
				});
		return httpResponse.getBody();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/topics")
	public void addTopic(@RequestBody Topic topic) {
		restTemplate1.postForEntity("http://localhost:8080/topics", topic, String.class);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable String id) {
		restTemplate1.put("http://localhost:8080/topics/"+id, topic);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		restTemplate1.delete("http://localhost:8080/topics/"+id);
	}
	
	@RequestMapping(value="/topics/{id}/courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> getAllCourses(@PathVariable String id) {
		ResponseEntity<List<Course>> httpResponse = restTemplate1.exchange("http://localhost:8080/topics/"+id+"/courses", 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Course>>() {
				});
		return httpResponse.getBody();
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		restTemplate1.postForEntity("http://localhost:8080/topics/"+topicId+"/courses", course, String.class);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String id, @PathVariable String topicId) {
		restTemplate1.put("http://localhost:8080//topics/"+topicId+"/courses/"+id, course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteCourse( @PathVariable String id, @PathVariable String topicId) {
		restTemplate1.delete("http://localhost:8080//topics/"+topicId+"/courses/"+id);
	}
}
