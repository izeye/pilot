package com.ctb.pilot.study.algorithm.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

}
