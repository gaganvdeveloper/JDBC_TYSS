package com.tyss.connectionpool;

import java.sql.Connection;

public class Test {
	public static void main(String[] args) {
		
		Connection con=ConnectionPool.getConnection();
		System.out.println(con);
		
	}
	
	
	
	
	
	
	
	
}
