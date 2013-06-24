package com.ctb.pilot.study.algorithm.service;

import java.util.List;

import com.ctb.pilot.gamification.model.Leaderboard;
import com.ctb.pilot.study.algorithm.model.AlgorithmContestHistory;
import com.ctb.pilot.study.algorithm.model.AlgorithmProblem;

public interface AlgorithmContestService {

	void addhistory(AlgorithmContestHistory history);

	List<AlgorithmProblem> getAllProblems();

	Leaderboard getLeaderboard();

	List<AlgorithmContestHistory> getAllHistories();

	List<AlgorithmContestHistory> getHistories(int userSequence);

}
