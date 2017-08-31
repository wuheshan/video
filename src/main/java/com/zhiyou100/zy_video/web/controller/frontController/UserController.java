package com.zhiyou100.zy_video.web.controller.frontController;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.model.frontModel.User;
import com.zhiyou100.zy_video.service.frontService.UserService;
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService us;
	
	
	@RequestMapping("/regist.action")
	@ResponseBody
	public User registUser(User user){
		
		//System.out.println(1111);
		//System.out.println(user.getEmail()+"--");
		us.regist(user);
		
		return user;
		
	}
	
	
	@RequestMapping("/login.action")
	@ResponseBody
	public User loginUser(User user,HttpServletRequest req){
		
		//System.out.println(1111);
		//System.out.println(user.getEmail()+"--");
		User u = us.loginUser(user);
		req.getSession().setAttribute("_front_user", u);
		
		return u;
		
	}
	
	@RequestMapping("/forgetpwd.action")
	public String forgetpwd(){
		
		/*System.out.println(user.getEmail());
		User u = us.forgetpwd(user);
		*/
		
		return "forward:/WEB-INF/view/front/user/forget_pwd.jsp";
		
	}
	
	
	@RequestMapping("/forgetpwd2.action")
	public String forgetpwd2(User user,Model m){
		
		
		User u = us.yanZhengCaptcha(user);
		//System.out.println(u);
		m.addAttribute("User", u);
		if(u != null){
			return "forward:/WEB-INF/view/front/user/reset_pwd.jsp";
		}else{
			
			return "forward:/WEB-INF/view/front/user/forget_pwd.jsp";
		}
		
		
		
	}
	
	
	@RequestMapping("/sendemail.action")
	@ResponseBody
	public User sendemail(User u){
		
		//System.out.println(u.getEmail());
		//System.out.println(1111);
		
		User user = us.sendemail(u);
		
		
		return user;
		
	}
	
	
	
	@RequestMapping("/resetpwd.action")
	public String resetpwd(User user){
		//System.out.println(user);
		
		us.resetpwd(user);
		
		
		return "forward:/WEB-INF/view/front/index.jsp";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/index.action")
	
	public String indexUser(int id,Model m){
		
		//System.out.println(1111);
		//System.out.println(user.getEmail()+"--");
		User u = us.profileUser(id);
		m.addAttribute("user", u);
		
		return "forward:/WEB-INF/view/front/user/index.jsp";
		
	}
	
	
	@RequestMapping("/profile.action")
	public String profileUser(int id,Model m){
		
		//System.out.println(1111);
		//System.out.println(user.getEmail()+"--");
		User u = us.profileUser(id);
		m.addAttribute("user", u);
		
		return "forward:/WEB-INF/view/front/user/profile.jsp";
		
	}
	
	@RequestMapping("/avatar.action")
	public String avatarUser(int id,Model m){
		User u = us.profileUser(id);
		m.addAttribute("user", u);
		
		return "forward:/WEB-INF/view/front/user/avatar.jsp";
		
	}
	
	@RequestMapping("/password.action")
	public String passwordUser(int id,Model m){
		User u = us.profileUser(id);
		
		
		
		m.addAttribute("user", u);
		
		return "forward:/WEB-INF/view/front/user/password.jsp";
		
	}
	
	
	@RequestMapping("/updateHeadPic.action")
	
	public String updateHeadPic(int id,Model m,MultipartFile image_file,HttpServletRequest req) throws IllegalStateException, IOException{
		
		String str = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
		String fileName = str+"."+ext;
		
		String path = "D:\\upload";
		
		image_file.transferTo(new File(path+"\\"+fileName));
		
		User u = us.profileUser(id);
		
		u.setHeadUrl(fileName);
		req.getSession().setAttribute("user", u);
		
		
		//us.updateHeadPic(id,fileName);
		us.updateHeadPic(u);
		
		
		return "forward:/user/avatar.action";
		
	}
	
	
	@RequestMapping("/updateUserInfo.action")
	public String updateUserInfo(User user,Model m){
		
		us.updateUserInfo(user);
		
		System.out.println(user);
		
	
		
		return "forward:/user/profile.action";
		
	}
	
	@RequestMapping("/updatePassword.action")
	public String updatePassword(int id,String newPassword,Model m){
		
		User u = us.profileUser(id);
		u.setPassword(newPassword);
		
		us.updateUserInfo(u);
		
		m.addAttribute("user", u);
		
		return "forward:/user/password.action";
		
	}
	
}
