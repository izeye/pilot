package com.ctb.pilot.util.qrcode.model;

import java.util.Date;

public class QRCodeGenerationLog {

	private int sequence;
	private String text;
	private int width;
	private int height;
	private Date createdTime;
	private String ip;

	public QRCodeGenerationLog() {
	}

	public QRCodeGenerationLog(String text, int width, int height, String ip) {
		this.text = text;
		this.width = width;
		this.height = height;
		this.ip = ip;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "QRCodeGenerationLog [sequence=" + sequence + ", text=" + text
				+ ", width=" + width + ", height=" + height + ", createdTime="
				+ createdTime + ", ip=" + ip + "]";
	}

}
