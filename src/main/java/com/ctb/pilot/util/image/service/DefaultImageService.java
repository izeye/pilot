package com.ctb.pilot.util.image.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.util.image.dao.ImageDao;
import com.ctb.pilot.util.image.model.Image;

@Service("imageService")
public class DefaultImageService implements ImageService {
	
	@Autowired
	private ImageDao imageDao;
	private Image image;

	@Override
	public byte[] getImage(String userSeq) {
		//db에석 userSeq에 해당하는 이미지를 가져온다.
		//이미지를 byte[]형태로 리턴한다.
		List<Image> list = imageDao.getImage(userSeq);
		Iterator<Image> iter = list.iterator();
		while(iter.hasNext()){
			image = iter.next();
		}
		
		return (image!=null)?image.getImage():null;
	}

}
