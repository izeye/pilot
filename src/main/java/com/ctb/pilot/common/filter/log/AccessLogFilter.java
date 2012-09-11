package com.ctb.pilot.common.filter.log;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.GregorianCalendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessLogFilter implements Filter {

	private PrintWriter requestLogWriter;
	private PrintWriter responseLogWriter;

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
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		GregorianCalendar now = new GregorianCalendar();
		String remoteAddr = httpRequest.getRemoteAddr();
		requestLogWriter.printf("[%TF %TT]%n", now, now);
		requestLogWriter.printf("Client IP: %s%n", remoteAddr);
		requestLogWriter.println("----------");
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
