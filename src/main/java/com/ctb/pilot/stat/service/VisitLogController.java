package com.ctb.pilot.stat.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ctb.pilot.stat.model.DailyVisitIpLog;
import com.ctb.pilot.stat.model.DailyVisitLog;
import com.ctb.pilot.stat.model.DailyVisitUriLog;

@Controller
public class VisitLogController {

	@Autowired
	private VisitLogService visitLogService;

	@RequestMapping("/services/admin/stat/list_daily_visit_logs.do")
	public String listDailyVisitLogs(HttpServletRequest request) {
		List<DailyVisitLog> dailyVisitLogs = visitLogService
				.getDailyVisitLogs();
		request.setAttribute("dailyVisitLogs", dailyVisitLogs);

		return "/services/admin/stat/list_daily_visit_logs_view";
	}

	@RequestMapping("/services/admin/stat/list_daily_visit_ip_logs.do")
	public String listDailyVisitIpLogs(HttpServletRequest request) {
		String day = request.getParameter("day");
		List<DailyVisitIpLog> dailyVisitIpLogs = visitLogService
				.getDailyVisitIpLogs(day);
		request.setAttribute("day", day);
		request.setAttribute("dailyVisitIpLogs", dailyVisitIpLogs);

		return "/services/admin/stat/list_daily_visit_ip_logs_view";
	}

	@RequestMapping("/services/admin/stat/list_daily_visit_uri_logs.do")
	public String listDailyVisitUriLogs(HttpServletRequest request) {
		String day = request.getParameter("day");
		List<DailyVisitUriLog> dailyVisitUriLogs = visitLogService
				.getDailyVisitUriLogs(day);
		request.setAttribute("day", day);
		request.setAttribute("dailyVisitUriLogs", dailyVisitUriLogs);

		return "/services/admin/stat/list_daily_visit_uri_logs_view";
	}

}
