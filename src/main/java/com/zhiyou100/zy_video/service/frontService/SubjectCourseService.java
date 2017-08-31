package com.zhiyou100.zy_video.service.frontService;

import java.util.List;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Subject;

public interface SubjectCourseService {

	List<Course> findSubjectById(int subjectId);

	Subject findSubject(int subjectId);

}
