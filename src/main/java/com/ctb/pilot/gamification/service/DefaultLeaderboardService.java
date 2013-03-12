package com.ctb.pilot.gamification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.gamification.dao.LeaderboardDao;
import com.ctb.pilot.gamification.model.Leaderboard;

@Service("leaderboardService")
public class DefaultLeaderboardService implements LeaderboardService {

	@Autowired
	private LeaderboardDao leaderboardDao;

	public DefaultLeaderboardService() {
	}

	@Override
	public Leaderboard getLeaderboard() {
		return leaderboardDao.getLeaderboard();
	}

}
