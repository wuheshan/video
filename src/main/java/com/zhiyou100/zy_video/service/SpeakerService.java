package com.zhiyou100.zy_video.service;

import java.util.List;

import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.util.Page;

public interface SpeakerService {

	List<Speaker> findAllSpeaker();

	Page<Speaker> findAllSpeakerByMZ(String mingCheng, String zhiWei, Integer page);

	void addSpeaker(Speaker sp);

	void deleteSpeaker(Integer id);

	Speaker findSpeakerById(Integer id);

	void updateSpeaker(Speaker s);

}
