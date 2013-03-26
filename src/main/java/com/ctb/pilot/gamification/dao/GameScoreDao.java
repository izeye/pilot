package com.ctb.pilot.gamification.dao;

import com.ctb.pilot.gamification.model.Leaderboard;

public interface GameScoreDao {

	void insertScore(int gameSequence, int userSequence, int score);

	Leaderboard getLeaderboard(int gameSequence);

}
