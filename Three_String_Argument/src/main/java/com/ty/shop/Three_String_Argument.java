package com.ty.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Three_String_Argument {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/Shopp";
		String user = "postgres";
		String password = "root";

		try {
			// step 1
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver CLass Is Loaded And Registerd");

			// step 2
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established Between Java Application And Database Server");
			System.out.println(con);
			// step 3
			Statement stmt = con.createStatement();

			String sql = "insert into products values(11,'One_Plus_031TV',25300,4)";

			// step 4
			stmt.execute(sql);

			// step 5
			con.close();
			System.out.println("Data Is Inserted");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
