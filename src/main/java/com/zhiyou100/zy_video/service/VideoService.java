package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.util.Page;

public interface VideoService {

	Page<Video> findAllVideo(String shiPinMing, String zhuJiangRen, String keCheng, Integer page);

	void addVideo(Video v);

	void videoDelete(Integer id);

	Video videoFindVideoById(Integer id);

	void updateVideo(Video v);

	void someVideosDelete(Integer[] ids);

	

}
