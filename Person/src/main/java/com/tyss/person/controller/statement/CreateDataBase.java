package com.tyss.person.controller.statement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class CreateDataBase {
	public static void main(String[] args) {
		
		String qry = "create database human";

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
			stmt.execute(qry);
			stmt.close();
			con.close();
			System.out.println("Database Created Successfully..");

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
