package com.ctb.pilot.util.image.model;

import java.util.Arrays;

public class Image {
	private byte[] image;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Image [image=" + Arrays.toString(image) + "]";
	}
	
	
}
