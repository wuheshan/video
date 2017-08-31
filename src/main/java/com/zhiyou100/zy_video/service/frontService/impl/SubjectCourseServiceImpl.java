package com.zhiyou100.zy_video.service.frontService.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.CourseMapper;
import com.zhiyou100.zy_video.mapper.SubjectMapper;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.service.frontService.SubjectCourseService;
@Service
public class SubjectCourseServiceImpl implements SubjectCourseService {

	@Autowired
	CourseMapper cm;
	@Autowired
	SubjectMapper sm;


	@Override
	public List<Course> findSubjectById(int subjectId) {
		
		List<Course> courses = cm.findSubjectCourseVideo(subjectId);
		
		for(Course course:courses){
			
			for(Video video:course.getVideo()){
				video.getVideoLengthstr();
				
				/*int miao = video.getVideoLength();
				long time = (miao*1000)-8*60*60;
				Date date = new Date(time);
				DateFormat df = new SimpleDateFormat("HH:mm:ss");
				String str = df.format(date);
				System.out.println(str);
				
				//str.replace("08", "00");
				video.setVideoLengthstr(str);*/
				
				/*int miao = video.getVideoLength();
				long time = (miao*1000); 
				Date date = new Date(time); 
				@SuppressWarnings("deprecation")
				String str = date.getHours() + ": " + date.getMinutes() + ": " + date.getSeconds();
				video.setVideoLengthstr(str);*/
				
				
				int miao = video.getVideoLength();
				long time = (miao*1000);
				
				long hour = time/(60*60*1000); 
				 long minute = (time - hour*60*60*1000)/(60*1000); 
				 long second = (time - hour*60*60*1000 - minute*60*1000)/1000; 
				 if(second >= 60 ) 
				 { 
				 second = second % 60; 
				 minute+=second/60; 
				 } 
				 if(minute >= 60) 
				 { 
				 minute = minute %60; 
				 hour += minute/60; 
				 } 
				 String sh = ""; 
				 String sm = ""; 
				 String ss = ""; 
				 if(hour <10) 
				 { 
				 sh = "0" + String.valueOf(hour); 
				 }else 
				 { 
				 sh = String.valueOf(hour); 
				 } 
				 if(minute <10) 
				 { 
				 sm = "0" + String.valueOf(minute); 
				 }else 
				 { 
				 sm = String.valueOf(minute); 
				 } 
				 if(second <10) 
				 { 
				 ss = "0" + String.valueOf(second); 
				 }else 
				 { 
				 ss = String.valueOf(second); 
				 } 
				 System.out.println(sh + sm + ss); 
				// String str = hour+ ":" + minute + ":" + second; 
				 String str = sh+":"+ sm+":"+ss;
				
				 video.setVideoLengthstr(str);
				
			}
			
		}
		
		
		
		return courses;
	}

	@Override
	public Subject findSubject(int subjectId) {
		
		return sm.selectByPrimaryKey(subjectId);
	}
}
