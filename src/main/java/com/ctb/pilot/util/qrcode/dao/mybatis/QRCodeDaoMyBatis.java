package com.ctb.pilot.util.qrcode.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctb.pilot.util.qrcode.dao.QRCodeDao;
import com.ctb.pilot.util.qrcode.model.QRCodeGenerationLog;

@Repository("qrCodeDao")
public class QRCodeDaoMyBatis implements QRCodeDao {

	@Autowired
	private SqlSession sessionTemplate;

	@Override
	public void insertQRCodeGenerationLog(
			QRCodeGenerationLog qrCodeGenerationLog) {
		QRCodeMapper mapper = sessionTemplate.getMapper(QRCodeMapper.class);
		mapper.insertQRCodeGenerationLog(qrCodeGenerationLog);
	}

	@Override
	public List<QRCodeGenerationLog> getAllQRCodeGenerationLogs() {
		QRCodeMapper mapper = sessionTemplate.getMapper(QRCodeMapper.class);
		return mapper.getAllQRCodeGenerationLogs();
	}

}
