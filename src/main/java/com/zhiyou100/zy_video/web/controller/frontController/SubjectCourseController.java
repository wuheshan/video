package com.zhiyou100.zy_video.web.controller.frontController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy_video.mapper.SubjectMapper;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Subject;

import com.zhiyou100.zy_video.service.frontService.SubjectCourseService;



@Controller
@RequestMapping("/front/course")
public class SubjectCourseController {

	@Autowired
	SubjectCourseService scs;
	
	
	@RequestMapping("/index.action")
	public String resetpwd(int subjectId,Model m){
		
		//System.out.println(1111);
		List<Course> course = scs.findSubjectById(subjectId);
		
		//System.out.println(course);
		
		Subject subject = scs.findSubject(subjectId);
		m.addAttribute("subject", subject);
		m.addAttribute("subjectId", subjectId);
		m.addAttribute("courses", course);
		
		
		
		return "forward:/WEB-INF/view/front/course/index.jsp";
		
	}
}
