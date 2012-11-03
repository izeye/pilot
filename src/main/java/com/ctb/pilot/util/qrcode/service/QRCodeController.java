package com.ctb.pilot.util.qrcode.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ctb.pilot.common.util.QRCodeUtils;
import com.ctb.pilot.util.qrcode.model.QRCodeGenerationLog;
import com.google.zxing.WriterException;

@Controller
public class QRCodeController {

	@Autowired
	private QRCodeService qrCodeService;

	@RequestMapping("/services/qrcode/text2qrcode.do")
	public void text2QRCode(@RequestParam("width") int width,
			@RequestParam("height") int height,
			@RequestParam("text") String text, HttpServletRequest request,
			HttpServletResponse response) throws IOException, WriterException {
		ServletOutputStream sos = response.getOutputStream();
		QRCodeUtils.text2QRCode(text, width, height, sos);
		sos.flush();
		sos.close();

		String ip = request.getRemoteAddr();
		qrCodeService.logQRCodeGeneration(text, width, height, ip);
	}

	@RequestMapping("/services/qrcode/qrcode_history.do")
	public String showQRCodeGenerationHistory(Model model) {
		List<QRCodeGenerationLog> allQRCodeGenerationLogs = qrCodeService
				.getAllQRCodeGenerationLogs();
		model.addAttribute("qrCodeGenerationLogs", allQRCodeGenerationLogs);
		return "services/admin/stat/list_all_qrcode_generation_logs_view";
	}

}
