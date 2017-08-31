package com.zhiyou100.zy_video.service.frontService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.zy_video.mapper.frontMapper.UserMapper;
import com.zhiyou100.zy_video.model.frontModel.User;
import com.zhiyou100.zy_video.model.frontModel.UserExample;
import com.zhiyou100.zy_video.service.frontService.UserService;
import com.zhiyou100.zy_video.util.MD5Utils;
import com.zhiyou100.zy_video.util.MailUtil;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper um;

	@Override
	public void regist(User user) {
		user.setPassword(MD5Utils.getMD5(user.getPassword()));
		
		um.insert(user);
		
	}

	@Override
	public User loginUser(User user) {
		UserExample ue = new UserExample();
		
		user.setPassword(MD5Utils.getMD5(user.getPassword()));
		 
		ue.createCriteria().andEmailEqualTo(user.getEmail()).andPasswordEqualTo(user.getPassword());
		
		List<User> userList = um.selectByExample(ue);
		 
		 
		 return userList.get(0);
	}

	@Override
	public User profileUser(int id) {
		
		User user = um.selectByPrimaryKey(id);
		user.setPassword(MD5Utils.getMD5(user.getPassword()));
		um.updateByPrimaryKeySelective(user);
		
		return user;
	}

	@Override
	public void updateHeadPic(int id, String fileName) {
		
		
		
	}

	@Override
	public void updateHeadPic(User u) {
		
		um.updateByPrimaryKeySelective(u);
		
	}

	@Override
	public void updateUserInfo(User user) {
		
		um.updateByPrimaryKeySelective(user);
		
	}

	@Override
	public User forgetpwd(User user) {
		
		
		UserExample ue = new UserExample();
		 
		ue.createCriteria().andEmailEqualTo(user.getEmail());
		
		List<User> userList = um.selectByExample(ue);
		 
		 
		User u = userList.get(0);
		
		
		
		return null;
	}

	@Override
	public User sendemail(User u) {
		
		UserExample ue = new UserExample();
		 
		ue.createCriteria().andEmailEqualTo(u.getEmail());
		
		List<User> userList = um.selectByExample(ue);
		 
		 
		User user = userList.get(0);
		
		
		//生成验证码
		int random = (int)(Math.random()*10000+1);
		String ran = Integer.toString(random);
		//System.out.println(ran);
		user.setCaptcha(ran);
		um.updateByPrimaryKeySelective(user);
		
		try {
			MailUtil.send("2451667454@qq.com", "验证", ran);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public User yanZhengCaptcha(User user) {
		
		user.getCaptcha();
		//System.out.println(user.getCaptcha()+"--"+user.getEmail());
		
		UserExample ue = new UserExample();
		 
		ue.createCriteria().andEmailEqualTo(user.getEmail()).andCaptchaEqualTo(user.getCaptcha());
		
		List<User> userList = um.selectByExample(ue);
		 
		 
		User u = userList.get(0);
		
		
		
		return u;
	}

	@Override
	public void resetpwd(User user) {
		
		user.setPassword(MD5Utils.getMD5(user.getPassword()));
		um.updateByPrimaryKeySelective(user);
		
	}

	
}
