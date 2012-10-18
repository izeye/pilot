package com.ctb.pilot.common.filter.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctb.pilot.stat.dao.VisitLogDao;
import com.ctb.pilot.stat.dao.jdbc.JdbcVisitLogDao;
import com.ctb.pilot.stat.model.VisitLog;

public class AccessLogFilter implements Filter {

	private PrintWriter requestLogWriter;
	private PrintWriter responseLogWriter;
	private VisitLogDao visitLogDao;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String requestLogFilename = filterConfig
				.getInitParameter("REQUEST_LOG_FILENAME");
		String responseLogFilename = filterConfig
				.getInitParameter("RESPONSE_LOG_FILENAME");
		File requestLogFile = new File(requestLogFilename);
		File responseLogFile = new File(responseLogFilename);
		System.out.println("requestLogFile: "
				+ requestLogFile.getAbsolutePath());
		System.out.println("responseLogFile: "
				+ responseLogFile.getAbsolutePath());
		try {
			requestLogWriter = new PrintWriter(new FileWriter(requestLogFile,
					true), true);
			responseLogWriter = new PrintWriter(new FileWriter(responseLogFile,
					true), true);
		} catch (IOException e) {
			e.printStackTrace();
		}

		visitLogDao = new JdbcVisitLogDao();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		Date visitDate = new Date();
		String ip = httpRequest.getRemoteAddr();
		String uri = httpRequest.getRequestURI();
		if (uri.equals("/common/web_template.jsp")) {
			uri = httpRequest.getParameter("body_path");
		}
		String referer = httpRequest.getHeader("Referer");
		String userAgent = httpRequest.getHeader("User-Agent");
		VisitLog visitLog = new VisitLog();
		visitLog.setIp(ip);
		visitLog.setReferer(referer);
		if (uri.length() > 100) {
			uri = uri.substring(0, 100);
		}
		visitLog.setUri(uri);
		visitLog.setUserAgent(userAgent);

		System.out.println("visitDate: " + visitDate);
		System.out.println("ip: " + ip);
		System.out.println("uri: " + uri);
		System.out.println("referer: " + referer);
		System.out.println("userAgent: " + userAgent);
		System.out.println(userAgent.length());

		visitLogDao.insertVisitLog(visitLog);

		// GregorianCalendar now = new GregorianCalendar();
		// requestLogWriter.printf("[%TF %TT]%n", now, now);
		// requestLogWriter.printf("Client IP: %s%n", remoteAddr);
		// requestLogWriter.println("----------");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		if (requestLogWriter != null) {
			requestLogWriter.close();
		}
		if (responseLogWriter != null) {
			responseLogWriter.close();
		}
	}

}
