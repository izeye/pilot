package com.ctb.pilot.user.service;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;

import com.ctb.pilot.common.model.Multipart;
import com.ctb.pilot.user.dao.UserDao;
import com.ctb.pilot.user.dao.jdbc.JdbcUserDao;

public class SignUpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Multipart multipart = new Multipart(req);
			String userId = multipart.getParameter("user_id");
			String password = multipart.getParameter("password");
			String nickname = multipart.getParameter("nickname");

			if (userId == null || password == null || nickname == null
					|| userId.isEmpty() || password.isEmpty()
					|| nickname.isEmpty()) {
				throw new ServletException("Some field is null or empty.");
			}

			// ServletContext application = req.getServletContext();
			// String realPath = application.getRealPath("/images/" + nickname
			// + ".jpg");
			// multipart.saveFile("imageFile", realPath);

			InputStream image = multipart.getInputStream("imageFile");

			UserDao userDao = new JdbcUserDao();
			userDao.signUp(userId, password, nickname, image);
		} catch (FileUploadException e) {
			e.printStackTrace();
			throw new ServletException(e);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}

		resp.sendRedirect("/common/web_template.jsp?body_path=/services/user/sign_up/sign_up_result.jsp");
	}

}
