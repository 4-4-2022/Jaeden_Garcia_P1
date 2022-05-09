package com.revature.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Enroll {
	
	@Id
	private String courseName;
	private String topicId;
	private Long studentId;
	
	public Enroll() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enroll(String topicId, Long studentId, String courseName) {
		super();
		this.topicId = topicId;
		this.studentId = studentId;
		this.courseName = courseName;
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public Long getStudentId() {
		return studentId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(courseName, studentId, topicId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enroll other = (Enroll) obj;
		return Objects.equals(courseName, other.courseName) && Objects.equals(studentId, other.studentId)
				&& Objects.equals(topicId, other.topicId);
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	@Override
	public String toString() {
		return "Enroll [topicId=" + topicId + ", studentId=" + studentId + ", courseName=" + courseName + "]";
	}
}
