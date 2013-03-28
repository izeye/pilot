package com.ctb.pilot.gamification.service;

import java.util.List;

import com.ctb.pilot.gamification.model.GameLog;
import com.ctb.pilot.gamification.model.Leaderboard;

public interface GameScoreService {

	void recordScore(int gameSequence, int userSequence, int score);

	Leaderboard getLeaderboard(int gameSequence);

	List<GameLog> getHistory(int gameSequence, int userSequence);

}
