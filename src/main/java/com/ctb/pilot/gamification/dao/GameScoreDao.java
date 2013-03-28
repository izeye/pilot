package com.ctb.pilot.gamification.dao;

import java.util.List;

import com.ctb.pilot.gamification.model.GameLog;
import com.ctb.pilot.gamification.model.Leaderboard;

public interface GameScoreDao {

	void insertScore(int gameSequence, int userSequence, int score);

	Leaderboard getLeaderboard(int gameSequence);

	List<GameLog> getGameLogs(int gameSequence, int userSequence);

}
