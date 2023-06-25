package com.tyss.employee.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SaveEmployee {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/employee";
		String user = "postgres";
		String password = "root";

		String sql = "insert into emp values(5,'SANDEEP','sandeepdeveloper@gmail.com','ASE',9380684864,'Development','26500','Pass#123')";

		try {

			// step 1
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver Class Is Loaded and Registerd");

			// step 2
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Established with Database Server");

			// step 3
			Statement stmt = con.createStatement();
			System.out.println("Platform is Created");

			// step 4
			stmt.execute(sql);
			System.out.println("Execute the SQL Query");

			// step 5
			con.close();

			System.out.println("Employee Inserted Successfully...");
//			System.out.println("1 Row is Affected...");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
