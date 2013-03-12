package com.ctb.pilot.gamification.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.config.MainConfig;
import com.ctb.pilot.config.SocialConfig;
import com.ctb.pilot.gamification.model.Leaderboard;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MainConfig.class, SocialConfig.class })
public class LeaderboardServiceTest {

	@Autowired
	private LeaderboardService leaderboardService;

	@Test
	public void getLeaderboard() {
		Leaderboard leaderboard = leaderboardService.getLeaderboard();
		System.out.println(leaderboard);
	}

}
