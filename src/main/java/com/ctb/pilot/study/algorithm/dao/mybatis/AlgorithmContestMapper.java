package com.ctb.pilot.study.algorithm.dao.mybatis;

import java.util.List;

import com.ctb.pilot.gamification.model.LeaderboardEntry;
import com.ctb.pilot.study.algorithm.model.AlgorithmContestHistory;
import com.ctb.pilot.study.algorithm.model.AlgorithmProblem;

public interface AlgorithmContestMapper {

	void insertHistory(AlgorithmContestHistory history);

	List<AlgorithmProblem> getAllProblems();

	List<LeaderboardEntry> getLeaderboard();

	List<AlgorithmContestHistory> getAllHistories();

	List<AlgorithmContestHistory> getHistories(int userSequence);

}
