package com.ctb.pilot.gamification.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.gamification.dao.RewardDao;
import com.ctb.pilot.gamification.model.Reward;
import com.ctb.pilot.gamification.model.RewardType;

@Service("rewardService")
public class DefaultRewardService implements RewardService {

	@Autowired
	private RewardDao rewardDao;

	private Map<RewardType, Reward> typeAndRewardMap = new HashMap<RewardType, Reward>();

	public DefaultRewardService() {
	}

	@PostConstruct
	void init() {
		List<Reward> allRewards = rewardDao.getAllRewards();
		for (Reward reward : allRewards) {
			typeAndRewardMap.put(reward.getType(), reward);
		}
	}

	@Override
	public Reward getRewardByType(RewardType rewardType) {
		return typeAndRewardMap.get(rewardType);
	}

}
