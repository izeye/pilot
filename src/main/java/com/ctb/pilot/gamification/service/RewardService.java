package com.ctb.pilot.gamification.service;

import com.ctb.pilot.gamification.model.Reward;
import com.ctb.pilot.gamification.model.RewardType;

public interface RewardService {

	Reward getRewardByType(RewardType rewardType);

}
