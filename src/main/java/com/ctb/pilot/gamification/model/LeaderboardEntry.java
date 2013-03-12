package com.ctb.pilot.gamification.model;

public class LeaderboardEntry {

	private int rank;
	private String nickname;
	private int point;

	public LeaderboardEntry() {
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "LeaderboardEntry [rank=" + rank + ", nickname=" + nickname
				+ ", point=" + point + "]";
	}

}
