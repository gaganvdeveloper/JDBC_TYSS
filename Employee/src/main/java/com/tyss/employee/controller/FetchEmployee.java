package com.tyss.employee.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchEmployee {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/employee";
		String user = "postgres";
		String pass = "root";

		String sql = "select * from emp";

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);

				System.out.println("-----------------------------------------");
				System.out.println();
				System.out.println("ID           : " + id);
				System.out.println("Name         : " + name);
				System.out.println("Email        : " + rs.getString(3));
				System.out.println("Designamtion : " + rs.getString(4));
				System.out.println("Phone        : " + rs.getLong(5));
				System.out.println("Department   : " + rs.getString(6));
				System.out.println("Salary       : " + rs.getDouble(7));
				System.out.println("Password     : " + rs.getString(8));
				System.out.println();
				System.out.println("-----------------------------------------");
				System.out.println();

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
