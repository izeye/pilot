package com.ctb.pilot.chat.dao.jdbc;

import static com.ctb.pilot.common.DbConstants.CONNECTION_URL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ctb.pilot.chat.dao.UserDao;
import com.ctb.pilot.chat.model.User;

public class JdbcUserDao implements UserDao {

	private User getUserBySql(String sql) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName("org.gjt.mm.mysql.Driver");

			con = DriverManager.getConnection(CONNECTION_URL);
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				User user = new User();
				user.setSequence(rs.getInt("seq"));
				user.setUserId(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
				user.setJoinDate(rs.getTimestamp("join_date"));
				user.setDeleted(rs.getInt("del_yn") == 1);
				return user;
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
		return null;
	}

	@Override
	public User login(String userId, String password) {
		return getUserBySql("select * from tb_user where user_id='" + userId
				+ "' and password='" + password + "'");
	}

	@Override
	public User getUserBySequence(int sequence) {
		return getUserBySql("select * from tb_user where seq = " + sequence);
	}
}
