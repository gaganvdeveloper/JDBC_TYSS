package com.tyss.person.controller;

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

public class MainController {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("Please Select Option");
			System.out.println("1) Register");
			System.out.println("2) Update");
			System.out.println("3) Remove");
			System.out.println("4) Find-By-Phone");
			System.out.println("5) Find-By-Email");
			System.out.println("6) Find-All");
			System.out.println("7) Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				savePerson();
				break;
			case 2:
				updatePerson();
				break;
			case 3:
				removePerson();
				break;
			case 4:
				findByPhone();
				break;
			case 5:
				findByEmail();
				break;
			case 6:
				findAll();
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.err.println("Invalid Option\nPlease Select Correct One");
				break;
			}

		}

	}

	private static void findAll() {

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
			PreparedStatement pstmt = con.prepareStatement(qry);
			ResultSet rs = pstmt.executeQuery();
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

	private static void findByEmail() {
		String qry = "select * from person where email=?";
		FileInputStream fis;
		try {
			fis = new FileInputStream("person_db.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, p);
			PreparedStatement pstmt = con.prepareStatement(qry);
			System.out.println("Enter The Email to Find");
			pstmt.setString(1, sc.next());
			ResultSet rs = pstmt.executeQuery();
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

	private static void findByPhone() {
		String qry = "select * from person where phone=?";
		FileInputStream fis;
		try {
			fis = new FileInputStream("person_db.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, p);
			PreparedStatement pstmt = con.prepareStatement(qry);
			System.out.println("Enter The Phone Number : ");
			pstmt.setLong(1, sc.nextLong());
			ResultSet rs = pstmt.executeQuery();
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

	public static void removePerson() {

		String qry = "delete from person where id=?";

		try {
			FileInputStream fis = new FileInputStream("person_db.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			Connection con = DriverManager.getConnection(url, p);
			PreparedStatement pstmt = con.prepareStatement(qry);
			System.out.println("Enter The ID to Delete Person");
			pstmt.setInt(1, sc.nextInt());
			int r = pstmt.executeUpdate();
			System.out.println(r + " Rows Affected");
			pstmt.close();
			con.close();
			System.out.println("Person Removed Successfully...");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void updatePerson() {
		String qry = "update person set name=?, email=?, phone=?, password=?, age=? where id=?";

		try {
			FileInputStream fis = new FileInputStream("person_db.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			Connection con = DriverManager.getConnection(url, p);
			PreparedStatement pstmt = con.prepareStatement(qry);
			System.out.println("Enter The Old ID : ");
			pstmt.setInt(6, sc.nextInt());
			System.out.println("Enter The  Name : ");
			pstmt.setString(1, sc.next());
			System.out.println("Enter The  Email : ");
			pstmt.setString(2, sc.next());
			System.out.println("Enter The Phone : ");
			pstmt.setLong(3, sc.nextLong());
			System.out.println("Enter The Password : ");
			pstmt.setString(4, sc.next());
			System.out.println("Enter The Age : ");
			pstmt.setInt(5, sc.nextInt());
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

	public static void savePerson() {
		String qry = "insert into person values(?,?,?,?,?,?)";

		try {
			FileInputStream fis = new FileInputStream("person_db.properties");
			Properties p = new Properties();
			p.load(fis);
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			Connection con = DriverManager.getConnection(url, p);
			PreparedStatement pstmt = con.prepareStatement(qry);
			System.out.println("Enter The ID : ");
			pstmt.setInt(1, sc.nextInt());
			System.out.println("Enter The Name : ");
			pstmt.setString(2, sc.next());
			System.out.println("Enter The Email : ");
			pstmt.setString(3, sc.next());
			System.out.println("Enter The Phone : ");
			pstmt.setLong(4, sc.nextLong());
			System.out.println("Enter The Password : ");
			pstmt.setString(5, sc.next());
			System.out.println("Enter The Age : ");
			pstmt.setInt(6, sc.nextInt());
			int r = pstmt.executeUpdate();
			System.out.println(r + " Rows Affected");
			pstmt.close();
			con.close();
			System.out.println("Person Registerd Successfully...");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
