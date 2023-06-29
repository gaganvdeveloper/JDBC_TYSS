package com.tyss.user.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class UserDao {
	static Connection con;
	static {
		FileInputStream fis;
		try {
			fis = new FileInputStream("user.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			Class.forName(driver);
			con = DriverManager.getConnection(url, p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int saveUser(int id, String name, long phone, String email, String password) {
		String qry = "insert into users values(?,?,?,?,?)";
		int r = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setLong(3, phone);
			pstmt.setString(4, email);
			pstmt.setString(5, password);
			r = pstmt.executeUpdate();
			System.out.println("User Registerd Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public int updateUser(int id, String name, long phone, String email, String password) {
		String qry = "update users set name=?, phone=?, email=?, password=? where id=?";
		int r = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setLong(2, phone);
			pstmt.setString(3, email);
			pstmt.setString(4, password);
			pstmt.setInt(5, id);
			r = pstmt.executeUpdate();
			System.out.println("User Updated Successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public void findUserById(int id) {
		String qry = "select * from users where id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("---------------------------");
				System.out.println("Name     : " + rs.getString(2));
				System.out.println("Phone    : " + rs.getLong(3));
				System.out.println("Email    : " + rs.getString(4));
				System.out.println("Password : " + rs.getString(4));
				System.out.println("----------------------------");
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int deleteUserById(int id) {
		String qry = "delete from users where id=?";
		int r = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(qry);
			pstmt.setInt(1, id);
			r = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public void findAllUsers() {

		String qry = "select * from users";

		try {
			PreparedStatement pstmt = con.prepareStatement(qry);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("---------------------------");
				System.out.println("Name     : " + rs.getString(2));
				System.out.println("Phone    : " + rs.getLong(3));
				System.out.println("Email    : " + rs.getString(4));
				System.out.println("Password : " + rs.getString(4));
				System.out.println("----------------------------");
				System.out.println();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
