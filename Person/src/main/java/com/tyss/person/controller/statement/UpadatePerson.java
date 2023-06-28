package com.tyss.person.controller.statement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class UpadatePerson {
	public static void main(String[] args) {
		String qry = "update person set name='SHISHIRA BHAT', email ='tyss@gmail.com', phone=64984189, password='Passw0rd!@#', age=54  where id=2";
		try {

			FileInputStream fis = new FileInputStream("person_db.properties");
			Properties p = new Properties();
			p.load(fis);
			String url = p.getProperty("url");
			String driver = p.getProperty("driver");
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, p);

			Statement stmt = con.createStatement();
			stmt.execute(qry);
			System.out.println("Person Updated Successfully... ");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
