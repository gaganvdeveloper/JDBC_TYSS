package com.tyss.user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class FindUserById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String qry = "select * from users where id=?";

		try {
			FileInputStream fis = new FileInputStream("user.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, p);
			PreparedStatement pstmt = con.prepareStatement(qry);
			System.out.println("Enter The Id to Find User : ");
			pstmt.setInt(1, sc.nextInt());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("-----------------------");
				System.out.println("Name     : " + rs.getString(2));
				System.out.println("Phone    : " + rs.getLong(3));
				System.out.println("Email    : " + rs.getString(4));
				System.out.println("Password : " + rs.getString(5));
				System.out.println("-----------------------");
				System.out.println();
			}
			pstmt.close();
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
