package com.rest.apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.apis.entities.Course;
import com.rest.apis.service.CourseService;

@RestController
@CrossOrigin
public class MyController {
	
	@Autowired
	private CourseService courseService;

	@GetMapping("/home")
	public String home() {
		return "Welcome to courses application";
	}
	 
	// get the all courses
	@GetMapping("/courses")
	public List<Course> getCourses(){
		return courseService.getCourses();
	}
	
	// get the course by id
	@GetMapping("/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(Long.parseLong(courseId));
	}
	
	// add the course
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course){
		return courseService.addCourse(course);
	}
	
	// update the course
	@PutMapping("/courses/{courseId}") ///{courseId}
	public Course updateCourse(@PathVariable("courseId") Long courseId, @RequestBody Course course) { //,
		course.setId(courseId);
		return courseService.updateCourse(course);
//		return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
	}
	
	
	// delete the course by id
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
