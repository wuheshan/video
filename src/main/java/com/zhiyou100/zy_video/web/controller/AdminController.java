package com.zhiyou100.zy_video.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.service.AdminService;

@Controller
public class AdminController {

	@Autowired
	AdminService as;
	
	
	
	
	@RequestMapping("/loginHouTai.action")
	public String loginHouTai(){
		
		
		return "forward:/WEB-INF/view/index.jsp";
		
		
		
	}
	
	
	@RequestMapping("/loginAdmin.action")
	public String loginAdmin(Admin admin,HttpServletRequest req,Model m){
		//System.out.println(login_name+"---"+login_pwd);
		
		/*Admin admin = as.loginAdmin(login_name,login_pwd);*/
		
		Admin adm = as.loginAdmin(admin);
		
		//System.out.println(admin);
		if(adm != null){
			req.getSession().setAttribute("admin", adm);
			//System.out.println(11);
			/*return "forward:/videoList.action";*/
			return "forward:/videoList.action";
		}
		else{
			m.addAttribute("errorMessage", "密码错误");
			return "forward:/WEB-INF/view/index.jsp";
		}
		
		
	}
}
