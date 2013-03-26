package com.ctb.pilot.gamification.service;

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
public class GameScoreServiceTest {

	@Autowired
	private GameScoreService gameScoreService;

	@Test
	public void recordScore() {
		int gameSequence = GameDefinition.ARKANOID.getSequence();
		int userSequence = 3;
		int score = 200;
		gameScoreService.recordScore(gameSequence, userSequence, score);
	}

	@Test
	public void getLeaderboard() {
		int gameSequence = GameDefinition.ARKANOID.getSequence();
		Leaderboard leaderboard = gameScoreService.getLeaderboard(gameSequence);
		System.out.println(leaderboard);
	}

}
