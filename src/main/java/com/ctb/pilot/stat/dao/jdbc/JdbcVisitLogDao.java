package com.ctb.pilot.stat.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ctb.pilot.chat.model.Message;
import com.ctb.pilot.stat.dao.VisitLogDao;
import com.ctb.pilot.stat.model.VisitLog;

public class JdbcVisitLogDao implements VisitLogDao {
	
	public JdbcVisitLogDao() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertVisitLog(VisitLog visitLog) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager
					.getConnection("jdbc:apache:commons:dbcp:/ctb_db_pool");
			stmt = con
					.prepareStatement("insert into tb_visit_log (visit_date, ip, uri,referer,user_agent) values (now(), ?, ?, ?, ?)");
			stmt.setString(1, visitLog.getIp());
			stmt.setString(2, visitLog.getUri());
			stmt.setString(3, visitLog.getReferer());
			stmt.setString(4, visitLog.getUserAgent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Map<String, Long> getVisitTodayStatByIP() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Message> messageList = new ArrayList<Message>();
		try {
			con = DriverManager
					.getConnection("jdbc:apache:commons:dbcp:/ctb_db_pool");
			stmt = con.createStatement();

			Map<String, Long> hm = new HashMap<String, Long>();
			rs = stmt
					.executeQuery("select ip, count(1) as count from tb_visit_log group by ip");
			while(rs.next()) {
				hm.put(rs.getString("ip"), rs.getLong("count"));
			}
			return hm;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
