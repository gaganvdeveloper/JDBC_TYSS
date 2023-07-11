package com.tyss.userapp_filesystem.model;

public class Demo {
	public static void main(String[] args) {
		String s = "id=101,name=Gagan,email=gaganvdeveloper@gmail.com";

		splitString(s);
	}

	public static User splitString(String s) {
		String[] sar = s.split(",");
		User u = new User();
		u.setId(Integer.parseInt(getValue(sar[0])));
		u.setName(getValue(sar[1]));
		u.setEmail(getValue(sar[2]));
		return u;
	}

	public static String getValue(String s) {
		String val = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '=') {
				i++;
				while (i < s.length()) {
					val = val + s.charAt(i);
					i++;
				}
			}
		}
		return val;
	}
}
