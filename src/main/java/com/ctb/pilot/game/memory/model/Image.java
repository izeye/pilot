package com.ctb.pilot.game.memory.model;

public class Image {

	private int sequence;
	private ImageType type;
	private String name;

	public Image() {
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public ImageType getType() {
		return type;
	}

	public void setType(int type) {
		this.type = ImageType.getByValue(type);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return "/resources/common/images/" + type.name().toLowerCase() + "/"
				+ name + ".JPG";
	}

	@Override
	public String toString() {
		return "Image [sequence=" + sequence + ", type=" + type + ", name="
				+ name + "]";
	}

}
