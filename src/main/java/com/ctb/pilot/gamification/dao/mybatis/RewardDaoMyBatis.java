package com.ctb.pilot.gamification.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.gamification.dao.RewardDao;
import com.ctb.pilot.gamification.model.Reward;

@Repository("rewardDao")
public class RewardDaoMyBatis implements RewardDao {

	@Autowired
	private SqlSession sessionTemplate;

	@Override
	public List<Reward> getAllRewards() {
		RewardMapper mapper = sessionTemplate.getMapper(RewardMapper.class);
		return mapper.getAllRewards();
	}

}
