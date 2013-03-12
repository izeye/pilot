package com.ctb.pilot.gamification.model;

public class Reward {

	private int sequence;
	private String name;
	private RewardType type;
	private String description;
	private int point;

	public Reward() {
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public RewardType getType() {
		return type;
	}

	public void setAlias(String alias) {
		this.type = RewardType.valueOf(alias);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Reward [sequence=" + sequence + ", name=" + name + ", type="
				+ type + ", description=" + description + ", point=" + point
				+ "]";
	}

}
