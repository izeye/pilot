package com.ctb.pilot.gamification.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.gamification.dao.GameScoreDao;
import com.ctb.pilot.gamification.model.GameLog;
import com.ctb.pilot.gamification.model.Leaderboard;

@Service("gameScoreService")
public class DefaultGameScoreService implements GameScoreService {

	@Autowired
	private GameScoreDao gameScoreDao;

	@Override
	public void recordScore(int gameSequence, int userSequence, int score) {
		gameScoreDao.insertScore(gameSequence, userSequence, score);
	}

	@Override
	public Leaderboard getLeaderboard(int gameSequence) {
		return gameScoreDao.getLeaderboard(gameSequence);
	}

	@Override
	public List<GameLog> getHistory(int gameSequence, int userSequence) {
		return gameScoreDao.getGameLogs(gameSequence, userSequence);
	}

}
