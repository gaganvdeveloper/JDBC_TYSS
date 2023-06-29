package com.tyss.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		
		
			System.out.println(verifyUser());
		
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
			System.out.println("Welcome to Virification Menu");
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
