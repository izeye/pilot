package com.ctb.pilot.gamification.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.config.MainConfig;
import com.ctb.pilot.config.SocialConfig;
import com.ctb.pilot.gamification.model.GameDefinition;
import com.ctb.pilot.gamification.model.Leaderboard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MainConfig.class, SocialConfig.class })
public class GameScoreDaoTest {

	@Autowired
	private GameScoreDao gameScoreDao;

	@Test
	public void insertScore() {
		int gameSequence = GameDefinition.ARKANOID.getSequence();
		int userSequence = 2;
		int score = 100;
		gameScoreDao.insertScore(gameSequence, userSequence, score);
	}

	@Test
	public void getLeaderboard() {
		int gameSequence = GameDefinition.ARKANOID.getSequence();
		Leaderboard leaderboard = gameScoreDao.getLeaderboard(gameSequence);
		System.out.println(leaderboard);
	}

}
