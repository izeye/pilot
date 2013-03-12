package com.ctb.pilot.gamification.dao;

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
public class LeaderboardDaoTest {

	@Autowired
	private LeaderboardDao leaderboardDao;

	@Test
	public void getLeaderboard() {
		Leaderboard leaderboard = leaderboardDao.getLeaderboard();
		System.out.println(leaderboard);
	}

}
