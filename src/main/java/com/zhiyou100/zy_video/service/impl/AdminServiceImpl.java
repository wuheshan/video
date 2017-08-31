package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;


import com.zhiyou100.zy_video.mapper.AdminMapper;
import com.zhiyou100.zy_video.model.Admin;
import com.zhiyou100.zy_video.model.AdminExample;
import com.zhiyou100.zy_video.model.AdminExample.Criteria;
import com.zhiyou100.zy_video.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminMapper am;

	@Override
	public Admin loginAdmin(String login_name, String login_pwd) {
		
		AdminExample ae = new AdminExample();
		String loginName = login_name;
		
		/*byte[] bytes = login_pwd.getBytes();
		String loginPwd = DigestUtils.md5DigestAsHex(bytes);*/
		String loginPwd = login_pwd;
		
		ae.createCriteria().andLoginNameEqualTo(loginName).andLoginPwdEqualTo(loginPwd);
		List<Admin> list = am.selectByExample(ae);
		Admin admin = list.get(0);
		
		return admin;
		
	}

	@Override
	public Admin loginAdmin(Admin admin) {
		AdminExample ae = new AdminExample();
		String loginName = admin.getLoginName();
		
		/*byte[] bytes = login_pwd.getBytes();
		String loginPwd = DigestUtils.md5DigestAsHex(bytes);*/
		String loginPwd = admin.getLoginPwd();
		
		ae.createCriteria().andLoginNameEqualTo(loginName).andLoginPwdEqualTo(loginPwd);
		List<Admin> list = am.selectByExample(ae);
		Admin adm = list.get(0);
		
		return adm;
	}
	
	
}
