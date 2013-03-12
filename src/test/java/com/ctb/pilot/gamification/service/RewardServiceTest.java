package com.ctb.pilot.gamification.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.config.MainConfig;
import com.ctb.pilot.config.SocialConfig;
import com.ctb.pilot.gamification.model.Reward;
import com.ctb.pilot.gamification.model.RewardType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MainConfig.class, SocialConfig.class })
public class RewardServiceTest {

	@Autowired
	private RewardService rewardService;

	@Test
	public void getRewardByType() {
		Reward loginReward = rewardService.getRewardByType(RewardType.LOGIN);
		System.out.println(loginReward);

		Reward chatReward = rewardService.getRewardByType(RewardType.CHAT);
		System.out.println(chatReward);
	}

}
