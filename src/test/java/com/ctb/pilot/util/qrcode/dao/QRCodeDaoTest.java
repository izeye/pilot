package com.ctb.pilot.util.qrcode.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctb.pilot.util.qrcode.model.QRCodeGenerationLog;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class QRCodeDaoTest {

	@Autowired
	private QRCodeDao qrCodeDao;

	@Test
	public void insertQRCodeGenerationLog() {
		QRCodeGenerationLog qrCodeGenerationLog = new QRCodeGenerationLog();
		qrCodeGenerationLog.setText("http://devday.tistory.com");
		qrCodeGenerationLog.setWidth(200);
		qrCodeGenerationLog.setHeight(200);
		qrCodeGenerationLog.setIp("1.2.3.4");

		qrCodeDao.insertQRCodeGenerationLog(qrCodeGenerationLog);
	}

	@Test
	public void getAllQRCodeGenerationLogs() {
		List<QRCodeGenerationLog> allQRCodeGenerationLogs = qrCodeDao
				.getAllQRCodeGenerationLogs();
		System.out.println(allQRCodeGenerationLogs);
	}

}
