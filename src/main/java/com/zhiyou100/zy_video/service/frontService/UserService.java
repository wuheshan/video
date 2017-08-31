package com.zhiyou100.zy_video.service.frontService;

import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.zy_video.model.frontModel.User;

public interface UserService {

	void regist(User user);

	User loginUser(User user);

	User profileUser(int id);

	void updateHeadPic(int id, String fileName);

	void updateHeadPic(User u);

	void updateUserInfo(User user);

	User forgetpwd(User user);

	User sendemail(User u);

	User yanZhengCaptcha(User user);

	void resetpwd(User user);

	

}
