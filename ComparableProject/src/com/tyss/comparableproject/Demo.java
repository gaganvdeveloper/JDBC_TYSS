package com.tyss.comparableproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Demo {
	public static void main(String[] args) {
		Comparator<Student> com = (Student s1, Student s2) -> s1.getId() < s2.getId() ? -1 : 1;
//		Comparator<Student> com = (Student s1, Student s2) -> s1.getName().length() < s2.getName().length() ? -1 : 1;
//		Comparator<Student> com = (Student s1, Student s2) -> s1.getName().length() < s2.getName().length() ? -1 : 1;
//		Comparator<Student> com = (Student s1, Student s2) -> s1.getName().length() < s2.getName().length() ? -1 : 1;
		ArrayList<Student> al = new ArrayList<>();
		al.add(new Student(1, "Gagan V", 7813040123l, "gaganvdeveloper@gmail.com"));
		al.add(new Student(4, "Jeevith U", 9978456321l, "jeevith@gmail.com"));
		al.add(new Student(6, "Sandeep Chavan", 9655856455l, "sandeep@gmail.com"));
		al.add(new Student(2, "Shubham Kumar", 98749878989l, "shubham@gmail.com"));
		al.add(new Student(5, "Akshay", 984984984l, "akshay@gmail.com"));
		al.add(new Student(3, "Pava", 9849828248l, "pavan@gmail.com"));

		Collections.sort(al,com);
		for (Student s : al)
			System.out.println(s);

	}

//	public int addAllChars(String s) {
//		int sum = 0;// sandeep
//		s = s.toLowerCase();
//		for (int i = 0; i < s.length(); i++) {
//			sum += s.charAt(i);
//		}
//		return sum;
//	}
}
