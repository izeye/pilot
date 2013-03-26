package com.ctb.pilot.gamification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.gamification.dao.GameScoreDao;
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

}
