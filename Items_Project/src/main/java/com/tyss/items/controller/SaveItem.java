package com.tyss.items.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class SaveItem {
	public static void main(String[] args) {
		String qry = "insert into items values(44,'Voltas Air Conditioner ',4,15000.12,'VOLTAS')";
		try {

			FileInputStream fis = new FileInputStream("items.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");

//			Step 1
			Class.forName(driver);

//			Step 2
			Connection con = DriverManager.getConnection(url,p);

//			Step 3
			Statement stmt = con.createStatement();

//			Step 4
			stmt.execute(qry);

//			Step 5
			stmt.close();
			con.close();
			System.out.println("Product Added Successfully...");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
