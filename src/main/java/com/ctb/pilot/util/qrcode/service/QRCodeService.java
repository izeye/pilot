package com.ctb.pilot.util.qrcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctb.pilot.util.qrcode.dao.QRCodeDao;
import com.ctb.pilot.util.qrcode.model.QRCodeGenerationLog;

@Service("qrCodeService")
public class QRCodeService {

	@Autowired
	private QRCodeDao qrCodeDao;

	public void logQRCodeGeneration(String text, int width, int height,
			String ip) {
		qrCodeDao.insertQRCodeGenerationLog(new QRCodeGenerationLog(text,
				width, height, ip));
	}

	public List<QRCodeGenerationLog> getAllQRCodeGenerationLogs() {
		return qrCodeDao.getAllQRCodeGenerationLogs();
	}

}
