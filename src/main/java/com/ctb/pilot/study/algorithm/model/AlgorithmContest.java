package com.ctb.pilot.study.algorithm.model;

public enum AlgorithmContest {

	PROGRAMMING_CHALLENGE(1);

	private final int sequence;

	private AlgorithmContest(int sequence) {
		this.sequence = sequence;
	}

	public int getSequence() {
		return sequence;
	}

}
