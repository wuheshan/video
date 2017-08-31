package com.zhiyou100.zy_video.service;

import com.zhiyou100.zy_video.model.Admin;

public interface AdminService {

	Admin loginAdmin(String login_name, String login_pwd);

	Admin loginAdmin(Admin admin);

}
