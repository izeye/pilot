package com.ctb.pilot.stat.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ctb.pilot.stat.model.DailyVisitLog;

@Controller
public class VisitLogController {

	@Autowired
	private VisitLogService visitLogService;

	@RequestMapping("/services/admin/stat/list_daily_visit_logs_view.do")
	public String listDailyVisitLogs(HttpServletRequest request) {
		List<DailyVisitLog> dailyVisitLogs = visitLogService
				.getDailyVisitLogs();
		request.setAttribute("dailyVisitLogs", dailyVisitLogs);

		return "/services/admin/stat/list_daily_visit_logs_view";
	}

}
