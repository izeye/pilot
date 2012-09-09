package com.ctb.pilot.chat.model;

import java.util.Date;

public class Message {

	private int sequence;
	private Date createdTime;
	private int userSequence;
	private String nickname;
	private String message;

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public int getUserSequence() {
		return userSequence;
	}

	public void setUserSequence(int userSequence) {
		this.userSequence = userSequence;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [sequence=" + sequence + ", createdTime=" + createdTime
				+ ", userSequence=" + userSequence + ", nickname=" + nickname
				+ ", message=" + message + "]";
	}

}
