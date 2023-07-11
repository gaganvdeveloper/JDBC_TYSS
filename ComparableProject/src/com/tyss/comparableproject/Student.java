package com.tyss.comparableproject;

public class Student// implements Comparable<Student>
{
	private int id;
	private String name;
	private long phone;
	private String email;

	public Student(int id, String name, long phone, String email) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\nid=" + id + ", \nname=" + name + ", \nphone=" + phone + ", \nemail=" + email + "\n";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	@Override
//	public int compareTo(Student o) {
//		
//		if (this.name.toLowerCase().charAt(0) > o.getName().toLowerCase().charAt(0)) {
//			return 1;
//		} else if (this.name.toLowerCase().charAt(0) < o.getName().toLowerCase().charAt(0)) {
//			return -1;
//		}
//		return 0;
//	}

}
