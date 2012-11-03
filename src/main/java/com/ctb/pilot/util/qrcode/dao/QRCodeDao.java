package com.ctb.pilot.util.qrcode.dao;

import java.util.List;

import com.ctb.pilot.util.qrcode.model.QRCodeGenerationLog;

public interface QRCodeDao {

	void insertQRCodeGenerationLog(QRCodeGenerationLog qrCodeGenerationLog);

	List<QRCodeGenerationLog> getAllQRCodeGenerationLogs();

}
