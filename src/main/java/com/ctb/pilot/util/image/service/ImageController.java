package com.ctb.pilot.util.image.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageController {

	@Autowired
	private ImageService imageService;

	@RequestMapping("/services/image/image.do")
	public void getImage(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String userSeq = request.getParameter("userSeq");
		
		byte[] bytes = imageService.getImage(userSeq);
		
		if (bytes != null && bytes.length > 0) {
			InputStream is = new ByteArrayInputStream(bytes);
			String contentType = URLConnection.guessContentTypeFromStream(is);
			
			if (contentType.equals("image/jpeg")
					|| contentType.equals("image/png")
					|| contentType.equals("image/gif")) {
				response.setContentType(contentType);
				response.setContentLength((int) bytes.length);

				ServletOutputStream os = response.getOutputStream();

				FileCopyUtils.copy(is, os);
				os.flush();
			}
		}else{
			//db에 이미지가 없을 경우에 어떻게 할것인가?
			//
			response.setContentType("image/jpeg");
			ServletOutputStream os = response.getOutputStream();
			os.print("<div>No Image!</div>");
			os.flush();
		}
	}
}
