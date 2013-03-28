package com.ctb.pilot.gamification.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ctb.pilot.gamification.model.GameLog;
import com.ctb.pilot.gamification.model.LeaderboardEntry;

public interface GameScoreMapper {

	void insertScore(@Param("gameSequence") int gameSequence,
			@Param("userSequence") int userSequence, @Param("score") int score);

	List<LeaderboardEntry> getLeaderboard(
			@Param("gameSequence") int gameSequence);

	List<GameLog> getGameLogs(@Param("gameSequence") int gameSequence,
			@Param("userSequence") int userSequence);

}
