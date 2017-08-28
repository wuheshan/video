package com.zhiyou100.zy_video.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService as;
	
	@RequestMapping("/loginAdmin.action")
	public String loginAdmin(String login_name,String login_pwd,HttpServletRequest req){
		//System.out.println(login_name+"---"+login_pwd);
		
		Admin admin = as.loginAdmin(login_name,login_pwd);
		//System.out.println(admin);
		if(admin != null){
			req.getSession().setAttribute("admin", admin);
			//System.out.println(11);
			return "forward:/videoList.action";
		}
		else{
			req.setAttribute("errorMessage", "密码错误");
			return "forward:/index.jsp";
		}
		
		
	}
}
