package com.tyss.person.controller.statement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class FindAll {
	public static void main(String[] args) {
		String qry = "select * from person";
		FileInputStream fis;
		try {
			fis = new FileInputStream("person_db.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, p);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			while (rs.next()) {
				System.out.println("----------------------------------");
				System.out.println("Id       : " + rs.getInt(1));
				System.out.println("Name     : " + rs.getString(2));
				System.out.println("Email    : " + rs.getString(3));
				System.out.println("Phone    : " + rs.getLong(4));
				System.out.println("Password : " + rs.getString(5));
				System.out.println("Age      : " + rs.getInt(6));
				System.out.println("----------------------------------");
				System.out.println();
			}
			stmt.close();
			con.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
