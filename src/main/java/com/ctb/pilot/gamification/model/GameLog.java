package com.ctb.pilot.gamification.model;

import java.util.Date;

public class GameLog {

	private int score;
	private Date playTime;

	public GameLog() {
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getPlayTime() {
		return playTime;
	}

	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}

	@Override
	public String toString() {
		return "GameLog [score=" + score + ", playTime=" + playTime + "]";
	}

}
