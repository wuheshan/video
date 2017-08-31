package com.zhiyou100.zy_video.web.controller.frontController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.model.frontModel.User;
import com.zhiyou100.zy_video.service.frontService.CourseVideoService;

@Controller
@RequestMapping("/front/video")
public class CourseVideoController {

	@Autowired
	CourseVideoService cvs;
	
	@RequestMapping("/index.action")
	public String index(int videoId,int subjectId,Model m){
		//System.out.println(1111);
		System.out.println(videoId);
		System.out.println(subjectId);
		
		Video video = cvs.findVideoSpeakerById(videoId);
		
		System.out.println(video);
		m.addAttribute("video", video);
		
		
		
		
		int Speakerid = video.getSpeakerId();
		Speaker speaker = cvs.findAllVideoSpeaker(Speakerid);
		System.out.println(speaker);
		m.addAttribute("videoList", speaker.getVideo());
		
		
		return "forward:/WEB-INF/view/front/video/content.jsp";
		
	}
	
	
}
