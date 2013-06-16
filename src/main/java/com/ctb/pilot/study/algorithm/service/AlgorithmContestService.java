package com.ctb.pilot.study.algorithm.service;

import com.ctb.pilot.gamification.model.Leaderboard;
import com.ctb.pilot.study.algorithm.model.AlgorithmContestHistory;

public interface AlgorithmContestService {

	void addhistory(AlgorithmContestHistory history);

	Leaderboard getLeaderboard();

}
