package com.zhiyou100.zy_video.service.frontService;

import java.util.List;

import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.Video;

public interface CourseVideoService {

	Video findVideoSpeakerById(int videoId);

	Speaker findAllVideoSpeaker(int Speakerid);

}
