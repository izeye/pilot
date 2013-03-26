package com.ctb.pilot.gamification.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ctb.pilot.gamification.model.Leaderboard;
import com.ctb.pilot.user.model.User;

@Controller
public class GameScoreController {

	@Autowired
	private GameScoreService gameScoreService;

	@RequestMapping("/services/game/score/leaderboard.do")
	public String showLeaderboard(HttpServletRequest req, Model model) {
		int gameSequence = Integer.parseInt(req.getParameter("game_sequence"));
		Leaderboard leaderboard = gameScoreService.getLeaderboard(gameSequence);
		model.addAttribute("entries", leaderboard.getEntries());
		return "/services/games/leaderboard";
	}

	@RequestMapping(value = "/services/game/score/record.do", method = RequestMethod.POST)
	public void recordScore(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		int gameSequence = Integer.parseInt(req.getParameter("game_sequence"));
		User user = (User) session.getAttribute("user");
		int userSequence = user.getSequence();
		int score = Integer.parseInt(req.getParameter("score"));
		gameScoreService.recordScore(gameSequence, userSequence, score);
	}

}
