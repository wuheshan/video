package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.Course;

public interface CourseService {

	List<Course> findAllCourse();

	void addCourse(Course c);

	void deleteCourse(Integer id);

	Course findCourseById(Integer id);

	void updateCourse(Course c);

	List<Course> findAccountCourse();

}
