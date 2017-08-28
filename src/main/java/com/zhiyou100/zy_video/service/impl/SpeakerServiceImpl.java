package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.SpeakerMapper;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.SpeakerExample;
import com.zhiyou100.zy_video.service.SpeakerService;
import com.zhiyou100.zy_video.util.Page;
@Service
public class SpeakerServiceImpl implements SpeakerService {

	@Autowired
	SpeakerMapper sm;

	@Override
	public List<Speaker> findAllSpeaker() {
		SpeakerExample se = new SpeakerExample();
		se.createCriteria().andIdIsNotNull();
		List<Speaker> speakers = sm.selectByExample(se);
		
		return speakers;
	}

	

	@Override
	public void addSpeaker(Speaker sp) {
		
		int i = sm.insertSelective(sp);
		//System.out.println(i);
		
	}

	@Override
	public void deleteSpeaker(Integer id) {
		
		int i = sm.deleteByPrimaryKey(id);
		//System.out.println(i);
		
	}

	@Override
	public Speaker findSpeakerById(Integer id) {
		
		Speaker speaker = sm.selectByPrimaryKey(id);
		return speaker;
	}

	@Override
	public void updateSpeaker(Speaker s) {
		
		int i = sm.updateByPrimaryKeySelective(s);
		//System.out.println(i);
		
	}



	@Override
	public Page<Speaker> findAllSpeakerByMZ(String mingCheng, String zhiWei, Integer page) {
		
		Page<Speaker> pageInfo = new Page<>();
		pageInfo.setPage(page);
		pageInfo.setTotal(sm.findSpeakerCount(mingCheng,zhiWei));
		pageInfo.setSize(5);
		pageInfo.setRows(sm.findAllSpeaker(mingCheng, zhiWei,(page-1)*10));
		return pageInfo;
	}

	
}
