package com.zhiyou100.zy_video.service.frontService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.SpeakerMapper;
import com.zhiyou100.zy_video.mapper.VideoMapper;
import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.service.frontService.CourseVideoService;
@Service
public class CourseVideoServiceImpl implements CourseVideoService {

	@Autowired
	VideoMapper vm;
	@Autowired
	SpeakerMapper sm;

	

	@Override
	public Video findVideoSpeakerById(int videoId) {
		System.out.println(videoId);
		return vm.findVideoSpeakerById(videoId);
	}



	@Override
	public Speaker findAllVideoSpeaker(int Speakerid) {
		Speaker speaker = sm.findAllSpeakerVideo(Speakerid);
		return speaker;
	}



	
}
