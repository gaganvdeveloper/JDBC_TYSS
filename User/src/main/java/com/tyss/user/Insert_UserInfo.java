package com.tyss.user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Insert_UserInfo {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("user.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, p);
			Statement stmt = con.createStatement();
			String querry1 = "INSERT INTO users VALUES (108, 'Kasi', 6758393769, 'kasi2@jsp.in', 'kasi2@1234'),(109, 'Raju', 9827112099, 'raju2@jsp.in', 'raju2@1234')";
			String querry2 = "INSERT INTO users VALUES (110, 'Prithi', 7958393769, 'priti@jsp.in', 'prithi@1234')";
			stmt.addBatch(querry1);
			stmt.addBatch(querry2);
			
			int[] result = stmt.executeBatch();
			for (int i : result) {
				System.out.println(i);
			}

			System.out.println();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
