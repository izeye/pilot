package com.ctb.pilot.study.algorithm.model;

import java.util.HashMap;
import java.util.Map;

public enum ProgrammingLanguage {

	JAVA(1, "Java");

	private static final Map<Integer, ProgrammingLanguage> sequenceAndValueMap = new HashMap<Integer, ProgrammingLanguage>();
	static {
		for (ProgrammingLanguage value : values()) {
			sequenceAndValueMap.put(value.getSequence(), value);
		}
	}

	private final int sequence;
	private final String displayName;

	private ProgrammingLanguage(int sequence, String displayName) {
		this.sequence = sequence;
		this.displayName = displayName;
	}

	public int getSequence() {
		return sequence;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static ProgrammingLanguage getBySequence(int sequence) {
		return sequenceAndValueMap.get(sequence);
	}

}
