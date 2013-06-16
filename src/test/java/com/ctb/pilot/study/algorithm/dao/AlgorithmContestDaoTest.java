package com.ctb.pilot.study.algorithm.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.config.MainConfig;
import com.ctb.pilot.config.SocialConfig;
import com.ctb.pilot.gamification.model.Leaderboard;
import com.ctb.pilot.study.algorithm.model.AlgorithmContest;
import com.ctb.pilot.study.algorithm.model.AlgorithmContestHistory;
import com.ctb.pilot.study.algorithm.model.AlgorithmProblem;
import com.ctb.pilot.study.algorithm.model.ProgrammingLanguage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { MainConfig.class, SocialConfig.class })
public class AlgorithmContestDaoTest {

	@Resource
	private AlgorithmContestDao algorithmContestDao;

	@Test
	public void insertHistory() {
		int userSequence = 1;
		int contestSequence = AlgorithmContest.PROGRAMMING_CHALLENGE
				.getSequence();
		String problemId = "110101";
		String submitId = "476006";
		Date submitTime = new Date();
		float runtime = 1.388f;
		int languageSequence = ProgrammingLanguage.JAVA.getSequence();
		String sourceUrl = "http://www.programming-challenges.com/pg.php?page=viewsubmission&subid=476006";
		AlgorithmContestHistory history = new AlgorithmContestHistory(
				userSequence, contestSequence, problemId, submitId, submitTime,
				runtime, languageSequence, sourceUrl);
		algorithmContestDao.insertHistory(history);
	}

	@Test
	public void getAllProblems() {
		List<AlgorithmProblem> allProblems = algorithmContestDao
				.getAllProblems();
		System.out.println(allProblems);
	}

	@Test
	public void getLeaderboard() {
		Leaderboard leaderboard = algorithmContestDao.getLeaderboard();
		System.out.println(leaderboard);
	}

}
