package com.ctb.pilot.util.qrcode.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.util.qrcode.model.QRCodeGenerationLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class QRCodeServiceTest {

	@Autowired
	private QRCodeService qrCodeService;

	@Test
	public void logQRCodeGeneration() {
		String text = "http://devday.tistory.com";
		int width = 200;
		int height = 200;
		String ip = "1.2.3.4";

		qrCodeService.logQRCodeGeneration(text, width, height, ip);
	}

	@Test
	public void getAllQRCodeGenerationLogs() {
		List<QRCodeGenerationLog> allQRCodeGenerationLogs = qrCodeService
				.getAllQRCodeGenerationLogs();
		System.out.println(allQRCodeGenerationLogs);
	}

}
