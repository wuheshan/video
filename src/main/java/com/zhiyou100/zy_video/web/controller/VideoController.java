package com.zhiyou100.zy_video.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.zy_video.mapper.VideoMapper;
import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.service.CourseService;
import com.zhiyou100.zy_video.service.SpeakerService;
import com.zhiyou100.zy_video.service.VideoService;
import com.zhiyou100.zy_video.util.Page;

@Controller
public class VideoController {

	@Autowired
	VideoService vm;
	
	@Autowired
	SpeakerService ss;
	
	@Autowired
	CourseService cs;
	
	@RequestMapping("/videoList.action")
	public String videoList(Model m,@RequestParam(defaultValue="")String shiPinMing,
			@RequestParam(defaultValue="")String zhuJiangRen,
			@RequestParam(defaultValue="")String keCheng,
			@RequestParam(defaultValue="1")Integer page){
		
		//System.out.println(22);
		m.addAttribute("shiPinMing", shiPinMing);
		m.addAttribute("zhuJiangRen", zhuJiangRen);
		m.addAttribute("keCheng", keCheng);
		
		Page<Video> row = vm.findAllVideo(shiPinMing,zhuJiangRen,keCheng,page);
		m.addAttribute("page", row);
		
		//System.out.println(row);
		
		
		
		List<Speaker> speakers = ss.findAllSpeaker();
		//System.out.println(speakers);
		m.addAttribute("speakers", speakers);
		
		List<Course> courses = cs.findAllCourse();
		//System.out.println(speakers);
		m.addAttribute("courses", courses);
		
		
		return "forward:/WEB-INF/view/video/videoList.jsp";
		
	}
	
	@RequestMapping("/videoEdit.action")
	public String videoEdit(Model m){
		
		List<Speaker> speakers = ss.findAllSpeaker();
		//System.out.println(speakers);
		m.addAttribute("speakers1", speakers);
		
		List<Course> courses = cs.findAllCourse();
		//System.out.println(courses);
		m.addAttribute("courses1", courses);
		
		
		
		//System.out.println(6666);
		return "forward:/WEB-INF/view/video/videoAdd.jsp";
		
	}
	
	
	@RequestMapping("/videoAdd.action")
	public String videoAdd(Model m, Video v){
		
		//System.out.println(v);
		
		vm.addVideo(v);
		
		//System.out.println(6666);
		return "forward:/videoList.action";
		
	}
	
	@RequestMapping("/videoDelete.action")
	public String videoDelete(Model m,Integer id){
		
		
		//System.out.println(id);
		vm.videoDelete(id);
		
		return "forward:/videoList.action";
		
	}
	
	@RequestMapping("/videoUpdate.action")
	public String videoUpdate(Model m,Integer id){
		
		List<Speaker> speakers = ss.findAllSpeaker();
		//System.out.println(speakers);
		m.addAttribute("speakers", speakers);
		
		List<Course> courses = cs.findAllCourse();
		//System.out.println(speakers);
		m.addAttribute("courses", courses);
		
		//System.out.println(id);
		Video video = vm.videoFindVideoById(id);
		m.addAttribute("video", video);
		
		return "forward:/WEB-INF/view/video/videoUpdate.jsp";
		
	}
	
	@RequestMapping("/videoUpdate2.action")
	public String videoUpdate2(Video v){
		
		
		//System.out.println(v);
		vm.updateVideo(v);
		
		
		return "forward:/videoList.action";
		
	}
	
	
	
	
	
	@RequestMapping("/videosDelete.action")
	public String someVideosDelete(Integer[] ids){
		
		
		//System.out.println(Arrays.toString(ids));
		vm.someVideosDelete(ids);
		
		return null;
		//return "forward:/videoList.action";
		
	}
	
	
	@RequestMapping("/accountList.action")
	public String account(Model m){
		
		//System.out.println(11111);
		List<Course> allCourse = cs.findAllCourse();
		
		List<String> li = new ArrayList();
		for(Course c:allCourse){
			
			
		li.add(c.getCourseName());
			
		}
		System.out.println(li.toString());
		m.addAttribute("data", li.toString());
		
		return "forward:/WEB-INF/view/account/videoAccount2.jsp";
		
	}
	
}
