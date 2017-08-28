package com.zhiyou100.zy_video.web.controller;

import java.util.List;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.service.SpeakerService;
import com.zhiyou100.zy_video.util.Page;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {

	@Autowired
	SpeakerService ss;
	
	@RequestMapping("/speakerList.action")
	public String speakList(Model m,
			@RequestParam(defaultValue="")String mingCheng,
			@RequestParam(defaultValue="")String zhiWei,
			@RequestParam(defaultValue="1")Integer page 
			){
		
		m.addAttribute("mingCheng", mingCheng);
		m.addAttribute("zhiWei", zhiWei);
		
		Page<Speaker> pageRow = ss.findAllSpeakerByMZ(mingCheng,zhiWei,page);
		
		//System.out.println(speakers);
		m.addAttribute("page", pageRow);
		
		return "forward:/WEB-INF/view/speaker/speakerList.jsp";
		//return null;
		
	
		
	}
	
	@RequestMapping("/speakerEdit.action")
	public String speakerEdit(Model m){
		
		//System.out.println(11111);
		return "forward:/WEB-INF/view/speaker/speakerAdd.jsp";
		
		
	}
	
	@RequestMapping("/speakerAdd.action")
	public String speakerAdd(Model m,Speaker sp){
		
		ss.addSpeaker(sp);
		//System.out.println(11111);
		return "forward:/speaker/speakerList.action";
		
		
	}
	
	
	@RequestMapping("/speakerDelete.action")
	public String speakerDelete(Model m,Integer id){
		
		ss.deleteSpeaker(id);
		//System.out.println(11111);
		return "forward:/speaker/speakerList.action";
		
		
	}
	
	
	@RequestMapping("/speakerUpdate.action")
	public String speakerUpdate1(Model m,Integer id){
		
		Speaker sp = ss.findSpeakerById(id);
		m.addAttribute("speaker", sp);
		return "forward:/WEB-INF/view/speaker/speakerUpdate.jsp";
		
		
	}
	
	@RequestMapping("/speakerUpdate2.action")
	public String speakerUpdate2(Speaker s){
		
		ss.updateSpeaker(s);
		return "forward:/speaker/speakerList.action";
		
		
	}
	
	
	
}
