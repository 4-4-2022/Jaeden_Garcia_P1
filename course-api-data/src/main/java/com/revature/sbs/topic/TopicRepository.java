package com.revature.sbs.topic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends JpaRepository<Topic, String> {
	
}
