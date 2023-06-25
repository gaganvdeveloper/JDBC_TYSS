package com.tyss.stringurl.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class String_URL_Argument {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/shop?user=postgres&password=root";
		String sql = "insert into products values(11,'One_Plus_031TV',25300,4)";

		try {

//			Step 1
			Class.forName("org.postgresql.Driver");

//			Step 2
			Connection con = DriverManager.getConnection(url);

//			Step 3
			Statement stmt = con.createStatement();

//			Step 4
			stmt.execute(sql);

//			Step 5
			stmt.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
