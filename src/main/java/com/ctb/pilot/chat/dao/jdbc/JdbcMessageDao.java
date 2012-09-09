package com.ctb.pilot.chat.dao.jdbc;

import static com.ctb.pilot.common.DbConstants.CONNECTION_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ctb.pilot.chat.dao.MessageDao;
import com.ctb.pilot.chat.model.Message;

public class JdbcMessageDao implements MessageDao {

	@Override
	public List<Message> getMessagesWithRowCount(int rowCount) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Message> messageList = new ArrayList<Message>();
		try {
			Class.forName("org.gjt.mm.mysql.Driver");

			con = DriverManager.getConnection(CONNECTION_URL);
			stmt = con.createStatement();

			rs = stmt
					.executeQuery("select * from tb_chat_message cm, tb_user u where cm.user_seq = u.seq order by cm.seq desc limit "
							+ rowCount);
			while (rs.next()) {
				Message message = new Message();
				message.setSequence(rs.getInt("seq"));
				message.setCreatedTime(rs.getTimestamp("created_time"));
				message.setUserSequence(rs.getInt("user_seq"));
				message.setNickname(rs.getString("nickname"));
				message.setMessage(rs.getString("message"));
				messageList.add(message);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		return messageList;
	}

	@Override
	public void insertMessage(int userSequence, String message) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.gjt.mm.mysql.Driver");

			con = DriverManager.getConnection(CONNECTION_URL);
			stmt = con.createStatement();

			stmt.executeUpdate("insert into tb_chat_message (created_time, user_seq, message) values (now(), '"
					+ userSequence + "', '" + message + "')");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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

}
