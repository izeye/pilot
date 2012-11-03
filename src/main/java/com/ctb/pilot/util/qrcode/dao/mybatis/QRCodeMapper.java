package com.ctb.pilot.util.qrcode.dao.mybatis;

import java.util.List;

import com.ctb.pilot.util.qrcode.model.QRCodeGenerationLog;

public interface QRCodeMapper {

	void insertQRCodeGenerationLog(QRCodeGenerationLog qrCodeGenerationLog);

	List<QRCodeGenerationLog> getAllQRCodeGenerationLogs();

}
