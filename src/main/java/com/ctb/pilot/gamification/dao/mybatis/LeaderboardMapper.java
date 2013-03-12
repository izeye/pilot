package com.ctb.pilot.gamification.dao.mybatis;

import java.util.List;

import com.ctb.pilot.gamification.model.LeaderboardEntry;

public interface LeaderboardMapper {

	List<LeaderboardEntry> getLeaderboard();

}
