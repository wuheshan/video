package com.zhiyou100.zy_video.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.VideoMapper;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.model.VideoExample;
import com.zhiyou100.zy_video.service.VideoService;
import com.zhiyou100.zy_video.util.Page;
@Service
public class VideoServiceImpl implements VideoService {

	@Autowired
	VideoMapper vm;

	@Override
	public Page<Video> findAllVideo(String shiPinMing, String zhuJiangRen, String keCheng, Integer page) {
		
		Page<Video> pageInfo = new Page<>();
		
		pageInfo.setPage(page);
		pageInfo.setTotal(vm.findAllVideoAccount(shiPinMing,zhuJiangRen,keCheng));
		pageInfo.setSize(10);
		pageInfo.setRows(vm.findAllVideo(shiPinMing,zhuJiangRen,keCheng,(page-1)*10));
		
		//System.out.println(vm.findAllVideoAccount(shiPinMing,zhuJiangRen,keCheng));
		return pageInfo;
	}

	@Override
	public void addVideo(Video v) {
		
		vm.insertSelective(v);
		
	}

	@Override
	public void videoDelete(Integer id) {
		
		vm.deleteByPrimaryKey(id);
		
	}

	@Override
	public Video videoFindVideoById(Integer id) {
		
		
		
		return vm.selectVideoByPrimaryKey(id);
	}

	@Override
	public void updateVideo(Video v) {
		
		int i = vm.updateByPrimaryKeySelective(v);
		//System.out.println(i);
		
	}

	@Override
	public void someVideosDelete(Integer[] ids) {
		
		
		List<Integer> li = new ArrayList<>();
		
		for(Integer i : ids){
			li.add(i);
		}
		
		
		VideoExample ve = new VideoExample();
		ve.createCriteria().andIdIn(li);
		int i = vm.deleteByExample(ve);
		//System.out.println(i);
		
		
	}

	
}
