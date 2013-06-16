package com.ctb.pilot.study.algorithm.dao.mybatis;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.study.algorithm.dao.AlgorithmContestDao;
import com.ctb.pilot.study.algorithm.model.AlgorithmContestHistory;

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

}
