package com.rest.apis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.apis.entities.Course;

public interface CourseDao extends JpaRepository<Course,Long>{

	
}
