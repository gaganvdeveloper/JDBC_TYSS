package com.tyss.userapp_filesystem.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.tyss.userapp_filesystem.controller.UserController;
import com.tyss.userapp_filesystem.model.Demo;
import com.tyss.userapp_filesystem.model.Demo1;
import com.tyss.userapp_filesystem.model.User;

public class UserView {
	public static Scanner sc = new Scanner(System.in);
	public static UserController con = new UserController();

	public User readUser(Scanner sc) {
		User user = new User();
		System.out.println("Enter User ID : ");
		user.setId(sc.nextInt());
		System.out.println("Enter User Name : ");
		user.setName(sc.next());
		System.out.println("Enter User Email : ");
		user.setEmail(sc.next());
		return user;
	}

	public void saveUser() {
		User user = readUser(sc);
		User res_user = con.saveUser(user);
		System.out.println("User saved With ID : " + res_user.getId());
	}

	public void findAllUsers() {

		ArrayList<String> al = con.findAllUsers();
		ArrayList<User> userList = new ArrayList<>();

		for (String s : al) {
			userList.add(getUser(s));
		}

		System.out.println(userList);

	}

	public User getUser(String s) {
		String[] sar = s.split(",");
		User u = new User();
		u.setId(Integer.parseInt(sar[0]));
		u.setName(sar[1]);
		u.setEmail(sar[2]);
		return u;
	}

}
