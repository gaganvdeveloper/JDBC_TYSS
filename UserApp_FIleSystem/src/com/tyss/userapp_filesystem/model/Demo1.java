package com.tyss.userapp_filesystem.model;

public class Demo1 {
	
	public static void main(String[] args) {
		
		String s="101,Sandeep_Maheshwari,sandeep@gmail.com";
		
		
		User u = getUser(s);
		
		System.out.println(u);
		
	}

	public static User getUser(String s) {
		String[] sar = s.split(",");
		User u=new User();	
		u.setId(Integer.parseInt(sar[0]));
		u.setName(sar[1]);
		u.setEmail(sar[2]);
		return u;
	}
	
	
	
	
	
}
