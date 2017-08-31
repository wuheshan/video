package com.zhiyou100.zy_video.service.frontService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.CourseMapper;
import com.zhiyou100.zy_video.mapper.SubjectMapper;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.service.frontService.SubjectCourseService;
@Service
public class SubjectCourseServiceImpl implements SubjectCourseService {

	@Autowired
	CourseMapper cm;
	@Autowired
	SubjectMapper sm;


	@Override
	public List<Course> findSubjectById(int subjectId) {
		
		List<Course> courses = cm.findSubjectCourseVideo(subjectId);
		
		
		return courses;
	}

	@Override
	public Subject findSubject(int subjectId) {
		
		return sm.selectByPrimaryKey(subjectId);
	}
}
