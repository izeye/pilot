package com.ctb.pilot.gamification.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.gamification.dao.LeaderboardDao;
import com.ctb.pilot.gamification.model.Leaderboard;
import com.ctb.pilot.gamification.model.LeaderboardEntry;

@Repository("leaderboardDao")
public class LeaderboardDaoMyBatis implements LeaderboardDao {

	@Autowired
	private SqlSession sessionTemplate;

	@Override
	public Leaderboard getLeaderboard() {
		LeaderboardMapper mapper = sessionTemplate
				.getMapper(LeaderboardMapper.class);
		List<LeaderboardEntry> leaderboardEntries = mapper.getLeaderboard();
		return new Leaderboard(leaderboardEntries);
	}

}
