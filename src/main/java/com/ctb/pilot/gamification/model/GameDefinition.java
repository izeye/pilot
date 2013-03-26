package com.ctb.pilot.gamification.model;

public enum GameDefinition {

	ARKANOID(1, "Arkanoid");

	private final int sequence;
	private final String name;

	private GameDefinition(int sequence, String name) {
		this.sequence = sequence;
		this.name = name;
	}

	public int getSequence() {
		return sequence;
	}

	public String getName() {
		return name;
	}

}
