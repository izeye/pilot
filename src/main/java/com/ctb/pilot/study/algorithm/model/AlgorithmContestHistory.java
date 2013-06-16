package com.ctb.pilot.study.algorithm.model;

import java.util.Date;

public class AlgorithmContestHistory {

	private Integer sequence;
	private int userSequence;
	private int contestSequence;
	private String problemId;
	private String submitId;
	private Date submitTime;
	private float runtime;
	private int languageSequence;
	private String sourceUrl;
	private Date createdTime;
	private Date modifiedTime;

	public AlgorithmContestHistory(Integer sequence, int userSequence,
			int contestSequence, String problemId, String submitId,
			Date submitTime, float runtime, int languageSequence,
			String sourceUrl, Date createdTime, Date modifiedTime) {
		this.sequence = sequence;
		this.userSequence = userSequence;
		this.contestSequence = contestSequence;
		this.problemId = problemId;
		this.submitId = submitId;
		this.submitTime = submitTime;
		this.runtime = runtime;
		this.languageSequence = languageSequence;
		this.sourceUrl = sourceUrl;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
	}

	public AlgorithmContestHistory(int userSequence, int contestSequence,
			String problemId, String submitId, Date submitTime, float runtime,
			int languageSequence, String sourceUrl) {
		this(null, userSequence, contestSequence, problemId, submitId,
				submitTime, runtime, languageSequence, sourceUrl, null, null);
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public int getUserSequence() {
		return userSequence;
	}

	public void setUserSequence(int userSequence) {
		this.userSequence = userSequence;
	}

	public int getContestSequence() {
		return contestSequence;
	}

	public void setContestSequence(int contestSequence) {
		this.contestSequence = contestSequence;
	}

	public String getProblemId() {
		return problemId;
	}

	public void setProblemId(String problemId) {
		this.problemId = problemId;
	}

	public String getSubmitId() {
		return submitId;
	}

	public void setSubmitId(String submitId) {
		this.submitId = submitId;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public float getRuntime() {
		return runtime;
	}

	public void setRuntime(float runtime) {
		this.runtime = runtime;
	}

	public int getLanguageSequence() {
		return languageSequence;
	}

	public void setLanguageSequence(int languageSequence) {
		this.languageSequence = languageSequence;
	}

	public String getSourceUrl() {
		return sourceUrl;
	}

	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "AlgorithmContestHistory [sequence=" + sequence
				+ ", userSequence=" + userSequence + ", contestSequence="
				+ contestSequence + ", problemId=" + problemId + ", submitId="
				+ submitId + ", submitTime=" + submitTime + ", runtime="
				+ runtime + ", languageSequence=" + languageSequence
				+ ", sourceUrl=" + sourceUrl + ", createdTime=" + createdTime
				+ ", modifiedTime=" + modifiedTime + "]";
	}

}
