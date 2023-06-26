package com.tyss.items.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class ItemController {
	static FileInputStream fis;
	static String driver;
	static String url;
	static Scanner sc;
	static Properties p;
	static {
		sc = new Scanner(System.in);
		try {
			fis = new FileInputStream("items.properties");
			p = new Properties();
			p.load(fis);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("WELCOME to Item Controller Application");

		while (true) {
			System.out.println("Please Select Option");
			System.out.println("1) Add Item");
			System.out.println("2) Update Item");
			System.out.println("3) Remove Item");
			System.out.println("4) Find Item By ID");
			System.out.println("5) Find All Items");
			System.out.println("6) Exit");

			int choice = sc.nextInt();

			switch (choice) {

			case 1:
				saveItem();
				break;
			case 2:
				updateItem();
				break;
			case 3:
				deleteItem();
				break;
			case 4:
				findById();
				break;
			case 5:
				findAll();
				break;
			case 6:
				System.exit(0);
				break;

			default:
				System.err.println("Invalid Choice");
				break;
			}

		}

	}

	public static void findAll() {

		String qry = "select * from items";
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url, p);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			while (rs.next()) {
				System.out.println("--------------------------------------");
				System.out.println("Id           : " + rs.getInt(1));
				System.out.println("Name         : " + rs.getString(2));
				System.out.println("Quantity     : " + rs.getInt(3));
				System.out.println("Price        : " + rs.getDouble(4));
				System.out.println("Manufacturer : " + rs.getString(5));
				System.out.println("--------------------------------------");
				System.out.println();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void findById() {
		System.out.println("Enter The Item ID to Fetch");
		int id = sc.nextInt();
		String qry = "select * from items where id=" + id + "";

		try {
//			Step 1
			Class.forName(driver);

//			Step 2
			Connection con = DriverManager.getConnection(url, p);

//			Step 3
			Statement stmt = con.createStatement();

//			Step 4
			ResultSet rs = stmt.executeQuery(qry);

//			Step 5
			while (rs.next()) {
				System.out.println("--------------------------------------");
				System.out.println("Id           : " + rs.getInt(1));
				System.out.println("Name         : " + rs.getString(2));
				System.out.println("Quantity     : " + rs.getInt(3));
				System.out.println("Price        : " + rs.getDouble(4));
				System.out.println("Manufacturer : " + rs.getString(5));
				System.out.println("--------------------------------------");
				System.out.println();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void deleteItem() {
		System.out.println("Enter The Item Id to remove");
		int id = sc.nextInt();

		String qry = "delete from items where id=" + id + "";

		try {
//			Step 1
			Class.forName(driver);

//			Step 2
			Connection con = DriverManager.getConnection(url, p);

//			Step 3
			Statement stmt = con.createStatement();

//			Step 4
			stmt.execute(qry);

//			Step 5
			stmt.close();
			con.close();
			System.out.println("Item Removed Successfully...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void updateItem() {
		System.out.println("Please Enter Updated Item Details");
		System.out.println("Enter The Current ID ");
		int id = sc.nextInt();
		System.out.println("Enter The Name");
		String name = sc.next();
		System.out.println("ENter The Quantity");
		int qty = sc.nextInt();
		System.out.println("Enter The Price");
		double price = sc.nextDouble();
		System.out.println("Enter The Manufacturer");
		String manf = sc.next();

		String qry = "update items set name='" + name + "',quantity=" + qty + ",price=" + price + ",manufacturer='"
				+ manf + "' where id=" + id + "";
		try {
//			Step 1
			Class.forName(driver);

//			Step 2
			Connection con = DriverManager.getConnection(url, p);

//			Step 3
			Statement stmt = con.createStatement();

//			Step 4
			int r = stmt.executeUpdate(qry);

//			Step 5
			stmt.close();
			con.close();
			System.out.println("Product Updated Successfully...");
			System.out.println(r + " Rows Affected");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void saveItem() {
		System.out.println("Please Enter Item Details");
		System.out.println("Enter The ID ");
		int id = sc.nextInt();
		System.out.println("Enter The Name");
		String name = sc.next();
		System.out.println("ENter The Quantity");
		int qty = sc.nextInt();
		System.out.println("Enter The Price");
		double price = sc.nextDouble();
		System.out.println("Enter The Manufacturer");
		String manf = sc.next();

		String qry = "insert into items values(" + id + ",'" + name + "'," + qty + "," + price + ",'" + manf + "')";
		try {
//			Step 1
			Class.forName(driver);

//			Step 2
			Connection con = DriverManager.getConnection(url, p);

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
		}

	}

}
