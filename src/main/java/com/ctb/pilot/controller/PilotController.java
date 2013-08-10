package com.ctb.pilot.controller;

import static com.ctb.pilot.web.menu.domain.MenuConstants.MENU_NAME_PILOT;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.ctb.pilot.web.menu.domain.SubMenuSection;
import com.ctb.pilot.web.menu.service.MenuService;

@Controller
public class PilotController {

	@Resource
	private MenuService menuService;

	@RequestMapping("/pilot")
	public String home(Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PILOT);
		model.addAttribute("subMenuSections", subMenuSections);

		return "pilot/pilot";
	}

	@RequestMapping("/pilot/algorithm_contest/programming_challenge")
	public String utilitiesTimestamp2Date(HttpServletRequest req, Model model) {
		List<SubMenuSection> subMenuSections = menuService
				.getSubMenu(MENU_NAME_PILOT);
		model.addAttribute("subMenuSections", subMenuSections);

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

		return "pilot/algorithm_contest/programming_challenge";
	}

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

	@RequestMapping("/pilot/algorithm_contest/programming_challenge/addSubmissionHistory")
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
		return "redirect:/pilot/algorithm_contest/programming_challenge";
	}

	@RequestMapping("/pilot/algorithm_contest/programming_challenge/view_source")
	public String showSource(Model model, @RequestParam String submitId)
			throws IOException {
		Document doc = Jsoup.connect(
				"http://www.programming-challenges.com/pg.php?page=viewsubmission&subid="
						+ submitId).get();
		Elements text = doc.select("pre");

		for (Element e : text) {
			String temp = e.text();
			temp = temp.replaceAll("&", "&amp;");
			temp = temp.replaceAll("<", "&lt;");
			temp = temp.replaceAll(">", "&gt;");
			System.out.println(temp);
			model.addAttribute("source", temp);
		}

		return "pilot/algorithm_contest/programming_challenge/view_source";
	}

}
