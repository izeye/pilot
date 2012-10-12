package com.ctb.pilot.util.clock.service;

import java.util.Date;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClockServiceController {
	@RequestMapping("/services/clock/world_clock.do")
	public String getWorldClock(HttpServletRequest request,Model model){
		model.addAttribute("now",new Date());
		model.addAttribute("timeZoneIds",TimeZone.getAvailableIDs());
		
		return "/services/clock/world_clock_view";
	}
}
