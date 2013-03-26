package com.ctb.pilot.gamification.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.gamification.dao.GameScoreDao;
import com.ctb.pilot.gamification.model.Leaderboard;
import com.ctb.pilot.gamification.model.LeaderboardEntry;

@Repository("gameScoreDao")
public class GameScoreDaoMyBatis implements GameScoreDao {

	@Autowired
	private SqlSession sessionTemplate;

	@Override
	public void insertScore(int gameSequence, int userSequence, int score) {
		GameScoreMapper mapper = sessionTemplate
				.getMapper(GameScoreMapper.class);
		mapper.insertScore(gameSequence, userSequence, score);
	}

	@Override
	public Leaderboard getLeaderboard(int gameSequence) {
		GameScoreMapper mapper = sessionTemplate
				.getMapper(GameScoreMapper.class);
		List<LeaderboardEntry> leaderboardEntries = mapper
				.getLeaderboard(gameSequence);
		return new Leaderboard(leaderboardEntries);
	}

}
