package com.rest.apis.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.apis.dao.CourseDao;
import com.rest.apis.entities.Course;
import com.rest.apis.service.CourseService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
//	List<Course> list;

	public CourseServiceImpl() {
//		list = new ArrayList<Course>();
//		list.add(new Course((long) 145, "Java Spring Core", "this course contains basics of java"));
//		list.add(new Course((long) 4343, "Spring Boot Course", "creating rest api using springboot"));
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public Course getCourse(Long courseId) {
		// TODO Auto-generated method stub
//		Course c = null;
//		for (Course course : list) {
//			if (course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		 Optional<Course> optionalCourse = courseDao.findById(courseId);
		return optionalCourse.get();
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
//		list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
//		list.forEach(e -> {
//			if (e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		Course existingCourse = courseDao.findById(course.getId()).get();
		System.out.println(existingCourse+"existingCourse");
		existingCourse.setTitle(course.getTitle());
		existingCourse.setDescription(course.getDescription());
		Course updateCourse = courseDao.save(existingCourse);
		return updateCourse;
	}

	@Override
	public void deleteCourse(Long courseId) {
		// TODO Auto-generated method stub
//		list = list.stream().filter(e -> e.getId() != parseLong).collect(Collectors.toList());
//		Course entity = courseDao.getReferenceById(parseLong);
		courseDao.deleteById(courseId);
	}

}
