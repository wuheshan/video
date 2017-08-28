package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.CourseMapper;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.CourseExample;
import com.zhiyou100.zy_video.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	CourseMapper cm;

	@Override
	public List<Course> findAllCourse() {
		CourseExample ce = new CourseExample();
		ce.createCriteria().andIdIsNotNull();
		List<Course> courses = cm.selectByExample(ce);
		return courses;
	}

	@Override
	public void addCourse(Course c) {
		int i = cm.insertSelective(c);
		//System.out.println(1);
		
	}

	@Override
	public void deleteCourse(Integer id) {
		
		cm.deleteByPrimaryKey(id);
		
	}

	@Override
	public Course findCourseById(Integer id) {
		
		
		return cm.selectByPrimaryKey(id);
	}

	@Override
	public void updateCourse(Course c) {
		
		int i = cm.updateByPrimaryKeySelective(c);
		System.out.println(i);
		
	}
}
