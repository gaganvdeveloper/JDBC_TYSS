package com.tyss.person.controller.preparedstatement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class UpdatePerson {
	public static void main(String[] args) {

		String qry = "update person set name=?, email=?, phone=?, password=?, age=? where id=?";

		try {
			FileInputStream fis = new FileInputStream("person_db.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			Connection con = DriverManager.getConnection(url, p);
			PreparedStatement pstmt = con.prepareStatement(qry);

			pstmt.setString(1, "Gagan v");
			pstmt.setString(2, "gaganv@gmail.com");
			pstmt.setLong(3, 781304012);
			pstmt.setString(4, "Alpha@456");
			pstmt.setInt(5, 25);
			pstmt.setInt(6, 5);
			int r = pstmt.executeUpdate();
			System.out.println(r + " Rows Affected");
			pstmt.close();
			con.close();
			System.out.println("Person Updated Successfully...");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
