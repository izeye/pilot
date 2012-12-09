package com.ctb.pilot.util.image.dao;

import java.util.List;

import com.ctb.pilot.util.image.model.Image;

public interface ImageDao {

	List<Image> getImage(String userSeq);

}
