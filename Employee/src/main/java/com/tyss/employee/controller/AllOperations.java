package com.tyss.employee.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AllOperations {
	static Scanner sc = new Scanner(System.in);
	static String url = "jdbc:postgresql://localhost:5432/employee";
	static String user = "postgres";
	static String pass = "root";

	
	
	public static void main(String[] args) {
		System.out.println("Welcome To Employee Application");
		System.out.println();
		while (true) {
			System.out.println("Please Select Your Option");
			System.out.println("1) Register");
			System.out.println("2) Update");
			System.out.println("3) Delete");
			System.out.println("4) findById");
			System.out.println("5) findAll");
			System.out.println("6) Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				saveEmployee();
				break;
			case 2:
				updateEmployee();
				break;
			case 3:
				deleteEmployee();
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
				System.err.println("You Have Chosen Invalid Option");
				break;
			}
		}
	}

	public static void saveEmployee() {
		System.out.println("Enter The Id: ");
		int id = sc.nextInt();
		System.out.println("Enter The Name ");
		String name = sc.nextLine();
		name = sc.nextLine();
		System.out.println("Enter The Email ");
		String email = sc.next();
		System.out.println("Enter The Designation ");
		String desg = sc.nextLine();
		desg = sc.nextLine();
		System.out.println("Enter The Phone Number ");
		long phone = sc.nextLong();
		System.out.println("Enter The Department ");
		String dept = sc.nextLine();
		dept = sc.nextLine();
		System.out.println("Enter The Salary ");
		double salary = sc.nextDouble();
		System.out.println("Enter The Password ");
		String pwd = sc.next();

		String sql = "insert into emp values(" + id + ",'" + name + "','" + email + "','" + desg + "'," + phone + ",'"
				+ dept + "'," + salary + ",'" + pwd + "')";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			stmt.execute(sql);
			con.close();
			System.out.println("Employee Registerd Successfully...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateEmployee() {
		System.out.println("Enter The New Details / Data ");
		System.out.println();
		System.out.println("Enter The Old Id: ");
		int id = sc.nextInt();
		System.out.println("Enter The New  Name ");
		String name = sc.nextLine();
		name = sc.nextLine();
		System.out.println("Enter The NEW Email ");
		String email = sc.next();
		System.out.println("Enter The Designation ");
		String desg = sc.nextLine();
		desg = sc.nextLine();
		System.out.println("Enter The Phone Number ");
		long phone = sc.nextLong();
		System.out.println("Enter The Department ");
		String dept = sc.nextLine();
		dept = sc.nextLine();
		System.out.println("Enter The Salary ");
		double salary = sc.nextDouble();
		System.out.println("Enter The Password ");
		String pwd = sc.next();

		String sql = "update emp set name='" + name + "', email='" + email + "', desg='" + desg + "', phone=" + phone
				+ ", dept='" + dept + "', salary=" + salary + ", password='" + pwd + "' where id=" + id + "";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			stmt.execute(sql);
			con.close();
			System.out.println("Employee Updated Successfully...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void deleteEmployee() {
		System.out.println("Enter The ID TO DELETE The Employee");
		int id = sc.nextInt();

		String sql = "delete from emp where id=" + id + "";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			stmt.execute(sql);
			con.close();
			System.out.println("Employee Deleted Successfully...");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void findById() {
		System.out.println("Enter The Employee ID");
		int eid = sc.nextInt();

		String sql = "select * from emp where id=" + eid + "";

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);

				System.out.println("-----------------------------------------");
				System.out.println();
				System.out.println("ID           : " + id);
				System.out.println("Name         : " + name);
				System.out.println("Email        : " + rs.getString(3));
				System.out.println("Designamtion : " + rs.getString(4));
				System.out.println("Phone        : " + rs.getLong(5));
				System.out.println("Department   : " + rs.getString(6));
				System.out.println("Salary       : " + rs.getDouble(7));
				System.out.println("Password     : " + rs.getString(8));
				System.out.println();
				System.out.println("-----------------------------------------");
				System.out.println();

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void findAll() {

		String sql = "select * from emp";

		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);

				System.out.println("-----------------------------------------");
				System.out.println();
				System.out.println("ID           : " + id);
				System.out.println("Name         : " + name);
				System.out.println("Email        : " + rs.getString(3));
				System.out.println("Designamtion : " + rs.getString(4));
				System.out.println("Phone        : " + rs.getLong(5));
				System.out.println("Department   : " + rs.getString(6));
				System.out.println("Salary       : " + rs.getDouble(7));
				System.out.println("Password     : " + rs.getString(8));
				System.out.println();
				System.out.println("-----------------------------------------");
				System.out.println();

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
