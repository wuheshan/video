package com.zhiyou100.zy_video.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.service.CourseService;
import com.zhiyou100.zy_video.service.SubjectService;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	CourseService cs;
	
	@Autowired
	SubjectService ss;
	
	
	@RequestMapping("/courseList.action")
	public String courseList(Model m){
		
		List<Course> courses = cs.findAllCourse();
		m.addAttribute("courses", courses);
		
		return "forward:/WEB-INF/view/course/courseList.jsp";
		
	}
	
	
	@RequestMapping("/courseEdit.action")
	public String courseEdit(Model m){
		
		List<Subject> subjects = ss.findAllSubject();
		m.addAttribute("subjects", subjects);
		
		return "forward:/WEB-INF/view/course/courseAdd.jsp";
		
	}
	
	@RequestMapping("/courseAdd.action")
	public String courseAdd(Course c){
		
		cs.addCourse(c);
		
		
		return "forward:/course/courseList.action";
		
	}
	
	@RequestMapping("/courseDelete.action")
	public String courseDelete(Integer id){
		
		cs.deleteCourse(id);
		
		
		return "forward:/course/courseList.action";
		
	}
	
	@RequestMapping("/courseUpdate.action")
	public String courseUpdate1(Integer id,Model m){
		
		Course c = cs.findCourseById(id);
		m.addAttribute("course", c);
		
		List<Subject> subjects = ss.findAllSubject();
		m.addAttribute("subjects", subjects);
		
		return "forward:/WEB-INF/view/course/courseUpdate.jsp";
		
	}
	
	@RequestMapping("/courseUpdate2.action")
	public String courseUpdate2(Course c){
		
		cs.updateCourse(c);
		
		return "forward:/course/courseList.action";
		
	}
	
	
}
