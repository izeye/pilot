package com.ctb.pilot.study.algorithm.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctb.pilot.study.algorithm.dao.AlgorithmContestDao;
import com.ctb.pilot.study.algorithm.model.AlgorithmContestHistory;

@Service("algorithmContestHistory")
public class DefaultAlgorithmContestHistory implements AlgorithmContestService {

	@Resource
	private AlgorithmContestDao algorithmContestDao;

	@Override
	public void addhistory(AlgorithmContestHistory history) {
		algorithmContestDao.insertHistory(history);
	}

}
