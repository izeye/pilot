package com.ctb.pilot.gamification.service;

import com.ctb.pilot.gamification.model.Leaderboard;

public interface GameScoreService {

	void recordScore(int gameSequence, int userSequence, int score);

	Leaderboard getLeaderboard(int gameSequence);

}
