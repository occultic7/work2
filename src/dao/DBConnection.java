package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	private static final String driverName = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/testdb3?useUnicode=true&characterEncoding=UTF-8";
	private static final String user = "root";
	private static final String password = "root";

	private DBConnection() {
	}

	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn=null;
		try {
			conn= DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet rs, Statement st, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
