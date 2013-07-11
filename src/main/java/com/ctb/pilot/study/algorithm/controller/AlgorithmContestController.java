package com.ctb.pilot.study.algorithm.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ctb.pilot.gamification.model.Leaderboard;
import com.ctb.pilot.study.algorithm.model.AlgorithmContestHistory;
import com.ctb.pilot.study.algorithm.model.AlgorithmProblem;
import com.ctb.pilot.study.algorithm.model.ProgrammingLanguage;
import com.ctb.pilot.study.algorithm.service.AlgorithmContestService;
import com.ctb.pilot.user.model.User;

@Controller
public class AlgorithmContestController {

	private static final int INDEX_SUBMIT_ID = 0;
	private static final int INDEX_SUBMIT_DATE = 1;
	private static final int INDEX_SUBMIT_TIME = 2;
	private static final int INDEX_VERDICT = 3;
	private static final int INDEX_RUNTIME = 4;
	private static final int INDEX_LANGUAGE = 6;

	private ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yy/MM/dd HH:mm");
		}
	};

	@Resource
	private AlgorithmContestService algorithmContestService;

	@RequestMapping("/services/study/algorithm_contest/addHistory.do")
	public String addHistory(@RequestParam int contestSequence,
			@RequestParam String problemId,
			@RequestParam String submissionHistory, HttpServletRequest req)
			throws ParseException {
		String[] splitSubmissionHistory = submissionHistory.split("[\t ]+");
		String submitId = splitSubmissionHistory[INDEX_SUBMIT_ID].trim();
		Date submitTime = dateFormat.get().parse(
				splitSubmissionHistory[INDEX_SUBMIT_DATE].trim() + " "
						+ splitSubmissionHistory[INDEX_SUBMIT_TIME].trim());
		if (!splitSubmissionHistory[INDEX_VERDICT].trim().equals("Solved")) {
			throw new IllegalArgumentException(submissionHistory);
		}
		float runtime = Float.parseFloat(splitSubmissionHistory[INDEX_RUNTIME]
				.trim());
		ProgrammingLanguage language = ProgrammingLanguage
				.valueOf(splitSubmissionHistory[INDEX_LANGUAGE].trim());
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int userSequence = user.getSequence();
		String sourceUrl = "http://www.programming-challenges.com/pg.php?page=viewsubmission&subid="
				+ submitId;
		AlgorithmContestHistory history = new AlgorithmContestHistory(
				userSequence, contestSequence, problemId, submitId, submitTime,
				runtime, language.getSequence(), sourceUrl);
		algorithmContestService.addhistory(history);
		return "redirect:/common/web_template.jsp?body_path=/services/study/algorithm_contest/show.do";
	}

	@RequestMapping("/services/study/algorithm_contest/show.do")
	public String show(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		int userSequence = user.getSequence();
		List<AlgorithmContestHistory> yourHistories = algorithmContestService
				.getHistories(userSequence);
		model.addAttribute("yourHistories", yourHistories);

		List<AlgorithmContestHistory> allHistories = algorithmContestService
				.getAllHistories();
		model.addAttribute("allHistories", allHistories);

		Leaderboard leaderboard = algorithmContestService.getLeaderboard();
		model.addAttribute("leaderboardEntries", leaderboard.getEntries());

		List<AlgorithmProblem> problemList = algorithmContestService
				.getAllProblems();
		model.addAttribute("problemList", problemList);

		return "services/study/algorithm_contest/show_algorithm_contest";
	}

	@RequestMapping("/services/study/algorithm_contest/showSource.do")
	public String showSource(Model model, @RequestParam String submitId)
			throws IOException {
		Document doc = Jsoup.connect(
				"http://www.programming-challenges.com/pg.php?page=viewsubmission&subid="
						+ submitId).get();
		Elements text = doc.select("pre");

		List<String> source = new ArrayList<String>();

		for (Element e : text) {
			System.out.println(e.text());
			source.add(e.text());
		}

		model.addAttribute("source", source);

		return "services/study/algorithm_contest/show_source";
	}

}
