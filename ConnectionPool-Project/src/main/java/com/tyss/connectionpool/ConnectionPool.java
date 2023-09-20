package com.tyss.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	private static List<Connection> connectionsPool = new ArrayList<Connection>();
	private static String URL = "jdbc:postgresql://localhost:5432/school";
	private static String DRIVER = "org.postgresql.Driver";
	private static String USER = "postgres";
	private static String PASSWORD = "root";
	private static final int POOL_SIZE = 5;

	static {
		try {
			Class.forName(DRIVER);
			for (int i = 1; i <= POOL_SIZE; i++) {
				connectionsPool.add(createConnection());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static Connection createConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConnection() {
		if (!connectionsPool.isEmpty()) {
			return connectionsPool.remove(0);
		} else
			return createConnection();
	}

	public void reciveConnection(Connection con) {

		if (connectionsPool.size() < POOL_SIZE) {
			connectionsPool.add(con);
		} else
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
