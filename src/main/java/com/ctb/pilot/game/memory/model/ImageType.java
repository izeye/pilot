package com.ctb.pilot.game.memory.model;

import java.util.HashMap;
import java.util.Map;

public enum ImageType {

	OBJECTS(1), PARTS(2);

	private static final Map<Integer, ImageType> valueAndImageTypeMap = new HashMap<Integer, ImageType>();
	static {
		for (ImageType imageType : values()) {
			valueAndImageTypeMap.put(imageType.getValue(), imageType);
		}
	}

	private int value;

	private ImageType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static ImageType getByValue(int value) {
		return valueAndImageTypeMap.get(value);
	}

}
