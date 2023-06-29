package com.tyss.user.dao;

import java.sql.SQLException;
import java.util.Scanner;

public class TestUserDao {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		UserDao dao = new UserDao();
		System.out.println("Welcome to User Application");
		while (true) {
			System.out.println("Please Select Option");
			System.out.println("1) Register");
			System.out.println("2) Update");
			System.out.println("3) Find-By-Id");
			System.out.println("4) Delete-By-Id");
			System.out.println("5) Find-All-Users");
			System.out.println("6) Exit");

			switch (sc.nextInt()) {

			case 1:
				System.out.println("Enter ID : ");
				int id = sc.nextInt();
				System.out.println("Enter Name : ");
				String name = sc.next();
				System.out.println("Enter Phone : ");
				long phone = sc.nextLong();
				System.out.println("Enter Email : ");
				String email = sc.next();
				System.out.println("Enter Password : ");
				String password = sc.next();
				dao.saveUser(id, name, phone, email, password);
				break;

			case 2:
				System.out.println("Enter ID to Update : ");
				int id1 = sc.nextInt();

				System.out.println("Enter Name to Update : ");
				String name1 = sc.next();

				System.out.println("Enter Phone to Update : ");
				long phone1 = sc.nextLong();
				System.out.println("Enter Email to Update : ");
				String email1 = sc.next();
				System.out.println("Enter Password to Update : ");
				String password1 = sc.next();
				dao.updateUser(id1, name1, phone1, email1, password1);
				break;

			case 3:
				System.out.println("Enter Id to Find User : ");
				int id2 = sc.nextInt();
				dao.findUserById(id2);
				break;

			case 4:
				System.out.println("Enter Id to Delete User : ");
				int id3 = sc.nextInt();
				dao.deleteUserById(id3);
				System.out.println("User Deleted Successfully...");
				break;
				
				
			case 5:
				dao.findAllUsers();
			case 6:
				try {
					dao.con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.exit(0);
				break;

			default:
				System.err.println("Invalid Option");
				break;
			}

		}

	}
}
