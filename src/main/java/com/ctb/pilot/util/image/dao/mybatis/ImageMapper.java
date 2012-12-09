package com.ctb.pilot.util.image.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ctb.pilot.util.image.model.Image;

public interface ImageMapper {

	List<Image> getImage(@Param("userSeq") String userSeq);

}
