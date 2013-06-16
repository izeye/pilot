package com.ctb.pilot.study.algorithm.dao;

import java.util.List;

import com.ctb.pilot.study.algorithm.model.AlgorithmContestHistory;
import com.ctb.pilot.study.algorithm.model.AlgorithmProblem;

public interface AlgorithmContestDao {

	void insertHistory(AlgorithmContestHistory history);

	List<AlgorithmProblem> getAllProblems();

}
