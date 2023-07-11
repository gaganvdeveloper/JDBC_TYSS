package com.tyss.userapp_filesystem.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.tyss.userapp_filesystem.model.User;

public class UserController {
	public static String filePath = "J:\\TYSS\\Core_Java\\UserApp_FIleSystem\\src\\user_csv_file.csv";

	public User saveUser(User user) {
		try {
			FileOutputStream fos = new FileOutputStream(filePath, true);
			byte[] b = user.toString().getBytes();
			fos.write(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public ArrayList<String> findAllUsers() {
		ArrayList<String> al = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			String line = "";
			while ((line = br.readLine()) != null) {
				al.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return al;
	}

}
