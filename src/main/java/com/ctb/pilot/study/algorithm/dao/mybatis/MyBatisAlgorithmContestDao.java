package com.ctb.pilot.study.algorithm.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.gamification.model.Leaderboard;
import com.ctb.pilot.gamification.model.LeaderboardEntry;
import com.ctb.pilot.study.algorithm.dao.AlgorithmContestDao;
import com.ctb.pilot.study.algorithm.model.AlgorithmContestHistory;
import com.ctb.pilot.study.algorithm.model.AlgorithmProblem;

@Repository("algorithmContestDao")
public class MyBatisAlgorithmContestDao implements AlgorithmContestDao {

	@Resource
	private SqlSession session;

	@Override
	public void insertHistory(AlgorithmContestHistory history) {
		AlgorithmContestMapper mapper = session
				.getMapper(AlgorithmContestMapper.class);
		mapper.insertHistory(history);
	}

	@Override
	public List<AlgorithmProblem> getAllProblems() {
		AlgorithmContestMapper mapper = session
				.getMapper(AlgorithmContestMapper.class);
		return mapper.getAllProblems();
	}

	@Override
	public Leaderboard getLeaderboard() {
		AlgorithmContestMapper mapper = session
				.getMapper(AlgorithmContestMapper.class);
		List<LeaderboardEntry> leaderboardEntries = mapper.getLeaderboard();
		return new Leaderboard(leaderboardEntries);
	}

	@Override
	public List<AlgorithmContestHistory> getAllHistories() {
		AlgorithmContestMapper mapper = session
				.getMapper(AlgorithmContestMapper.class);
		return mapper.getAllHistories();
	}

	@Override
	public List<AlgorithmContestHistory> getHistories(int userSequence) {
		AlgorithmContestMapper mapper = session
				.getMapper(AlgorithmContestMapper.class);
		return mapper.getHistories(userSequence);
	}

}
