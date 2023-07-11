package com.tyss.userapp_filesystem.menu;

import com.tyss.userapp_filesystem.view.UserView;

public class Menu {
	public static UserView view = new UserView();

	public static void main(String[] args) {
		System.out.println("<<<================Welcome to User Application================>>>");
		while (true) {
			System.out.println("Select Option");
			System.out.println("1) Save-User");
			System.out.println("2) Update-User");
			System.out.println("3) find-User-By-Id");
			System.out.println("4) fin-All-Users");
			System.out.println("5) Delete-User");
			switch (UserView.sc.nextInt()) {
			case 1:
				view.saveUser();
				break;
			case 2:
				view.saveUser();//updateUser();
				break;
			case 3:
				view.saveUser();//findUserById();
				break;
			case 4:
				view.findAllUsers();
				break;
			case 5:
				view.saveUser();//deleteUserById();
				break;
			default:
				System.err.println("Invalid Choice...");
				break;
			}
		}
	}
}
