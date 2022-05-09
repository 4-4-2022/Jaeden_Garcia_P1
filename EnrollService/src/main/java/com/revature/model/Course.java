package com.revature.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Course {
	
	
	private String id;
	private String name;
	private String description;
	private String url;
	
	private Topic topic;

	public Course() {
		super();
	}
	
	public Course(String id, String name, String description, String url, String topicId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.url=url;
		this.topic= new Topic(topicId, "", "");
	}
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
