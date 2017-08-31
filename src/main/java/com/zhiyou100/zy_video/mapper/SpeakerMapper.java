package com.zhiyou100.zy_video.mapper;

import com.zhiyou100.zy_video.model.Speaker;
import com.zhiyou100.zy_video.model.SpeakerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpeakerMapper {
    int countByExample(SpeakerExample example);

    int deleteByExample(SpeakerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Speaker record);

    int insertSelective(Speaker record);

    List<Speaker> selectByExample(SpeakerExample example);

    Speaker selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByExample(@Param("record") Speaker record, @Param("example") SpeakerExample example);

    int updateByPrimaryKeySelective(Speaker record);

    int updateByPrimaryKey(Speaker record);

	List<Speaker> findAllSpeakerByMZ(@Param("mingCheng")String mingCheng, @Param("zhiWei")String zhiWei);

	int findSpeakerCount(@Param("mingCheng")String mingCheng, @Param("zhiWei")String zhiWei);

	List<Speaker> findAllSpeaker(@Param("mingCheng")String mingCheng,  @Param("zhiWei")String zhiWei, @Param("page")Integer page);

	

	Speaker findAllSpeakerVideo(int Speakerid);
}