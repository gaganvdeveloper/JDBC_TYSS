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

public class UpdateUserById {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String qry = "update users set name=?, phone=?, email=?, password=? where id=?";

		try {
			FileInputStream fis = new FileInputStream("user.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, p);
			PreparedStatement pstmt = con.prepareStatement(qry);
			if (verifyUser()) {
				System.out.println("Enter The Current User ID : ");
				pstmt.setInt(5, sc.nextInt());
				System.out.println("Enter The New User Name : ");
				pstmt.setString(1, sc.next());
				System.out.println("Enter The New User Phone :");
				pstmt.setString(2, sc.next());
				System.out.println("Enter The New Email : ");
				pstmt.setString(3, sc.next());
				System.out.println("Enter The New Password : ");
				pstmt.setString(4, sc.next());
				pstmt.executeUpdate();
			}
			pstmt.close();
			con.close();
			System.out.println("User Saved");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean verifyUser() {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		String qry = "select * from users where phone=? and password=?";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/userdb?user=postgres&password=root");
			PreparedStatement pstmt = con.prepareStatement(qry);
			System.out.println("Please Verify to Update : ");
			System.out.println("Please Enter Phone Number : ");
			pstmt.setLong(1, sc.nextLong());
			System.out.println("Please Enter Password : ");
			pstmt.setString(2, sc.next());
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
//				System.out.println("Verification Successfull...");
//				System.out.println("Present");
			}
			pstmt.close();
			con.close();
			sc.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return flag;
	}

}
