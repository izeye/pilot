package com.ctb.pilot.study.algorithm.model;

import java.util.Date;

public class AlgorithmProblem {

	private int contestSequence;
	private String problemId;
	private String title;
	private String url;
	private Date createdTime;
	private Date modifiedTime;
	
	public AlgorithmProblem() {
	}
	

	public AlgorithmProblem(int contestSequence, String problemId,
			String title, String url, Date createdTime, Date modifiedTime) {
		this.contestSequence = contestSequence;
		this.problemId = problemId;
		this.title = title;
		this.url = url;
		this.createdTime = createdTime;
		this.modifiedTime = modifiedTime;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		return "AlgorithmProblem [contestSequence=" + contestSequence
				+ ", problemId=" + problemId + ", title=" + title + ", url="
				+ url + ", createdTime=" + createdTime + ", modifiedTime="
				+ modifiedTime + "]";
	}

}
