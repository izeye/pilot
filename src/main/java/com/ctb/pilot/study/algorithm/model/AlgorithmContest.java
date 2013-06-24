package com.ctb.pilot.study.algorithm.model;

import java.util.HashMap;
import java.util.Map;

public enum AlgorithmContest {

	PROGRAMMING_CHALLENGES(1, "Programming Challenges");

	private final int sequence;
	private final String displayName;

	private static final Map<Integer, AlgorithmContest> sequenceAndValueMap = new HashMap<Integer, AlgorithmContest>();
	static {
		for (AlgorithmContest value : values()) {
			sequenceAndValueMap.put(value.getSequence(), value);
		}
	}

	private AlgorithmContest(int sequence, String displayName) {
		this.sequence = sequence;
		this.displayName = displayName;
	}

	public int getSequence() {
		return sequence;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static AlgorithmContest getBySequence(int sequence) {
		return sequenceAndValueMap.get(sequence);
	}

}
