package com.tyss;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class String_URL_And_Properties_Info {

	public static void main(String[] args) {

		String qry = "select * from emp";

		try {
			FileInputStream fis = new FileInputStream("emp_db.properties");
			Properties p = new Properties();
			p.load(fis);

			String url_recived = p.getProperty("URL");
			String Driver_Rec = p.getProperty("DriverClassPath");

//			Step 1
			Class.forName(Driver_Rec);

//			Step 2
			Connection con = DriverManager.getConnection(url_recived, p);

//			Step 3
			Statement stmt = con.createStatement();

//			Step 4
			ResultSet rs = stmt.executeQuery(qry);

//			Step 5
			while (rs.next()) {
				System.out.println("-------------------------");
				System.out.println("ID     : " + rs.getInt(1));
				System.out.println("Name   : " + rs.getString(2));
				System.out.println("Email  : " + rs.getString(3));
				System.out.println("--------------------------");
			}

//			Step 6
			con.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
