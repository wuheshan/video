package com.zhiyou100.zy_video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.zy_video.mapper.SubjectMapper;
import com.zhiyou100.zy_video.model.Course;
import com.zhiyou100.zy_video.model.Subject;
import com.zhiyou100.zy_video.model.SubjectExample;
import com.zhiyou100.zy_video.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectMapper sm;

	@Override
	public List<Subject> findAllSubject() {
		
		SubjectExample se = new SubjectExample();
		se.createCriteria().andIdIsNotNull();
		
		//System.out.println(sm.selectByExample(se));
		
		return sm.selectByExample(se);
		
	}

	

	

	
}
