package com.ctb.pilot.study.algorithm.model;

public enum ProgrammingLanguage {

	JAVA(1);

	private final int sequence;

	private ProgrammingLanguage(int sequence) {
		this.sequence = sequence;
	}

	public int getSequence() {
		return sequence;
	}

}
