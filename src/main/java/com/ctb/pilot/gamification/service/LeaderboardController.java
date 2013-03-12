package com.ctb.pilot.gamification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ctb.pilot.gamification.model.Leaderboard;

@Controller
public class LeaderboardController {

	@Autowired
	private LeaderboardService leaderboardService;

	@RequestMapping("/services/games/leaderboard.do")
	public String showLeaderboard(Model model) {
		Leaderboard leaderboard = leaderboardService.getLeaderboard();
		model.addAttribute("entries", leaderboard.getEntries());
		return "/services/games/leaderboard";
	}

}
