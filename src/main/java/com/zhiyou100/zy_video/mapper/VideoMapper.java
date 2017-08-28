package com.zhiyou100.zy_video.mapper;

import com.zhiyou100.zy_video.model.Video;
import com.zhiyou100.zy_video.model.VideoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideoMapper {
    int countByExample(VideoExample example);

    int deleteByExample(VideoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    List<Video> selectByExample(VideoExample example);

    Video selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByExample(@Param("record") Video record, @Param("example") VideoExample example);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

	int findAllVideoAccount(@Param("shiPinMing")String shiPinMing, @Param("zhuJiangRen")String zhuJiangRen, @Param("keCheng")String keCheng);

	List<Video> findAllVideo(@Param("shiPinMing")String shiPinMing, @Param("zhuJiangRen")String zhuJiangRen, @Param("keCheng")String keCheng, @Param("page")Integer page);

	Video selectVideoByPrimaryKey(Integer id);
}