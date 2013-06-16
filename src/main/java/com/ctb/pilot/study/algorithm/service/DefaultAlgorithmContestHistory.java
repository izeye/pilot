package com.ctb.pilot.study.algorithm.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctb.pilot.gamification.model.Leaderboard;
import com.ctb.pilot.study.algorithm.dao.AlgorithmContestDao;
import com.ctb.pilot.study.algorithm.model.AlgorithmContestHistory;
import com.ctb.pilot.study.algorithm.model.AlgorithmProblem;

@Service("algorithmContestHistory")
public class DefaultAlgorithmContestHistory implements AlgorithmContestService {

	@Resource
	private AlgorithmContestDao algorithmContestDao;

	@Override
	public void addhistory(AlgorithmContestHistory history) {
		algorithmContestDao.insertHistory(history);
	}

	@Override
	public Leaderboard getLeaderboard() {
		return algorithmContestDao.getLeaderboard();
	}

	@Override
	public List<AlgorithmProblem> getAllProblems() {
		return algorithmContestDao.getAllProblems();
	}

}
